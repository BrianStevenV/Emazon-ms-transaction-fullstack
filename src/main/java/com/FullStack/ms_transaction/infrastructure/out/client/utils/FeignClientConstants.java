package com.FullStack.ms_transaction.infrastructure.out.client.utils;

public class FeignClientConstants {
    private FeignClientConstants() { throw new IllegalStateException("Utility class"); }

    public static final String STOCK_SERVICE = "stock-service";
    public static final String STOCK_BASE_HOST = "http://localhost:8081";

    public static final String STOCK_UPDATE_QUANTITY_URL = "/product/amount/";
    public static final String STOCK_CANCEL_UPDATE_QUANTITY_URL = "/product/amount/revert";
}
