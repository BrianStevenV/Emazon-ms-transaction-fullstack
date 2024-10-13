package com.FullStack.ms_transaction.domain.spi;

import com.FullStack.ms_transaction.domain.model.Sales;

public interface ISalesPersistencePort {
    void saveSales(Sales sales);
}
