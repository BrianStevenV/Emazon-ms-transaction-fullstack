package com.FullStack.ms_transaction.Supplies;

import com.FullStack.ms_transaction.application.dto.SuppliesRequestDto;
import com.FullStack.ms_transaction.application.handler.ISuppliesHandler;
import com.FullStack.ms_transaction.infrastructure.input.rest.controller.SuppliesRestController;
import com.FullStack.ms_transaction.infrastructure.input.rest.utils.SuppliesRestControllerConstants;
import com.FullStack.ms_transaction.infrastructure.security.utils.ConstantsSecurity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.validation.annotation.Validated;


import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;


import static org.mockito.Mockito.mockStatic;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Validated
@TestPropertySource(locations = "classpath:application-dev.yml")
@WebMvcTest(controllers = SuppliesRestController.class)
public class SuppliesRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ISuppliesHandler suppliesHandler;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    @WithMockUser(username = "testUser", roles = "WAREHOUSE_ASSISTANT")
    void whenRoleIsWarehouseAssistant_thenAddSuppliesReturnsCreated() throws Exception {
        // Arrange
        String suppliesRequestJson = "{\"price\":100.0,\"quantityTotal\":10,\"quantityAvailable\":8,\"isAvailable\":true,\"replenishmentDate\":\"2024-09-25T00:00:00.000+00:00\",\"productId\":1}";

        // Mock suppliesHandler
        doNothing().when(suppliesHandler).addSupplies(any(SuppliesRequestDto.class));

        // Act - invoke the method to add supplies
        mockMvc.perform(post(SuppliesRestControllerConstants.SUPPLIES_REST_CONTROLLER_BASE_PATH + SuppliesRestControllerConstants.SUPPLIES_REST_CONTROLLER_POST_ADD_SUPPLIES)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(suppliesRequestJson))
                .andExpect(status().isCreated());
    }




    @Test
    @WithMockUser(username = "testUser", roles = "WAREHOUSE_ASSISTANT")
    public void testAddSupplies_InvalidData() throws Exception {
        // Given
        SuppliesRequestDto requestDto = new SuppliesRequestDto(null, -10, -5, null, null, -1L);

        // When & Then
        mockMvc.perform(post(SuppliesRestControllerConstants.SUPPLIES_REST_CONTROLLER_BASE_PATH + SuppliesRestControllerConstants.SUPPLIES_REST_CONTROLLER_POST_ADD_SUPPLIES)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }
}
