package com.FullStack.ms_transaction.domain.model;

import java.util.List;

public class ReduceQuantity {
    List<QuantityStock> quantityStockList;

    public ReduceQuantity(List<QuantityStock> quantityStockList) {
        this.quantityStockList = quantityStockList;
    }

    public List<QuantityStock> getQuantityStockList() {
        return quantityStockList;
    }

    public void setQuantityStockList(List<QuantityStock> quantityStockList) {
        this.quantityStockList = quantityStockList;
    }
}
