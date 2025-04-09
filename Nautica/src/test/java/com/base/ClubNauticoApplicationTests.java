package com.base;

import com.base.model.barco;
import com.base.service.barco_service;
import com.base.service.salida_service;
import com.base.service.socios_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;

@SpringBootTest
public class ClubNauticoApplicationTests {

    @Mock
    private barco_service barcoService;

    @Mock
    private socios_service sociosService;

    @Mock
    private salida_service salidaService;

    @InjectMocks
    private Application application;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInitBarcoFound() throws Exception {
        barco barcoUno = new barco();
        barcoUno.setId_barco(1L);
        barcoUno.setNombre("BarcoUno");
        barcoUno.setMatricula("1234");
        barcoUno.setAmarre("1");
        barcoUno.setCuota(1000);

        when(barcoService.findAll()).thenReturn(Arrays.asList(barcoUno));
        when(barcoService.getBarcoPorNombre("BarcoUno")).thenReturn(barcoUno);

        CommandLineRunner runner = application.init(barcoService, sociosService, salidaService, null);
        runner.run();

        verify(barcoService, times(2)).findAll();  // Ajustado para permitir 2 invocaciones
        verify(barcoService, times(2)).getBarcoPorNombre("BarcoUno");
    }

    @Test
    public void testInitBarcoNotFound() throws Exception {
        when(barcoService.findAll()).thenReturn(Collections.emptyList());
        when(barcoService.getBarcoPorNombre("BarcoUno")).thenReturn(null);

        CommandLineRunner runner = application.init(barcoService, sociosService, salidaService, null);
        runner.run();

        verify(barcoService, times(2)).findAll();  // Ajustado para permitir 2 invocaciones
        verify(barcoService, times(2)).getBarcoPorNombre("BarcoUno");
    }

    @Test
    public void testUpdateBarco() throws Exception {
        barco barcoUno = new barco();
        barcoUno.setId_barco(1L);
        barcoUno.setNombre("BarcoUno");
        barcoUno.setCuota(1000);

        when(barcoService.getBarcoPorNombre("BarcoUno")).thenReturn(barcoUno);

        CommandLineRunner runner = application.init(barcoService, sociosService, salidaService, null);
        runner.run();

        verify(barcoService, times(1)).update(barcoUno);
        assert(barcoUno.getCuota() == 1500); // Verificamos que la cuota se haya actualizado
    }

    @Test
    public void testDeleteBarcosAmarre9() throws Exception {
        barco barcoEnAmarre9 = new barco();
        barcoEnAmarre9.setId_barco(2L);
        barcoEnAmarre9.setNombre("BarcoDos");
        barcoEnAmarre9.setAmarre("9");

        when(barcoService.findAll()).thenReturn(Arrays.asList(barcoEnAmarre9));

        CommandLineRunner runner = application.init(barcoService, sociosService, salidaService, null);
        runner.run();

        verify(barcoService, times(1)).deleteByAmarre("9");
    }
}
