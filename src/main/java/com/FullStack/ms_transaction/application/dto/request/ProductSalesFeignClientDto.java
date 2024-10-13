package com.FullStack.ms_transaction.application.dto.request;

public record ProductSalesFeignClientDto(
        long productId,
        int amount,
        double price
) {
}
