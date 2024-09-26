package com.FullStack.ms_transaction.infrastructure.out.client.mapper.feignclient;

import com.FullStack.ms_transaction.application.dto.request.QuantityStockFeignClientDto;
import com.FullStack.ms_transaction.domain.model.QuantityStock;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IStockFeignClientMapper {

    QuantityStockFeignClientDto toQuantityStockFeignClientDto(QuantityStock quantityStock);
}
