package com.FullStack.ms_transaction.Supplies;

import com.FullStack.ms_transaction.domain.model.Supplies;
import com.FullStack.ms_transaction.infrastructure.out.jpa.adapter.SuppliesMySqlAdapter;
import com.FullStack.ms_transaction.infrastructure.out.jpa.entities.SuppliesEntity;
import com.FullStack.ms_transaction.infrastructure.out.jpa.mapper.ISuppliesEntityMapper;
import com.FullStack.ms_transaction.infrastructure.out.jpa.repository.ISuppliesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@TestPropertySource(locations = "classpath:application-dev.yml")
@SpringBootTest
public class SuppliesMySqlAdapterTest {
    @MockBean
    private ISuppliesRepository suppliesRepository;
    @MockBean
    private ISuppliesEntityMapper suppliesEntityMapper;

    private SuppliesMySqlAdapter suppliesMySqlAdapter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        suppliesMySqlAdapter = new SuppliesMySqlAdapter(suppliesRepository, suppliesEntityMapper);
    }

    @Test
    void saveSupplies_returnsTrueWhenSaveIsSuccessful() {
        Supplies supplies = new Supplies();
        when(suppliesEntityMapper.toSuppliesEntity(any(Supplies.class))).thenReturn(new SuppliesEntity());
        when(suppliesRepository.save(any(SuppliesEntity.class))).thenReturn(new SuppliesEntity());

        boolean result = suppliesMySqlAdapter.saveSupplies(supplies);

        assertTrue(result);
    }

    @Test
    void saveSupplies_returnsFalseWhenSaveFails() {
        Supplies supplies = new Supplies();
        when(suppliesEntityMapper.toSuppliesEntity(any(Supplies.class))).thenReturn(new SuppliesEntity());
        doThrow(new RuntimeException()).when(suppliesRepository).save(any(SuppliesEntity.class));

        boolean result = suppliesMySqlAdapter.saveSupplies(supplies);

        assertFalse(result);
    }
}
