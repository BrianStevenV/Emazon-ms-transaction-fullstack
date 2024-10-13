package com.FullStack.ms_transaction.infrastructure.out.client.adapter;

import com.FullStack.ms_transaction.domain.model.SalesReport;
import com.FullStack.ms_transaction.domain.spi.ISalesTraceabilityFeignClientPort;
import com.FullStack.ms_transaction.infrastructure.out.client.feign.port.ISalesTraceabilityFeignClientExternalPort;
import com.FullStack.ms_transaction.infrastructure.out.client.mapper.feignclient.ITraceabilityFeignClientMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SalesTraceabilityFeignClientAdapter implements ISalesTraceabilityFeignClientPort {

    private final ISalesTraceabilityFeignClientExternalPort salesTraceabilityFeignClientExternalPort;
    private final ITraceabilityFeignClientMapper traceabilityFeignClientMapper;
    @Override
    public void createRecord(SalesReport salesReport) {
        salesTraceabilityFeignClientExternalPort.createRecord(traceabilityFeignClientMapper.toSalesReportFeignClientDto(salesReport));
    }
}
