package com.FullStack.ms_transaction.application.dto.request;


import java.util.List;

public record ReduceQuantityFeignClientDto(
        List<QuantityStockFeignClientDto> reduceQuantityList
) {
}