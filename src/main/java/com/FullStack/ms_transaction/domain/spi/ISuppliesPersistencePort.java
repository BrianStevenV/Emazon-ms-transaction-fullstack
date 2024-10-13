package com.FullStack.ms_transaction.domain.spi;

import com.FullStack.ms_transaction.domain.model.Supplies;

import java.util.Date;

public interface ISuppliesPersistencePort {
    boolean saveSupplies(Supplies supplies);
    Date findNextSupplyDateByProductId(long productId);
}
