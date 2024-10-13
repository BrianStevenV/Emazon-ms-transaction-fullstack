package com.FullStack.ms_transaction.infrastructure.input.rest.controller;

import com.FullStack.ms_transaction.application.handler.ISalesHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.FullStack.ms_transaction.infrastructure.input.rest.utils.SalesRestControllerConstants.SALES_REST_CONTROLLER_BASE_PATH;
import static com.FullStack.ms_transaction.infrastructure.input.rest.utils.SalesRestControllerConstants.SALES_REST_CONTROLLER_POST_BUY_CART;

@RestController
@RequestMapping(SALES_REST_CONTROLLER_BASE_PATH)
@RequiredArgsConstructor
public class SalesRestController {

    private final ISalesHandler salesHandler;

    @PostMapping(SALES_REST_CONTROLLER_POST_BUY_CART)
    public ResponseEntity<Void> buyCart(){
        salesHandler.buyCart();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
