package com.FullStack.ms_transaction.Client;

import com.FullStack.ms_transaction.domain.model.CartDetails;
import com.FullStack.ms_transaction.domain.model.ProductsIds;
import com.FullStack.ms_transaction.infrastructure.out.client.adapter.CartFeignClientAdapter;
import com.FullStack.ms_transaction.infrastructure.out.client.feign.port.ICartFeignClientExternalPort;
import com.FullStack.ms_transaction.infrastructure.out.client.mapper.feignclient.ICartFeignClientMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CartFeignClientAdapterTest {

    @Mock
    private ICartFeignClientMapper cartFeignClientMapper;

    @Mock
    private ICartFeignClientExternalPort cartFeignClientExternalPort;

    private CartFeignClientAdapter cartFeignClientAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cartFeignClientAdapter = new CartFeignClientAdapter(cartFeignClientMapper, cartFeignClientExternalPort);
    }

    @Test
    void getProductsInCart_returnsEmptyListWhenNoProducts() {
        when(cartFeignClientExternalPort.getProductsInCart(anyLong())).thenReturn(Collections.emptyList());
        when(cartFeignClientMapper.toCartDetails(anyList())).thenReturn(Collections.emptyList());

        List<CartDetails> result = cartFeignClientAdapter.getProductsInCart(1L);

        assertEquals(Collections.emptyList(), result);
        verify(cartFeignClientExternalPort).getProductsInCart(1L);
        verify(cartFeignClientMapper).toCartDetails(anyList());
    }

    @Test
    void deleteCart_executesSuccessfully() {
        ProductsIds productsIds = new ProductsIds();
        doNothing().when(cartFeignClientExternalPort).deleteCart(anyLong(), any());

        cartFeignClientAdapter.deleteCart(1L, productsIds);

        verify(cartFeignClientExternalPort).deleteCart(1L, any());
        verify(cartFeignClientMapper).toProductsIdsFeignClientDto(productsIds);
    }

    @Test
    void deleteCart_throwsExceptionWhenDeleteFails() {
        ProductsIds productsIds = new ProductsIds();
        doThrow(new RuntimeException()).when(cartFeignClientExternalPort).deleteCart(anyLong(), any());

        assertThrows(RuntimeException.class, () -> cartFeignClientAdapter.deleteCart(1L, productsIds));
    }
}
