package com.FullStack.ms_transaction.infrastructure.input.rest.utils;

public class SuppliesRestControllerConstants {
    private SuppliesRestControllerConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String SUPPLIES_REST_CONTROLLER_BASE_PATH = "/api/v1/supplies";
    public static final String SUPPLIES_REST_CONTROLLER_POST_ADD_SUPPLIES = "/";
    public static final String SUPPLIES_REST_CONTROLLER_GET_NEXT_DATE_SUPPLY = "/next-date-supply/{productId}";
    public static final String SUPPLIES_REST_CONTROLLER_GET_NEXT_DATE_SUPPLY_PATH_VARIABLE_PRODUCT_ID = "productId";

}
