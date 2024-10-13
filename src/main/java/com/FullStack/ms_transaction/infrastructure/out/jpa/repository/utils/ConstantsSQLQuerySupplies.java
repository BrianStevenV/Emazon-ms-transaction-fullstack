package com.FullStack.ms_transaction.infrastructure.out.jpa.repository.utils;

public class ConstantsSQLQuerySupplies {
    private ConstantsSQLQuerySupplies() {
        throw new IllegalStateException("Utility class");
    }

    public static final String QUERY_GET_NEXT_SUPPLY_DATE_BY_PRODUCT_ID = "SELECT s.replenishmentDate FROM SuppliesEntity s WHERE s.productId = :productId ORDER BY s.replenishmentDate DESC LIMIT 1";
}
