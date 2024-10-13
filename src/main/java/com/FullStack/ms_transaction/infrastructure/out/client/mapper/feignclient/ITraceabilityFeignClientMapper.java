package com.FullStack.ms_transaction.infrastructure.out.client.mapper.feignclient;

import com.FullStack.ms_transaction.application.dto.request.SalesReportFeignClientDto;
import com.FullStack.ms_transaction.domain.model.SalesReport;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITraceabilityFeignClientMapper {

    SalesReportFeignClientDto toSalesReportFeignClientDto(SalesReport salesReport);
}
