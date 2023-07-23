package com.inmueble.springbootmicroservice1inmueble.controller;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import com.inmueble.springbootmicroservice1inmueble.model.Inmueble;
import com.inmueble.springbootmicroservice1inmueble.service.InmuebleService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class InmuebleControllerTest {

    private InmuebleController inmuebleController;
    private InmuebleService inmuebleService;

    @Before
    public void setUp() {
        inmuebleService = mock(InmuebleService.class);
        inmuebleController = new InmuebleController();
        inmuebleController.setInmuebleService(inmuebleService);
    }


    @Test
    public void testSaveInmueble() {
        Inmueble inmueble = new Inmueble(2L, "Calle Falsa 456", "enrique", 20.000);
        inmueble.setId(1L);
        inmueble.setDireccion("Calle Falsa 123");
        inmueble.setNombre("orlando");
        inmueble.setPrecio(80.000);

//        devuelve el objeto inmueble simulado por mock
        when(inmuebleService.saveInmueble(any(Inmueble.class))).thenReturn(inmueble);

        ResponseEntity<?> responseEntity = inmuebleController.saveInmueble(inmueble);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

        verify(inmuebleService, times(1)).saveInmueble(inmueble);
    }
    @Test
    public void testGetAllInmuebles() {
        List<Inmueble> inmuebles = new ArrayList<>();
        inmuebles.add(new Inmueble(2L, "Calle Falsa 456", "enrique", 20.000));
        inmuebles.add(new Inmueble(2L, "Calle Falsa 456", "enrique", 20.000));
        inmuebles.add(new Inmueble(3L, "Calle Falsa 789", "gabriel", 40.000));
        // Aquí puedes agregar más inmuebles simulados

        // Configurar el comportamiento simulado del servicio para el método findAllInmuebles()
        when(inmuebleService.findAllInmuebles()).thenReturn(inmuebles);

        ResponseEntity<?> responseEntity = inmuebleController.getAllInmuebles();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        List<Inmueble> inmueblesResponse = (List<Inmueble>) responseEntity.getBody();
        assertEquals(inmuebles, inmueblesResponse);
    }


    @Test
    public void testDeleteInmueble() {
        Long inmuebleId = 1L;

        ResponseEntity<?> responseEntity = inmuebleController.deleteInmueble(inmuebleId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        verify(inmuebleService, times(1)).deleteInmueble(inmuebleId);
    }
}






















