package com.FullStack.ms_transaction.domain.model;

import java.util.List;

public class ProductsIds {
    private List<Long> productsIds;

    public ProductsIds(List<Long> productsIds) {
        this.productsIds = productsIds;
    }

    public ProductsIds() {
    }

    public List<Long> getProductsIds() {
        return productsIds;
    }

    public void setProductsIds(List<Long> productsIds) {
        this.productsIds = productsIds;
    }
}
