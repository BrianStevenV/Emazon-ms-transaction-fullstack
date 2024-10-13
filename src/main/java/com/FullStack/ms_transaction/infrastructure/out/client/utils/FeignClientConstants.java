package com.FullStack.ms_transaction.infrastructure.out.client.utils;

public class FeignClientConstants {
    private FeignClientConstants() { throw new IllegalStateException("Utility class"); }

    public static final String STOCK_SERVICE = "stock-service";
    public static final String STOCK_BASE_HOST = "http://localhost:8081";

    public static final String STOCK_UPDATE_QUANTITY_URL = "/product/amount/";
    public static final String STOCK_CANCEL_UPDATE_QUANTITY_URL = "/product/amount/revert";

    public static final String CART_SERVICE = "cart-service";
    public static final String CART_BASE_HOST = "http://localhost:8084";

    public static final String CART_CONTROLLER_GET_LIST_CART_DETAILS = "/cart/details/{userId}";
    public static final String CART_REST_CONTROLLER_PATH_VARIABLE_USER_ID = "userId";

    public static final String CART_CONTROLLER_DELETE_CART = "/cart/{userId}";

    public static final String PRODUCT_CONTROLLER_POST_REDUCE_QUANTITY = "/product/reduce-quantity";

    public static final String TRACEABILITY_SERVICE = "traceability-service";
    public static final String TRACEABILITY_BASE_HOST = "http://localhost:8085";

    public static final String TRACEABILITY_CONTROLLER_POST_SALES = "/traceability/sales";
}
