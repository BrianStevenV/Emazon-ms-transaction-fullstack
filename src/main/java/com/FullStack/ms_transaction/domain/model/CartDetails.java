package com.FullStack.ms_transaction.domain.model;

public class CartDetails {
    private long id;
    private int amount;
    private long productId;
    private long cartId;

    public CartDetails(long id, int amount, long productId, long cartId) {
        this.id = id;
        this.amount = amount;
        this.productId = productId;
        this.cartId = cartId;
    }

    public CartDetails(){};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }
}
