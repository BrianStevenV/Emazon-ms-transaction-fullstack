package com.FullStack.ms_transaction.infrastructure.out.jpa.adapter;

import com.FullStack.ms_transaction.domain.model.SalesDetails;
import com.FullStack.ms_transaction.domain.spi.ISalesDetailsPersistencePort;
import com.FullStack.ms_transaction.infrastructure.out.jpa.mapper.ISalesDetailsEntityMapper;
import com.FullStack.ms_transaction.infrastructure.out.jpa.repository.ISalesDetailsRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class SalesDetailsMySqlAdapter implements ISalesDetailsPersistencePort {
    private final ISalesDetailsRepository salesDetailsRepository;
    private final ISalesDetailsEntityMapper salesDetailsEntityMapper;
    @Override
    public void saveSalesDetails(SalesDetails salesProductDetails) {
        salesDetailsRepository.save(salesDetailsEntityMapper.toEntity(salesProductDetails));
    }

    @Override
    public void savesSalesDetails(List<SalesDetails> salesProductDetailsList) {
        salesDetailsRepository.saveAll(salesDetailsEntityMapper.toEntityList(salesProductDetailsList));
    }
}
