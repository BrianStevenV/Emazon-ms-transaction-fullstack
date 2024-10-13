package com.FullStack.ms_transaction.infrastructure.out.client.adapter;

import com.FullStack.ms_transaction.domain.model.CartDetails;
import com.FullStack.ms_transaction.domain.model.ProductsIds;
import com.FullStack.ms_transaction.domain.spi.ICartFeignClientPort;
import com.FullStack.ms_transaction.infrastructure.out.client.feign.port.ICartFeignClientExternalPort;
import com.FullStack.ms_transaction.infrastructure.out.client.mapper.feignclient.ICartFeignClientMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CartFeignClientAdapter implements ICartFeignClientPort {

    private final ICartFeignClientMapper cartFeignClientMapper;
    private final ICartFeignClientExternalPort cartFeignClientExternalPort;

    @Override
    public List<CartDetails> getProductsInCart(long userId) {
        return cartFeignClientMapper.toCartDetails(cartFeignClientExternalPort.getProductsInCart(userId));
    }

    @Override
    public void deleteCart(long userId, ProductsIds productsIds) {
        cartFeignClientExternalPort.deleteCart(userId, cartFeignClientMapper.toProductsIdsFeignClientDto(productsIds));
    }
}
