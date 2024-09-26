package com.FullStack.ms_transaction.application.utils;

public class ConstantsDtoValidation {
    private ConstantsDtoValidation() { throw new IllegalStateException("Utility class"); }

    public static final String NOT_NULL_PRICE_MESSAGE = "Price cannot be null";
    public static final String NOT_NULL_QUANTITY_TOTAL_MESSAGE = "Quantity total cannot be null";
    public static final String NOT_NULL_QUANTITY_AVAILABLE_MESSAGE = "Quantity available cannot be null";
    public static final String NOT_NULL_PRODUCT_ID_MESSAGE = "Product id cannot be null";
    public static final String NOT_NULL_IS_AVAILABLE_MESSAGE = "Availability cannot be null";
    public static final String NOT_NULL_REPLENISHMENT_DATE_MESSAGE = "Replenishment date cannot be null";

    public static final String POSITIVE_PRICE_MESSAGE = "Price must be greater than 0";
    public static final String POSITIVE_QUANTITY_TOTAL_MESSAGE = "Quantity total must be greater than 0";
    public static final String POSITIVE_QUANTITY_AVAILABLE_MESSAGE = "Quantity available must be greater than 0";
    public static final String POSITIVE_PRODUCT_ID_MESSAGE = "Product id must be greater than 0";
}
