package com.FullStack.ms_transaction.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import static com.FullStack.ms_transaction.application.utils.ConstantsDtoValidation.NOT_NULL_QUANTITY_AVAILABLE_MESSAGE;
import static com.FullStack.ms_transaction.application.utils.ConstantsDtoValidation.POSITIVE_QUANTITY_AVAILABLE_MESSAGE;

public record QuantityStockFeignClientDto(
        Long productId,
        @NotNull(message = NOT_NULL_QUANTITY_AVAILABLE_MESSAGE)
        @Positive(message = POSITIVE_QUANTITY_AVAILABLE_MESSAGE)
        Integer amount
) {
}
