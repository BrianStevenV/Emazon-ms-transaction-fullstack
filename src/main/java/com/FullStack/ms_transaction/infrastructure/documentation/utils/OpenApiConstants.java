package com.FullStack.ms_transaction.infrastructure.documentation.utils;

public class OpenApiConstants {
    private OpenApiConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String CODE_201 = "201";
    public static final String CODE_409 = "409";
    public static final String CODE_200 = "200";
    public static final String CODE_404 = "404";

    // Supplies Rest Controller

    public static final String SUMMARY_CREATE_SUPPLIES = "Add a new Supplies";
    public static final String DESCRIPTION_CREATE_SUPPLIES_201 = "Supplies created";
    public static final String DESCRIPTION_CREATE_SUPPLIES_409 = "Supplies exists";

    public static final String SUMMARY_NEXT_DATE_SUPPLY = "Next date supply";
    public static final String DESCRIPTION_NEXT_DATE_SUPPLY_200 = "Next date supply successful";
    public static final String DESCRIPTION_NEXT_DATE_SUPPLY_404 = "Next date supply failed";

    // Content

    public static final String APPLICATION_JSON = "application/json";

    // Security

    public static final String SECURITY_REQUIREMENT = "jwt";

    // Schema

    public static final String SCHEMAS_MAP = "#/components/schemas/Map";
    public static final String SCHEMAS_ERROR = "#/components/schemas/Error";

    // Swagger

    public static final String SWAGGER_TITLE_MESSAGE = "User API Pragma Power Up Full Stack";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "User microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";

}
