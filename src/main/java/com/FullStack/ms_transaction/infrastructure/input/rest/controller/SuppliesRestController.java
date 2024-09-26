package com.FullStack.ms_transaction.infrastructure.input.rest.controller;

import com.FullStack.ms_transaction.application.dto.SuppliesRequestDto;
import com.FullStack.ms_transaction.application.handler.ISuppliesHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.FullStack.ms_transaction.infrastructure.documentation.utils.OpenApiConstants.APPLICATION_JSON;
import static com.FullStack.ms_transaction.infrastructure.documentation.utils.OpenApiConstants.CODE_201;
import static com.FullStack.ms_transaction.infrastructure.documentation.utils.OpenApiConstants.CODE_409;
import static com.FullStack.ms_transaction.infrastructure.documentation.utils.OpenApiConstants.DESCRIPTION_CREATE_SUPPLIES_201;
import static com.FullStack.ms_transaction.infrastructure.documentation.utils.OpenApiConstants.DESCRIPTION_CREATE_SUPPLIES_409;
import static com.FullStack.ms_transaction.infrastructure.documentation.utils.OpenApiConstants.SCHEMAS_ERROR;
import static com.FullStack.ms_transaction.infrastructure.documentation.utils.OpenApiConstants.SCHEMAS_MAP;
import static com.FullStack.ms_transaction.infrastructure.documentation.utils.OpenApiConstants.SECURITY_REQUIREMENT;
import static com.FullStack.ms_transaction.infrastructure.documentation.utils.OpenApiConstants.SUMMARY_CREATE_SUPPLIES;
import static com.FullStack.ms_transaction.infrastructure.input.rest.utils.SuppliesRestControllerConstants.SUPPLIES_REST_CONTROLLER_BASE_PATH;
import static com.FullStack.ms_transaction.infrastructure.input.rest.utils.SuppliesRestControllerConstants.SUPPLIES_REST_CONTROLLER_POST_ADD_SUPPLIES;

@RestController
@RequestMapping(SUPPLIES_REST_CONTROLLER_BASE_PATH)
@RequiredArgsConstructor
public class SuppliesRestController {

    private final ISuppliesHandler suppliesHandler;

    @Operation(summary = SUMMARY_CREATE_SUPPLIES,
            responses = {
                    @ApiResponse(responseCode = CODE_201, description = DESCRIPTION_CREATE_SUPPLIES_201,
                            content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(ref = SCHEMAS_MAP))),
                    @ApiResponse(responseCode = CODE_409, description = DESCRIPTION_CREATE_SUPPLIES_409,
                            content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(ref = SCHEMAS_ERROR)))})
    @PostMapping(SUPPLIES_REST_CONTROLLER_POST_ADD_SUPPLIES)
    @SecurityRequirement(name = SECURITY_REQUIREMENT)
    public ResponseEntity<Void> addSupplies(@Valid @RequestBody SuppliesRequestDto suppliesRequestDto) {
        suppliesHandler.addSupplies(suppliesRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
