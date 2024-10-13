package com.FullStack.ms_transaction.application.dto.response;

import java.util.List;

public record SaleFeignClientResponseDto(
        List<ProductSalesDetailsFeignClientResponseDto> productSalesDetailsList,
        Double subtotal
) {
}
