package com.FullStack.ms_transaction.domain.model;

import java.time.LocalDateTime;

public class Sales {
    private long id;
    private Double subtotal;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private long userId;
    private long cartId;

    public Sales(long id, Double subtotal, LocalDateTime createdAt, LocalDateTime updatedAt, long userId, long cartId) {
        this.id = id;
        this.subtotal = subtotal;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
        this.cartId = cartId;
    }

    public Sales() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }
}
