package com.FullStack.ms_transaction.Sales;

import com.FullStack.ms_transaction.domain.model.CartDetails;
import com.FullStack.ms_transaction.domain.model.ProductSales;
import com.FullStack.ms_transaction.domain.model.QuantityStock;
import com.FullStack.ms_transaction.domain.model.ReduceQuantity;
import com.FullStack.ms_transaction.domain.model.Sales;
import com.FullStack.ms_transaction.domain.model.SalesProductDetails;
import com.FullStack.ms_transaction.domain.spi.ICartFeignClientPort;
import com.FullStack.ms_transaction.domain.spi.ISalesDetailsPersistencePort;
import com.FullStack.ms_transaction.domain.spi.ISalesPersistencePort;
import com.FullStack.ms_transaction.domain.spi.ISalesTraceabilityFeignClientPort;
import com.FullStack.ms_transaction.domain.spi.IStockFeignClientPort;
import com.FullStack.ms_transaction.domain.usecase.SalesUseCase;
import com.FullStack.ms_transaction.domain.usecase.utils.UseCaseUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SalesUseCaseTest {
    @Mock
    private ISalesPersistencePort salesPersistencePort;

    @Mock
    private ISalesDetailsPersistencePort salesDetailsPersistencePort;

    @Mock
    private ISalesTraceabilityFeignClientPort salesTraceabilityFeignClientPort;

    @Mock
    private IStockFeignClientPort stockExternalPort;

    @Mock
    private ICartFeignClientPort cartExternalPort;

    @Mock
    private UseCaseUtils useCaseUtils;

    private SalesUseCase salesUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        salesUseCase = new SalesUseCase(salesPersistencePort, salesDetailsPersistencePort, salesTraceabilityFeignClientPort, stockExternalPort, cartExternalPort, useCaseUtils);
    }

    @Test
    void buyCart_executesSuccessfully() {
        List<CartDetails> productsInCart = Collections.singletonList(new CartDetails(1L, 10, 2L, 2L));
        List<QuantityStock> quantityStockList = Collections.singletonList(new QuantityStock(1L, 2));
        SalesProductDetails salesProductDetails = new SalesProductDetails(Collections.singletonList(new ProductSales(1L, 2, 10.0)), 20.0);

        when(cartExternalPort.getProductsInCart(anyLong())).thenReturn(productsInCart);
        when(stockExternalPort.reduceStockQuantity(any(ReduceQuantity.class))).thenReturn(salesProductDetails);
        when(useCaseUtils.getIdFromUserContextService()).thenReturn(1L);

        salesUseCase.buyCart();

        verify(cartExternalPort).getProductsInCart(anyLong());
        verify(stockExternalPort).reduceStockQuantity(any(ReduceQuantity.class));
        verify(cartExternalPort).deleteCart(anyLong(), any());
        verify(salesPersistencePort).saveSales(any(Sales.class));
        verify(salesDetailsPersistencePort).savesSalesDetails(anyList());
        verify(salesTraceabilityFeignClientPort).createRecord(any());
    }

    @Test
    void buyCart_throwsExceptionWhenCartIsEmpty() {
        when(cartExternalPort.getProductsInCart(anyLong())).thenReturn(Collections.emptyList());
        when(useCaseUtils.getIdFromUserContextService()).thenReturn(1L);

        assertThrows(IndexOutOfBoundsException.class, () -> salesUseCase.buyCart());
    }
}
