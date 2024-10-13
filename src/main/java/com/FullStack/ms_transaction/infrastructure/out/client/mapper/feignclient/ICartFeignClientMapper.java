package com.FullStack.ms_transaction.infrastructure.out.client.mapper.feignclient;

import com.FullStack.ms_transaction.application.dto.request.ProductsIdsFeignClientDto;
import com.FullStack.ms_transaction.application.dto.response.CartDetailsResponseDto;
import com.FullStack.ms_transaction.domain.model.CartDetails;
import com.FullStack.ms_transaction.domain.model.ProductsIds;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICartFeignClientMapper {
    List<CartDetails> toCartDetails(List<CartDetailsResponseDto> cartDetailsResponseDto);
    ProductsIdsFeignClientDto toProductsIdsFeignClientDto(ProductsIds productsIds);
}
