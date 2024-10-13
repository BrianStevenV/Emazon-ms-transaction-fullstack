package com.FullStack.ms_transaction.infrastructure.out.jpa.mapper;

import com.FullStack.ms_transaction.domain.model.Sales;
import com.FullStack.ms_transaction.infrastructure.out.jpa.entities.SalesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ISalesEntityMapper {
    SalesEntity toEntity(Sales sales);
}
