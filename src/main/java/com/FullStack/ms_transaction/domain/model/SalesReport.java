package com.FullStack.ms_transaction.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class SalesReport {
    private long cartId;
    private List<ProductSales> cartDetails;
    private double subtotal;
    private LocalDateTime purchaseDate;

    public SalesReport(long cartId, List<ProductSales> cartDetails, double subtotal, LocalDateTime purchaseDate) {
        this.cartId = cartId;
        this.cartDetails = cartDetails;
        this.subtotal = subtotal;
        this.purchaseDate = purchaseDate;
    }

    public SalesReport() {
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public List<ProductSales> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<ProductSales> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
