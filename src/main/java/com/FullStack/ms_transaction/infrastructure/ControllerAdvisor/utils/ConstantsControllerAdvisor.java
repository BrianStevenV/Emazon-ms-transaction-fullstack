package com.FullStack.ms_transaction.infrastructure.ControllerAdvisor.utils;

public class ConstantsControllerAdvisor {
    private ConstantsControllerAdvisor() { throw new IllegalStateException("Utility class"); }

    public static final String STATUS_IS_NOT_APPROVED_EXCEPTION_MESSAGE = "Status is not approved, the supply cannot be completed";
    public static final String AMOUNT_AVAILABLE_IS_GREATER_THAN_AMOUNT_TOTAL_EXCEPTION_MESSAGE = "Amount available is greater than amount total";
    public static final String RESPONSE_ERROR_MESSAGE = "Error:";
    public static final String FEIGN_CLIENT_STOCK_UPDATE_AMOUNT_MESSAGE_EXCEPTION = "The supply could not be completed due to a problem with the stock service.";
    public static final String SAVE_SUPPLY_EXCEPTION_MESSAGE = "The supply could not be saved due to a persistence error.";
    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credentials or role not allowed";

    public static final String FEIGN_CLIENT_BAD_REQUEST_EXCEPTION_MESSAGE = "The request could not be completed due to a problem with the stock service.";
    public static final String FEIGN_CLIENT_NOT_FOUND_EXCEPTION_MESSAGE = "The request could not be completed due to a problem with the stock service.";
    public static final String FEIGN_CLIENT_FORBIDDEN_EXCEPTION_MESSAGE = "The request could not be completed due to a problem with the stock service.";
    public static final String FEIGN_CLIENT_INTERNAL_SERVER_ERROR_EXCEPTION_MESSAGE = "The request could not be completed due to a problem with the stock service.";
    public static final String FEIGN_CLIENT_UNAUTHORIZED_EXCEPTION_MESSAGE = "The request could not be completed due to a problem with the stock service.";
}
