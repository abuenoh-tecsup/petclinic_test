package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.*;

import com.tecsup.petclinic.entities.Vet;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class VetServiceCreateTest {

    @Autowired
    private VetService vetService;

    @Test
    public void testCreateVet() {

        String FIRST_NAME = "Sonaly";
        String LAST_NAME = "Vania";

        Vet vet = new Vet(FIRST_NAME, LAST_NAME);

        Vet vetCreated = vetService.create(vet);

        log.info(">>> VET CREATED: " + vetCreated);

        assertNotNull(vetCreated.getId(), "El ID no debe ser nulo después de guardar");
        assertEquals(FIRST_NAME, vetCreated.getFirstName(), "El nombre no coincide");
        assertEquals(LAST_NAME, vetCreated.getLastName(), "El apellido no coincide");

    }
}
