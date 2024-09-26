package com.FullStack.ms_transaction.domain.spi;

import com.FullStack.ms_transaction.domain.model.QuantityStock;

public interface IStockFeignClientPort {
    boolean updateQuantity(QuantityStock quantityStock);
    boolean cancelQuantity(QuantityStock quantityStock);
}
