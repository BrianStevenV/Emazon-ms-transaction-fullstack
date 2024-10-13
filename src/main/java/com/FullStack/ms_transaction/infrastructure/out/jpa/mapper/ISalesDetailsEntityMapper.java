package com.FullStack.ms_transaction.infrastructure.out.jpa.mapper;

import com.FullStack.ms_transaction.domain.model.SalesDetails;
import com.FullStack.ms_transaction.infrastructure.out.jpa.entities.SalesDetailsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ISalesDetailsEntityMapper {

    SalesDetailsEntity toEntity(SalesDetails salesDetailsEntity);
    List<SalesDetailsEntity> toEntityList(List<SalesDetails> salesDetailsEntity);
}
