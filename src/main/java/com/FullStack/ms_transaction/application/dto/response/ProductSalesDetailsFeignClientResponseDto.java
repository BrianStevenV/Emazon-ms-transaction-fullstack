package com.FullStack.ms_transaction.application.dto.response;

public record ProductSalesDetailsFeignClientResponseDto(
        long productId,
        int amount,
        double price
) {
}
