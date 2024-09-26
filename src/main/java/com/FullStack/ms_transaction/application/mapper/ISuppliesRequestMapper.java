package com.FullStack.ms_transaction.application.mapper;

import com.FullStack.ms_transaction.application.dto.SuppliesRequestDto;
import com.FullStack.ms_transaction.domain.model.Supplies;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ISuppliesRequestMapper {
    Supplies toSupplies(SuppliesRequestDto suppliesRequestDto);
}
