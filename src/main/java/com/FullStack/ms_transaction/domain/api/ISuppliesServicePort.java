package com.FullStack.ms_transaction.domain.api;

import com.FullStack.ms_transaction.domain.model.Supplies;

import java.util.Date;

public interface ISuppliesServicePort {
    void addSupplies(Supplies supplies);
    Date getNextDateSupply(long productId);
}
