package com.FullStack.ms_transaction.domain.model;

public class QuantityStock {
    Long productId;
    Integer amount;

    public QuantityStock(Long productId, Integer amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
