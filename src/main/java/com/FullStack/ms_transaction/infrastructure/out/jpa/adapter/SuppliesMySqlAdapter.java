package com.FullStack.ms_transaction.infrastructure.out.jpa.adapter;

import com.FullStack.ms_transaction.domain.model.Supplies;
import com.FullStack.ms_transaction.domain.spi.ISuppliesPersistencePort;
import com.FullStack.ms_transaction.infrastructure.out.jpa.mapper.ISuppliesEntityMapper;
import com.FullStack.ms_transaction.infrastructure.out.jpa.repository.ISuppliesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
public class SuppliesMySqlAdapter implements ISuppliesPersistencePort {
    private final ISuppliesRepository suppliesRepository;
    private final ISuppliesEntityMapper suppliesEntityMapper;

    @Override
    @Transactional
    public boolean saveSupplies(Supplies supplies) {
        try{
            suppliesRepository.save(suppliesEntityMapper.toSuppliesEntity(supplies));
            return true;
        }   catch (Exception e) {
            return false;
        }

    }

    @Override
    public Date findNextSupplyDateByProductId(long productId) {
        return suppliesRepository.findNextSupplyDateByProductId(productId);
    }
}
