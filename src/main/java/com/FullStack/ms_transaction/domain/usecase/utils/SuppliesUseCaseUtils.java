package com.FullStack.ms_transaction.domain.usecase.utils;

import com.FullStack.ms_transaction.domain.exception.AmountAvailableIsGreaterThanAmountTotalException;
import com.FullStack.ms_transaction.domain.model.Supplies;
import com.FullStack.ms_transaction.infrastructure.security.utils.IContextService;

import java.time.LocalDateTime;


public class SuppliesUseCaseUtils {

    private final IContextService contextService;

    public SuppliesUseCaseUtils(IContextService contextService) {
        this.contextService = contextService;
    }

    public int quantityTransactionToStock(Integer amountTotal, Integer amountAvailable) {

        if(amountTotal >= amountAvailable) {
            int quantitySupply = amountTotal - amountAvailable;
            return quantitySupply;
        } else {
            throw new AmountAvailableIsGreaterThanAmountTotalException();
        }

    }

    public void setCreationTimestamp(Supplies supplies) {
        LocalDateTime now = LocalDateTime.now();
        supplies.setCreatedAt(now);
        supplies.setUpdatedAt(now);
    }


    public void setUpdateTimestamp(Supplies supplies) {
        supplies.setUpdatedAt(LocalDateTime.now());
    }

    public long getIdFromUserContextService(){
        return contextService.getAuthenticationId();
    }


}
