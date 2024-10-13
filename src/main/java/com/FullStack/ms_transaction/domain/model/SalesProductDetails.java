package com.FullStack.ms_transaction.domain.model;

import java.util.List;

public class SalesProductDetails {
    List<ProductSales> products;
    double subtotal;

    public SalesProductDetails(List<ProductSales> products, double subtotal) {
        this.products = products;
        this.subtotal = subtotal;
    }

    public SalesProductDetails() {
    }

    public List<ProductSales> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSales> products) {
        this.products = products;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
