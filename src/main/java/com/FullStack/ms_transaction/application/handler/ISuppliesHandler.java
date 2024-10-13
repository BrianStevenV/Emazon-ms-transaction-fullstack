package com.FullStack.ms_transaction.application.handler;

import com.FullStack.ms_transaction.application.dto.SuppliesRequestDto;
import com.FullStack.ms_transaction.application.dto.response.NextDateSupplyResponseDto;

public interface ISuppliesHandler {
    void addSupplies(SuppliesRequestDto suppliesRequest);
    NextDateSupplyResponseDto getNextDateSupply(long productId);
}
