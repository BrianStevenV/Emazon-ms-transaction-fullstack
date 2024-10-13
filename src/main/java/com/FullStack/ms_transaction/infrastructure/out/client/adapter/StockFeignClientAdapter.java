package com.FullStack.ms_transaction.infrastructure.out.client.adapter;

import com.FullStack.ms_transaction.domain.model.QuantityStock;
import com.FullStack.ms_transaction.domain.model.ReduceQuantity;
import com.FullStack.ms_transaction.domain.model.SalesProductDetails;
import com.FullStack.ms_transaction.infrastructure.out.client.feign.port.IStockFeignClientExternalPort;
import com.FullStack.ms_transaction.domain.spi.IStockFeignClientPort;
import com.FullStack.ms_transaction.infrastructure.out.client.mapper.feignclient.IStockFeignClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class StockFeignClientAdapter implements IStockFeignClientPort {
    private final IStockFeignClientExternalPort stockFeignClientPort;
    private final IStockFeignClientMapper stockFeignClientMapper;

    @Override
    public boolean updateQuantity(QuantityStock quantityStock) {

        ResponseEntity<Void> response = stockFeignClientPort.updateStockQuantity(stockFeignClientMapper.toQuantityStockFeignClientDto(quantityStock));
        return response.getStatusCode() == HttpStatus.OK;
    }

    @Override
    public boolean cancelQuantity(QuantityStock quantityStock) {
        ResponseEntity<Void> response = stockFeignClientPort.cancelStockQuantity(stockFeignClientMapper.toQuantityStockFeignClientDto(quantityStock));
        return response.getStatusCode() == HttpStatus.OK;
    }


    @Override
    public SalesProductDetails reduceStockQuantity(ReduceQuantity reduceQuantity) {
        return stockFeignClientMapper.toSalesProductDetails(stockFeignClientPort.reduceStockQuantity(stockFeignClientMapper.toReduceQuantityFeignClientDto(reduceQuantity)));
    }

}
