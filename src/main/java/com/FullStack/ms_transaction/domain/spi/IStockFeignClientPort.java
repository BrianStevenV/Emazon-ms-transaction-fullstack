package com.FullStack.ms_transaction.domain.spi;

import com.FullStack.ms_transaction.domain.model.QuantityStock;
import com.FullStack.ms_transaction.domain.model.ReduceQuantity;
import com.FullStack.ms_transaction.domain.model.SalesProductDetails;

public interface IStockFeignClientPort {
    boolean updateQuantity(QuantityStock quantityStock);
    boolean cancelQuantity(QuantityStock quantityStock);


    SalesProductDetails reduceStockQuantity(ReduceQuantity reduceQuantity);
}
