package com.FullStack.ms_transaction.domain.spi;

import com.FullStack.ms_transaction.domain.model.Supplies;

public interface ISuppliesPersistencePort {
    boolean saveSupplies(Supplies supplies);
}
