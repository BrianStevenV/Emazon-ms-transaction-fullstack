package com.FullStack.ms_transaction.application.handler.impl;

import com.FullStack.ms_transaction.application.handler.ISalesHandler;
import com.FullStack.ms_transaction.domain.api.ISalesServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalesHandlerImpl implements ISalesHandler {

    private final ISalesServicePort salesServicePort;
    @Override
    public void buyCart() {
        salesServicePort.buyCart();
    };
}
