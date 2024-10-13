package com.FullStack.ms_transaction.infrastructure.ControllerAdvisor;

import com.FullStack.ms_transaction.domain.exception.AmountAvailableIsGreaterThanAmountTotalException;
import com.FullStack.ms_transaction.domain.exception.FeignClientStockException;
import com.FullStack.ms_transaction.domain.exception.ProductNotFoundException;
import com.FullStack.ms_transaction.domain.exception.SaveSupplyException;
import com.FullStack.ms_transaction.domain.exception.StatusIsNotApprovedException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.FullStack.ms_transaction.infrastructure.ControllerAdvisor.utils.ConstantsControllerAdvisor.AMOUNT_AVAILABLE_IS_GREATER_THAN_AMOUNT_TOTAL_EXCEPTION_MESSAGE;
import static com.FullStack.ms_transaction.infrastructure.ControllerAdvisor.utils.ConstantsControllerAdvisor.FEIGN_CLIENT_STOCK_UPDATE_AMOUNT_MESSAGE_EXCEPTION;
import static com.FullStack.ms_transaction.infrastructure.ControllerAdvisor.utils.ConstantsControllerAdvisor.PRODUCT_NOT_FOUND_EXCEPTION_MESSAGE;
import static com.FullStack.ms_transaction.infrastructure.ControllerAdvisor.utils.ConstantsControllerAdvisor.RESPONSE_ERROR_MESSAGE;
import static com.FullStack.ms_transaction.infrastructure.ControllerAdvisor.utils.ConstantsControllerAdvisor.SAVE_SUPPLY_EXCEPTION_MESSAGE;
import static com.FullStack.ms_transaction.infrastructure.ControllerAdvisor.utils.ConstantsControllerAdvisor.STATUS_IS_NOT_APPROVED_EXCEPTION_MESSAGE;

@ControllerAdvice
public class SuppliesControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errorMessages = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                errorMessages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
            } else {
                errorMessages.add(error.getDefaultMessage());
            }
        }
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation -> {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.put(propertyPath, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FeignClientStockException.class)
    public ResponseEntity<Map<String, String>> handleFeignClientStockException(FeignClientStockException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE,
                        FEIGN_CLIENT_STOCK_UPDATE_AMOUNT_MESSAGE_EXCEPTION));
    }

    @ExceptionHandler(SaveSupplyException.class)
    public ResponseEntity<Map<String, String>> handleSaveSupplyException(SaveSupplyException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE, SAVE_SUPPLY_EXCEPTION_MESSAGE));
    }

    @ExceptionHandler(AmountAvailableIsGreaterThanAmountTotalException.class)
    public ResponseEntity<Map<String, String>> handleAmountAvailableIsGreaterThanAmountTotalException
            (AmountAvailableIsGreaterThanAmountTotalException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE,
                        AMOUNT_AVAILABLE_IS_GREATER_THAN_AMOUNT_TOTAL_EXCEPTION_MESSAGE));
    }

    @ExceptionHandler(StatusIsNotApprovedException.class)
    public ResponseEntity<Map<String, String>> handleStatusIsNotApprovedException(StatusIsNotApprovedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE, STATUS_IS_NOT_APPROVED_EXCEPTION_MESSAGE));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductNotFoundException(ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE, PRODUCT_NOT_FOUND_EXCEPTION_MESSAGE));
    }
}
