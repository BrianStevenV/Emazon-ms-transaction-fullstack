package com.FullStack.ms_transaction.Sales;

import com.FullStack.ms_transaction.domain.model.Sales;
import com.FullStack.ms_transaction.infrastructure.out.jpa.adapter.SalesMySqlAdapter;
import com.FullStack.ms_transaction.infrastructure.out.jpa.entities.SalesEntity;
import com.FullStack.ms_transaction.infrastructure.out.jpa.mapper.ISalesEntityMapper;
import com.FullStack.ms_transaction.infrastructure.out.jpa.repository.ISalesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SalesMySqlAdapterTest {
    @Mock
    private ISalesRepository salesRepository;

    @Mock
    private ISalesEntityMapper salesEntityMapper;

    private SalesMySqlAdapter salesMySqlAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        salesMySqlAdapter = new SalesMySqlAdapter(salesRepository, salesEntityMapper);
    }

    @Test
    void saveSales_executesSuccessfully() {
        Sales sales = new Sales();
        when(salesEntityMapper.toEntity(any(Sales.class))).thenReturn(new SalesEntity());

        salesMySqlAdapter.saveSales(sales);

        verify(salesRepository).save(any(SalesEntity.class));
    }

    @Test
    void saveSales_throwsExceptionWhenSaveFails() {
        Sales sales = new Sales();
        when(salesEntityMapper.toEntity(any(Sales.class))).thenReturn(new SalesEntity());
        doThrow(new RuntimeException()).when(salesRepository).save(any(SalesEntity.class));

        assertThrows(RuntimeException.class, () -> salesMySqlAdapter.saveSales(sales));
    }
}
