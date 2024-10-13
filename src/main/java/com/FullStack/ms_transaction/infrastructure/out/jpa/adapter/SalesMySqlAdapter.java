package com.FullStack.ms_transaction.infrastructure.out.jpa.adapter;

import com.FullStack.ms_transaction.domain.model.Sales;
import com.FullStack.ms_transaction.domain.spi.ISalesPersistencePort;
import com.FullStack.ms_transaction.infrastructure.out.jpa.mapper.ISalesEntityMapper;
import com.FullStack.ms_transaction.infrastructure.out.jpa.repository.ISalesRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SalesMySqlAdapter implements ISalesPersistencePort {
    private final ISalesRepository salesRepository;
    private final ISalesEntityMapper salesEntityMapper;
    @Override
    public void saveSales(Sales sales) {
        salesRepository.save(salesEntityMapper.toEntity(sales));
    }
}
