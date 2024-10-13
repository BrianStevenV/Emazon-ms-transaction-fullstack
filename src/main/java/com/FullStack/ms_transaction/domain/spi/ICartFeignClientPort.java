package com.FullStack.ms_transaction.domain.spi;

import com.FullStack.ms_transaction.domain.model.CartDetails;
import com.FullStack.ms_transaction.domain.model.ProductsIds;

import java.util.List;

public interface ICartFeignClientPort {
    List<CartDetails> getProductsInCart(long userId);
    void deleteCart(long userId, ProductsIds productsIds);
}
