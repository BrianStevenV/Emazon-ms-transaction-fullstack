package com.FullStack.ms_transaction.infrastructure.configuration.feign.utils;

public class ConstantFeignClientInfra {
    private ConstantFeignClientInfra() { throw new IllegalStateException("Utility class"); }

    public static final int STATUS_CODE_400 = 400;
    public static final int STATUS_CODE_401 = 401;
    public static final int STATUS_CODE_403 = 403;
    public static final int STATUS_CODE_404 = 404;
    public static final int STATUS_CODE_500 = 500;
}
