package com.FullStack.ms_transaction.domain.usecase;

import com.FullStack.ms_transaction.domain.api.ISuppliesServicePort;
import com.FullStack.ms_transaction.domain.exception.FeignClientStockException;
import com.FullStack.ms_transaction.domain.exception.ProductNotFoundException;
import com.FullStack.ms_transaction.domain.exception.SaveSupplyException;
import com.FullStack.ms_transaction.domain.exception.StatusIsNotApprovedException;
import com.FullStack.ms_transaction.domain.model.EnumStatus;
import com.FullStack.ms_transaction.domain.model.QuantityStock;
import com.FullStack.ms_transaction.domain.model.Supplies;
import com.FullStack.ms_transaction.domain.spi.ISuppliesPersistencePort;
import com.FullStack.ms_transaction.domain.usecase.utils.UseCaseUtils;
import com.FullStack.ms_transaction.domain.spi.IStockFeignClientPort;

import java.util.Date;

public class SuppliesUseCase implements ISuppliesServicePort {
    private final ISuppliesPersistencePort suppliesPersistencePort;
    private final IStockFeignClientPort stockExternalPort;
    private final UseCaseUtils useCaseUtils;

    public SuppliesUseCase(ISuppliesPersistencePort suppliesPersistencePort, IStockFeignClientPort stockExternalPort, UseCaseUtils useCaseUtils) {
        this.suppliesPersistencePort = suppliesPersistencePort;
        this.stockExternalPort = stockExternalPort;
        this.useCaseUtils = useCaseUtils;
    }

    @Override
    public void addSupplies(Supplies supplies) {
        setTimestamps(supplies);
        supplies.setStatus(EnumStatus.PENDING);
        supplies.setUserId(useCaseUtils.getIdFromUserContextService());

        QuantityStock quantityStock = new QuantityStock(supplies.getProductId(),
                useCaseUtils.quantityTransactionToStock(supplies.getQuantityTotal(),
                        supplies.getQuantityAvailable()));

        if(supplies.getIsAvailable() == true) {
            updateStockOrThrow(quantityStock);
        }

        supplies.setStatus(EnumStatus.APPROVED);
        requiredStatusToSave(supplies, quantityStock);

    }

    @Override
    public Date getNextDateSupply(long productId) {
        Date date = suppliesPersistencePort.findNextSupplyDateByProductId(productId);
        if(date == null){
            throw new ProductNotFoundException();
        }
        return date;
    }

    private void  requiredStatusToSave(Supplies supplies, QuantityStock quantityStock) {
        if(supplies.getStatus().equals(EnumStatus.APPROVED)) {
            saveSuppliesOrRollback(supplies, quantityStock);
        }   else{
            throw new StatusIsNotApprovedException();
        }
    }

    private void setTimestamps(Supplies supplies) {
        if (supplies.getCreatedAt() == null) {
            useCaseUtils.setCreationTimestamp(supplies);
        }
        useCaseUtils.setUpdateTimestamp(supplies);
    }

    private void updateStockOrThrow(QuantityStock quantityStock) {
        boolean stockUpdated = stockExternalPort.updateQuantity(quantityStock);
        if (!stockUpdated) {
            throw new FeignClientStockException();
        }
    }

    private void saveSuppliesOrRollback(Supplies supplies, QuantityStock quantityStock) {
        boolean supplySaved = suppliesPersistencePort.saveSupplies(supplies);
        if (!supplySaved) {
            stockExternalPort.cancelQuantity(quantityStock);
            throw new SaveSupplyException();
        }
    }

}
