package com.FullStack.ms_transaction.application.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Date;

import static com.FullStack.ms_transaction.application.utils.ConstantsDtoValidation.NOT_NULL_IS_AVAILABLE_MESSAGE;
import static com.FullStack.ms_transaction.application.utils.ConstantsDtoValidation.NOT_NULL_PRICE_MESSAGE;
import static com.FullStack.ms_transaction.application.utils.ConstantsDtoValidation.NOT_NULL_PRODUCT_ID_MESSAGE;
import static com.FullStack.ms_transaction.application.utils.ConstantsDtoValidation.NOT_NULL_QUANTITY_AVAILABLE_MESSAGE;
import static com.FullStack.ms_transaction.application.utils.ConstantsDtoValidation.NOT_NULL_QUANTITY_TOTAL_MESSAGE;
import static com.FullStack.ms_transaction.application.utils.ConstantsDtoValidation.NOT_NULL_REPLENISHMENT_DATE_MESSAGE;
import static com.FullStack.ms_transaction.application.utils.ConstantsDtoValidation.POSITIVE_PRICE_MESSAGE;
import static com.FullStack.ms_transaction.application.utils.ConstantsDtoValidation.POSITIVE_PRODUCT_ID_MESSAGE;
import static com.FullStack.ms_transaction.application.utils.ConstantsDtoValidation.POSITIVE_QUANTITY_AVAILABLE_MESSAGE;
import static com.FullStack.ms_transaction.application.utils.ConstantsDtoValidation.POSITIVE_QUANTITY_TOTAL_MESSAGE;

public record SuppliesRequestDto(
        @NotNull(message = NOT_NULL_PRICE_MESSAGE)
        @Positive(message = POSITIVE_PRICE_MESSAGE)
        Double price,

        @NotNull(message = NOT_NULL_QUANTITY_TOTAL_MESSAGE)
        @Positive(message = POSITIVE_QUANTITY_TOTAL_MESSAGE)
        Integer quantityTotal,

        @NotNull(message = NOT_NULL_QUANTITY_AVAILABLE_MESSAGE)
        @Positive(message = POSITIVE_QUANTITY_AVAILABLE_MESSAGE)
        Integer quantityAvailable,

        @NotNull(message = NOT_NULL_IS_AVAILABLE_MESSAGE)
        Boolean isAvailable,

        @NotNull(message = NOT_NULL_REPLENISHMENT_DATE_MESSAGE)
        Date replenishmentDate,

        @NotNull(message = NOT_NULL_PRODUCT_ID_MESSAGE)
        @Positive(message = POSITIVE_PRODUCT_ID_MESSAGE)
        Long productId

) {
}
