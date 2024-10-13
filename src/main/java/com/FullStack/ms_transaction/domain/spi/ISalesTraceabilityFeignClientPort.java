package com.FullStack.ms_transaction.domain.spi;

import com.FullStack.ms_transaction.domain.model.SalesReport;

public interface ISalesTraceabilityFeignClientPort {
    void createRecord(SalesReport salesReport);
}
