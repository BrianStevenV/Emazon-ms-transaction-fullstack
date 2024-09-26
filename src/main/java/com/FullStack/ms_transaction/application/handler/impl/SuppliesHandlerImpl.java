package com.FullStack.ms_transaction.application.handler.impl;

import com.FullStack.ms_transaction.application.dto.SuppliesRequestDto;
import com.FullStack.ms_transaction.application.handler.ISuppliesHandler;
import com.FullStack.ms_transaction.application.mapper.ISuppliesRequestMapper;
import com.FullStack.ms_transaction.domain.api.ISuppliesServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SuppliesHandlerImpl implements ISuppliesHandler {
    private final ISuppliesServicePort suppliesServicePort;
    private final ISuppliesRequestMapper suppliesRequestMapper;

    @Override
    public void addSupplies(SuppliesRequestDto suppliesRequest) {
        suppliesServicePort.addSupplies(suppliesRequestMapper.toSupplies(suppliesRequest));
    }
}
