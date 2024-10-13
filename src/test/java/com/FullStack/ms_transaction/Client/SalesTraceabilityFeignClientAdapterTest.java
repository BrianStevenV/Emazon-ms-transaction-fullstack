package com.FullStack.ms_transaction.Client;

import com.FullStack.ms_transaction.domain.model.SalesReport;
import com.FullStack.ms_transaction.infrastructure.out.client.adapter.SalesTraceabilityFeignClientAdapter;
import com.FullStack.ms_transaction.infrastructure.out.client.feign.port.ISalesTraceabilityFeignClientExternalPort;
import com.FullStack.ms_transaction.infrastructure.out.client.mapper.feignclient.ITraceabilityFeignClientMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class SalesTraceabilityFeignClientAdapterTest {
    @Mock
    private ISalesTraceabilityFeignClientExternalPort salesTraceabilityFeignClientExternalPort;

    @Mock
    private ITraceabilityFeignClientMapper traceabilityFeignClientMapper;

    private SalesTraceabilityFeignClientAdapter salesTraceabilityFeignClientAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        salesTraceabilityFeignClientAdapter = new SalesTraceabilityFeignClientAdapter(salesTraceabilityFeignClientExternalPort, traceabilityFeignClientMapper);
    }

    @Test
    void createRecord_executesSuccessfully() {
        SalesReport salesReport = new SalesReport();
        salesTraceabilityFeignClientAdapter.createRecord(salesReport);
        verify(salesTraceabilityFeignClientExternalPort).createRecord(any());
    }

    @Test
    void createRecord_throwsExceptionWhenCreateFails() {
        SalesReport salesReport = new SalesReport();
        doThrow(new RuntimeException()).when(salesTraceabilityFeignClientExternalPort).createRecord(any());
        assertThrows(RuntimeException.class, () -> salesTraceabilityFeignClientAdapter.createRecord(salesReport));
    }
}
