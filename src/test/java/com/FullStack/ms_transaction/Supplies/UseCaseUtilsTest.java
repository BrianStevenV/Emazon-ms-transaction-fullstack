package com.FullStack.ms_transaction.Supplies;

import com.FullStack.ms_transaction.domain.exception.AmountAvailableIsGreaterThanAmountTotalException;
import com.FullStack.ms_transaction.domain.model.Supplies;
import com.FullStack.ms_transaction.domain.usecase.utils.UseCaseUtils;
import com.FullStack.ms_transaction.infrastructure.security.utils.IContextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.when;

@TestPropertySource(locations = "classpath:application-dev.yml")
@SpringBootTest
public class UseCaseUtilsTest {
    @Mock
    private IContextService contextService;

    private UseCaseUtils useCaseUtils;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        useCaseUtils = new UseCaseUtils(contextService);
    }

    @Test
    void quantityTransactionToStock_returnsCorrectQuantityWhenAvailableIsGreaterThanOrEqualToTotal() {
        int result = useCaseUtils.quantityTransactionToStock(15, 10);
        assertEquals(5, result);
    }

    @Test
    void quantityTransactionToStock_throwsExceptionWhenAvailableIsGreaterThanTotal() {
        assertThrows(AmountAvailableIsGreaterThanAmountTotalException.class, () -> useCaseUtils.quantityTransactionToStock(10, 15));
    }

    @Test
    void setCreationTimestamp_setsCreatedAtAndUpdatedAt() {
        Supplies supplies = new Supplies();
        useCaseUtils.setCreationTimestamp(supplies);
        assertNotNull(supplies.getCreatedAt());
        assertNotNull(supplies.getUpdatedAt());
        assertEquals(supplies.getCreatedAt(), supplies.getUpdatedAt());
    }

    @Test
    void setUpdateTimestamp_setsUpdatedAt() {
        Supplies supplies = new Supplies();
        useCaseUtils.setUpdateTimestamp(supplies);
        assertNotNull(supplies.getUpdatedAt());
    }

    @Test
    void getIdFromUserContextService_returnsCorrectId() {
        when(contextService.getAuthenticationId()).thenReturn(123L);
        long id = useCaseUtils.getIdFromUserContextService();
        assertEquals(123L, id);
    }
}
