package com.FullStack.ms_transaction.Sales;

import com.FullStack.ms_transaction.application.handler.ISalesHandler;
import com.FullStack.ms_transaction.infrastructure.input.rest.controller.SalesRestController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class SalesRestControllerTest {
    @Mock
    private ISalesHandler salesHandler;

    private SalesRestController salesRestController;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        salesRestController = new SalesRestController(salesHandler);
        mockMvc = MockMvcBuilders.standaloneSetup(salesRestController).build();
    }

    @Test
    void buyCart_returnsAcceptedStatus() throws Exception {
        mockMvc.perform(post("/sales/buy-cart"))
                .andExpect(status().isAccepted());
        verify(salesHandler).buyCart();
    }

}
