package com.FullStack.ms_transaction.domain.spi;

import com.FullStack.ms_transaction.domain.model.SalesDetails;

import java.util.List;

public interface ISalesDetailsPersistencePort {
    void saveSalesDetails(SalesDetails salesProductDetails);
    void savesSalesDetails(List<SalesDetails> salesProductDetailsList);
}
