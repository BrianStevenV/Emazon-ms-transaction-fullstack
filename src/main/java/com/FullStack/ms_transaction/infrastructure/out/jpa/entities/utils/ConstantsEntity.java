package com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils;

public class ConstantsEntity {
    private ConstantsEntity() { throw new IllegalStateException("Utility class"); }

    public static final String SUPPLIES_ENTITY_TABLE = "supplies";

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


}
