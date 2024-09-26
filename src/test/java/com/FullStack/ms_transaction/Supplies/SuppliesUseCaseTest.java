package com.FullStack.ms_transaction.Supplies;

import com.FullStack.ms_transaction.domain.exception.FeignClientStockException;
import com.FullStack.ms_transaction.domain.exception.SaveSupplyException;
import com.FullStack.ms_transaction.domain.model.EnumStatus;
import com.FullStack.ms_transaction.domain.model.QuantityStock;
import com.FullStack.ms_transaction.domain.model.Supplies;
import com.FullStack.ms_transaction.domain.spi.ISuppliesPersistencePort;
import com.FullStack.ms_transaction.domain.usecase.SuppliesUseCase;
import com.FullStack.ms_transaction.domain.spi.IStockFeignClientPort;
import com.FullStack.ms_transaction.domain.usecase.utils.SuppliesUseCaseUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@TestPropertySource(locations = "classpath:application-dev.yml")
@SpringBootTest
public class SuppliesUseCaseTest {
    @InjectMocks
    private SuppliesUseCase suppliesUseCase;

    @Mock
    private IStockFeignClientPort stockExternalPort;

    @Mock
    private ISuppliesPersistencePort suppliesPersistencePort;

    @Mock
    private SuppliesUseCaseUtils suppliesUseCaseUtils;

    private Supplies supplies;
    private QuantityStock quantityStock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        supplies = new Supplies();
        supplies.setProductId(1L);
        supplies.setQuantityAvailable(10);
        supplies.setIsAvailable(true);

        quantityStock = new QuantityStock(supplies.getProductId(), supplies.getQuantityAvailable());
    }



    @Test
    void addSupplies_updatesStockWhenAvailable() {
        // Crear un spy de SuppliesUseCase para controlar las llamadas a los métodos reales
        SuppliesUseCase suppliesUseCaseSpy = spy(new SuppliesUseCase(suppliesPersistencePort, stockExternalPort, suppliesUseCaseUtils));

        // Simulamos obtener el ID del usuario
        when(suppliesUseCaseUtils.getIdFromUserContextService()).thenReturn(123L);

        // Simulamos que el stock se actualiza correctamente
        doReturn(true).when(stockExternalPort).updateQuantity(any(QuantityStock.class));

        // Simulamos que el guardado de los suministros también es exitoso
        doReturn(true).when(suppliesPersistencePort).saveSupplies(any(Supplies.class));

        // Ejecutamos el método addSupplies en el spy
        suppliesUseCaseSpy.addSupplies(supplies);

        // Verificamos que el método updateQuantity fue llamado
        verify(stockExternalPort).updateQuantity(any(QuantityStock.class));

        // Verificamos que el estado de los suministros se ha actualizado correctamente a APPROVED
        assertEquals(EnumStatus.APPROVED, supplies.getStatus());
    }


    @Test
    void addSupplies_throwsExceptionWhenStockUpdateFails() {
        when(suppliesUseCaseUtils.getIdFromUserContextService()).thenReturn(123L);
        when(stockExternalPort.updateQuantity(any(QuantityStock.class))).thenReturn(false);

        assertThrows(FeignClientStockException.class, () -> suppliesUseCase.addSupplies(supplies));
    }

    @Test
    void addSupplies_savesSuppliesWhenStockUpdated() {
        // Crear un spy de SuppliesUseCase para controlar las llamadas a los métodos reales
        SuppliesUseCase suppliesUseCaseSpy = spy(new SuppliesUseCase(suppliesPersistencePort, stockExternalPort, suppliesUseCaseUtils));

        // Simulamos obtener el ID del usuario
        when(suppliesUseCaseUtils.getIdFromUserContextService()).thenReturn(123L);

        // Simulamos que el stock se actualiza correctamente
        doReturn(true).when(stockExternalPort).updateQuantity(any(QuantityStock.class));

        // Simulamos que el guardado de los suministros también es exitoso
        doReturn(true).when(suppliesPersistencePort).saveSupplies(any(Supplies.class));

        // Ejecutamos el método addSupplies en el spy
        suppliesUseCaseSpy.addSupplies(supplies);

        // Verificamos que el método saveSupplies fue llamado con los parámetros correctos
        verify(suppliesPersistencePort).saveSupplies(supplies);
    }


    @Test
    void addSupplies_throwsSaveSupplyExceptionWhenSaveFails() {
        // Arrange
        Supplies supplies = new Supplies();
        supplies.setIsAvailable(true); // Aseguramos que este campo sea verdadero para que llegue al punto de actualizar stock

        // Simulamos obtener el ID del usuario
        when(suppliesUseCaseUtils.getIdFromUserContextService()).thenReturn(123L);

        // Crear un spy del suppliesUseCase
        SuppliesUseCase suppliesUseCaseSpy = spy(new SuppliesUseCase(suppliesPersistencePort, stockExternalPort, suppliesUseCaseUtils));

        // Usamos doReturn para simular el método updateQuantity en el stockExternalPort
        doReturn(true).when(stockExternalPort).updateQuantity(any(QuantityStock.class));

        // Simulamos fallo al guardar los suministros
        doReturn(false).when(suppliesPersistencePort).saveSupplies(any(Supplies.class));

        // Act & Assert
        SaveSupplyException exception = assertThrows(SaveSupplyException.class, () -> {
            suppliesUseCaseSpy.addSupplies(supplies);
        });

        // Verifica que la excepción lanzada sea la correcta
        assertEquals(SaveSupplyException.class, exception.getClass());

        // Verifica que se haya llamado al método para cancelar la cantidad en stock
        verify(stockExternalPort).cancelQuantity(any(QuantityStock.class));
    }




}
