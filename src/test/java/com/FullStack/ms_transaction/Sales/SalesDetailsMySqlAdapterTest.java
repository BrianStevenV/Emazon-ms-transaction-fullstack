package com.FullStack.ms_transaction.Sales;

import com.FullStack.ms_transaction.domain.model.SalesDetails;
import com.FullStack.ms_transaction.infrastructure.out.jpa.adapter.SalesDetailsMySqlAdapter;
import com.FullStack.ms_transaction.infrastructure.out.jpa.entities.SalesDetailsEntity;
import com.FullStack.ms_transaction.infrastructure.out.jpa.mapper.ISalesDetailsEntityMapper;
import com.FullStack.ms_transaction.infrastructure.out.jpa.repository.ISalesDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SalesDetailsMySqlAdapterTest {

    @Mock
    private ISalesDetailsRepository salesDetailsRepository;

    @Mock
    private ISalesDetailsEntityMapper salesDetailsEntityMapper;

    private SalesDetailsMySqlAdapter salesDetailsMySqlAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        salesDetailsMySqlAdapter = new SalesDetailsMySqlAdapter(salesDetailsRepository, salesDetailsEntityMapper);
    }

    @Test
    void saveSalesDetails_executesSuccessfully() {
        SalesDetails salesDetails = new SalesDetails();
        when(salesDetailsEntityMapper.toEntity(any(SalesDetails.class))).thenReturn(new SalesDetailsEntity());

        salesDetailsMySqlAdapter.saveSalesDetails(salesDetails);

        verify(salesDetailsRepository).save(any(SalesDetailsEntity.class));
    }

    @Test
    void saveSalesDetails_throwsExceptionWhenSaveFails() {
        SalesDetails salesDetails = new SalesDetails();
        when(salesDetailsEntityMapper.toEntity(any(SalesDetails.class))).thenReturn(new SalesDetailsEntity());
        doThrow(new RuntimeException()).when(salesDetailsRepository).save(any(SalesDetailsEntity.class));

        assertThrows(RuntimeException.class, () -> salesDetailsMySqlAdapter.saveSalesDetails(salesDetails));
    }

    @Test
    void savesSalesDetails_executesSuccessfully() {
        List<SalesDetails> salesDetailsList = Collections.singletonList(new SalesDetails());
        when(salesDetailsEntityMapper.toEntityList(any(List.class))).thenReturn(Collections.singletonList(new SalesDetailsEntity()));

        salesDetailsMySqlAdapter.savesSalesDetails(salesDetailsList);

        verify(salesDetailsRepository).saveAll(any(List.class));
    }

    @Test
    void savesSalesDetails_throwsExceptionWhenSaveAllFails() {
        List<SalesDetails> salesDetailsList = Collections.singletonList(new SalesDetails());
        when(salesDetailsEntityMapper.toEntityList(any(List.class))).thenReturn(Collections.singletonList(new SalesDetailsEntity()));
        doThrow(new RuntimeException()).when(salesDetailsRepository).saveAll(any(List.class));

        assertThrows(RuntimeException.class, () -> salesDetailsMySqlAdapter.savesSalesDetails(salesDetailsList));
    }
}
