package com.FullStack.ms_transaction.infrastructure.out.client.mapper.feignclient;

import com.FullStack.ms_transaction.application.dto.request.QuantityStockFeignClientDto;
import com.FullStack.ms_transaction.application.dto.request.ReduceQuantityFeignClientDto;
import com.FullStack.ms_transaction.application.dto.response.SaleFeignClientResponseDto;
import com.FullStack.ms_transaction.domain.model.QuantityStock;
import com.FullStack.ms_transaction.domain.model.ReduceQuantity;
import com.FullStack.ms_transaction.domain.model.SalesProductDetails;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IStockFeignClientMapper {

    QuantityStockFeignClientDto toQuantityStockFeignClientDto(QuantityStock quantityStock);
    SalesProductDetails toSalesProductDetails(SaleFeignClientResponseDto saleFeignClientResponseDto);
    ReduceQuantityFeignClientDto toReduceQuantityFeignClientDto(ReduceQuantity reduceQuantity);
}
