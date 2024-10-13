package com.FullStack.ms_transaction.Supplies;

import com.FullStack.ms_transaction.application.dto.request.QuantityStockFeignClientDto;
import com.FullStack.ms_transaction.domain.model.QuantityStock;
import com.FullStack.ms_transaction.infrastructure.out.client.adapter.StockFeignClientAdapter;
import com.FullStack.ms_transaction.infrastructure.out.client.feign.port.IStockFeignClientExternalPort;
import com.FullStack.ms_transaction.infrastructure.out.client.mapper.feignclient.IStockFeignClientMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@TestPropertySource(locations = "classpath:application-dev.yml")
@SpringBootTest
public class StockFeignClientAdapterTest {
    @Mock
    private IStockFeignClientExternalPort stockFeignClientPort;

    @Mock
    private IStockFeignClientMapper stockFeignClientMapper;

    private StockFeignClientAdapter stockFeignClientAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        stockFeignClientAdapter = new StockFeignClientAdapter(stockFeignClientPort, stockFeignClientMapper);
    }

    @Test
    void updateQuantity_Success() {
        // Arrange
        QuantityStock quantityStock = new QuantityStock(1L, 10);
        QuantityStockFeignClientDto dto = new QuantityStockFeignClientDto(1L, 10);
        when(stockFeignClientMapper.toQuantityStockFeignClientDto(quantityStock)).thenReturn(dto);
        when(stockFeignClientPort.updateStockQuantity(dto)).thenReturn(ResponseEntity.ok().build());

        // Act
        boolean result = stockFeignClientAdapter.updateQuantity(quantityStock);

        // Assert
        assertTrue(result);
        verify(stockFeignClientMapper).toQuantityStockFeignClientDto(quantityStock);
        verify(stockFeignClientPort).updateStockQuantity(dto);
    }

    @Test
    void updateQuantity_Failure() {
        // Arrange
        QuantityStock quantityStock = new QuantityStock(1L, 10);
        QuantityStockFeignClientDto dto = new QuantityStockFeignClientDto(1L, 10);
        when(stockFeignClientMapper.toQuantityStockFeignClientDto(quantityStock)).thenReturn(dto);
        when(stockFeignClientPort.updateStockQuantity(dto)).thenReturn(ResponseEntity.badRequest().build());

        // Act
        boolean result = stockFeignClientAdapter.updateQuantity(quantityStock);

        // Assert
        assertFalse(result);
        verify(stockFeignClientMapper).toQuantityStockFeignClientDto(quantityStock);
        verify(stockFeignClientPort).updateStockQuantity(dto);
    }

    @Test
    void cancelQuantity_Success() {
        // Arrange
        QuantityStock quantityStock = new QuantityStock(1L, 10);
        QuantityStockFeignClientDto dto = new QuantityStockFeignClientDto(1L, 10);
        when(stockFeignClientMapper.toQuantityStockFeignClientDto(quantityStock)).thenReturn(dto);
        when(stockFeignClientPort.cancelStockQuantity(dto)).thenReturn(ResponseEntity.ok().build());

        // Act
        boolean result = stockFeignClientAdapter.cancelQuantity(quantityStock);

        // Assert
        assertTrue(result);
        verify(stockFeignClientMapper).toQuantityStockFeignClientDto(quantityStock);
        verify(stockFeignClientPort).cancelStockQuantity(dto);
    }

    @Test
    void cancelQuantity_Failure() {
        // Arrange
        QuantityStock quantityStock = new QuantityStock(1L, 10);
        QuantityStockFeignClientDto dto = new QuantityStockFeignClientDto(1L, 10);
        when(stockFeignClientMapper.toQuantityStockFeignClientDto(quantityStock)).thenReturn(dto);
        when(stockFeignClientPort.cancelStockQuantity(dto)).thenReturn(ResponseEntity.badRequest().build());

        // Act
        boolean result = stockFeignClientAdapter.cancelQuantity(quantityStock);

        // Assert
        assertFalse(result);
        verify(stockFeignClientMapper).toQuantityStockFeignClientDto(quantityStock);
        verify(stockFeignClientPort).cancelStockQuantity(dto);
    }

    @Test
    void updateQuantity_NullResponse() {
        // Arrange
        QuantityStock quantityStock = new QuantityStock(1L, 10);
        QuantityStockFeignClientDto dto = new QuantityStockFeignClientDto(1L, 10);
        when(stockFeignClientMapper.toQuantityStockFeignClientDto(quantityStock)).thenReturn(dto);
        when(stockFeignClientPort.updateStockQuantity(dto)).thenReturn(null);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> stockFeignClientAdapter.updateQuantity(quantityStock));
        verify(stockFeignClientMapper).toQuantityStockFeignClientDto(quantityStock);
        verify(stockFeignClientPort).updateStockQuantity(dto);
    }

    @Test
    void cancelQuantity_NullResponse() {
        // Arrange
        QuantityStock quantityStock = new QuantityStock(1L, 10);
        QuantityStockFeignClientDto dto = new QuantityStockFeignClientDto(1L, 10);
        when(stockFeignClientMapper.toQuantityStockFeignClientDto(quantityStock)).thenReturn(dto);
        when(stockFeignClientPort.cancelStockQuantity(dto)).thenReturn(null);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> stockFeignClientAdapter.cancelQuantity(quantityStock));
        verify(stockFeignClientMapper).toQuantityStockFeignClientDto(quantityStock);
        verify(stockFeignClientPort).cancelStockQuantity(dto);
    }
}
