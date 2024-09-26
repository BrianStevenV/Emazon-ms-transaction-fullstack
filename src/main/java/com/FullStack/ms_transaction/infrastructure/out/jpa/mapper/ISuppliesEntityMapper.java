package com.FullStack.ms_transaction.infrastructure.out.jpa.mapper;

import com.FullStack.ms_transaction.domain.model.Supplies;
import com.FullStack.ms_transaction.infrastructure.out.jpa.entities.SuppliesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ISuppliesEntityMapper {
    SuppliesEntity toSuppliesEntity(Supplies supplies);
}
