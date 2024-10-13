package com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils;

public class ConstantsEntity {
    private ConstantsEntity() { throw new IllegalStateException("Utility class"); }

    public static final String SUPPLIES_ENTITY_TABLE = "supplies";
    public static final String SALES_ENTITY_TABLE = "sales";
    public static final String SALES_DETAILS_ENTITY_TABLE = "sales_details";

    // Supplies Columns

    public static final String SUPPLIES_COLUMN_PRODUCT_ID = "product_id";
    public static final String SUPPLIES_COLUMN_PRICE = "price";
    public static final String SUPPLIES_COLUMN_CREATED_AT = "created_at";
    public static final String SUPPLIES_UPDATED_AT = "updated_at";
    public static final String SUPPLIES_COLUMN_IS_AVAILABLE = "is_available";
    public static final String SUPPLIES_COLUMN_STATUS = "status";
    public static final String SUPPLIES_COLUMN_QUANTITY_TOTAL = "quantity_total";
    public static final String SUPPLIES_COLUMN_QUANTITY_AVAILABLE = "quantity_available";
    public static final String SUPPLIES_COLUMN_REPLENISHMENT_DATE = "replenishment_date";
    public static final String SUPPLIES_COLUMN_USER_ID = "user_id";


    // Sales Columns

    public static final String SALES_COLUMN_SUBTOTAL = "subtotal";
    public static final String SALES_COLUMN_CREATED_AT = "created_at";
    public static final String SALES_COLUMN_UPDATED_AT = "updated_at";
    public static final String SALES_COLUMN_USER_ID = "user_id";
    public static final String SALES_COLUMN_CART_ID = "cart_id";


    // Sales Details Columns

    public static final String SALES_DETAILS_COLUMN_AMOUNT = "amount";
    public static final String SALES_DETAILS_COLUMN_PRICE = "price";
    public static final String SALES_DETAILS_COLUMN_CREATED_AT = "created_at";
    public static final String SALES_DETAILS_COLUMN_UPDATED_AT = "updated_at";
    public static final String SALES_DETAILS_COLUMN_PRODUCT_ID = "product_id";
    public static final String SALES_DETAILS_COLUMN_SALES_ID = "sales_id";



}
