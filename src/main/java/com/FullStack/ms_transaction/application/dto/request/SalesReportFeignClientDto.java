package com.FullStack.ms_transaction.application.dto.request;

import java.time.LocalDateTime;
import java.util.List;

public record SalesReportFeignClientDto(
        long cartId,
        List<ProductSalesFeignClientDto> cartDetails,
        double subtotal,
        LocalDateTime purchaseDate
) {
}
