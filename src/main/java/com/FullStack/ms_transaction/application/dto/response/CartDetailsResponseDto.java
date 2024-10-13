package com.FullStack.ms_transaction.application.dto.response;

import java.time.LocalDateTime;

public record CartDetailsResponseDto(
        Long id,
        Integer amount,
        Long productId,
        long cartId
) {
}
