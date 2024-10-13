package com.FullStack.ms_transaction.domain.model;

public class ProductSales {
    long productId;
    int amount;
    double price;

    public ProductSales(long productId, int amount, double price) {
        this.productId = productId;
        this.amount = amount;
        this.price = price;
    }

    public ProductSales() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
