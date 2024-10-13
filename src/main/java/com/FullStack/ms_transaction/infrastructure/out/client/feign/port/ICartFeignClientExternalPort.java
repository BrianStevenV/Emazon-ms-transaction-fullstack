package com.FullStack.ms_transaction.infrastructure.out.client.feign.port;

import com.FullStack.ms_transaction.application.dto.request.ProductsIdsFeignClientDto;
import com.FullStack.ms_transaction.application.dto.response.CartDetailsResponseDto;
import com.FullStack.ms_transaction.infrastructure.configuration.feign.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.FullStack.ms_transaction.infrastructure.out.client.utils.FeignClientConstants.CART_BASE_HOST;
import static com.FullStack.ms_transaction.infrastructure.out.client.utils.FeignClientConstants.CART_CONTROLLER_DELETE_CART;
import static com.FullStack.ms_transaction.infrastructure.out.client.utils.FeignClientConstants.CART_CONTROLLER_GET_LIST_CART_DETAILS;
import static com.FullStack.ms_transaction.infrastructure.out.client.utils.FeignClientConstants.CART_REST_CONTROLLER_PATH_VARIABLE_USER_ID;
import static com.FullStack.ms_transaction.infrastructure.out.client.utils.FeignClientConstants.CART_SERVICE;

@FeignClient(name = CART_SERVICE, url = CART_BASE_HOST, configuration = FeignClientConfig.class)
public interface ICartFeignClientExternalPort {

    @GetMapping(CART_CONTROLLER_GET_LIST_CART_DETAILS)
    List<CartDetailsResponseDto> getProductsInCart(@PathVariable(CART_REST_CONTROLLER_PATH_VARIABLE_USER_ID) long userId);

    @DeleteMapping(CART_CONTROLLER_DELETE_CART)
    void deleteCart(@PathVariable(CART_REST_CONTROLLER_PATH_VARIABLE_USER_ID) long userId, @RequestBody ProductsIdsFeignClientDto productsIds);
}
