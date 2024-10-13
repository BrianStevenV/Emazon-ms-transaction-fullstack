package com.FullStack.ms_transaction.application.handler.impl;

import com.FullStack.ms_transaction.application.dto.SuppliesRequestDto;
import com.FullStack.ms_transaction.application.dto.response.NextDateSupplyResponseDto;
import com.FullStack.ms_transaction.application.handler.ISuppliesHandler;
import com.FullStack.ms_transaction.application.mapper.ISuppliesRequestMapper;
import com.FullStack.ms_transaction.domain.api.ISuppliesServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.FullStack.ms_transaction.application.utils.ConstantsHandler.DATE_FORMAT;

@Service
@RequiredArgsConstructor
public class SuppliesHandlerImpl implements ISuppliesHandler {
    private final ISuppliesServicePort suppliesServicePort;
    private final ISuppliesRequestMapper suppliesRequestMapper;

    @Override
    public void addSupplies(SuppliesRequestDto suppliesRequest) {
        suppliesServicePort.addSupplies(suppliesRequestMapper.toSupplies(suppliesRequest));
    }

    @Override
    public NextDateSupplyResponseDto getNextDateSupply(long productId) {
//        return new NextDateSupplyResponseDto(new SimpleDateFormat("yyyy-MM-dd").format(suppliesServicePort.getNextDateSupply(productId)));
        Date nextSupplyDate = suppliesServicePort.getNextDateSupply(productId);

        String formattedDate = new SimpleDateFormat(DATE_FORMAT).format(nextSupplyDate);

        return new NextDateSupplyResponseDto(formattedDate);
    }
}
