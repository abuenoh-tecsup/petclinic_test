package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.*;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exceptions.VetNotFoundException;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class VetServiceDeleteTest {

    @Autowired
    private VetService vetService;

    @Test
    public void testDeleteVet() {

        String FIRST_NAME = "Carlos";
        String LAST_NAME = "Perez";

        // ------------ Create ---------------
        Vet vet = new Vet(FIRST_NAME, LAST_NAME);
        vet = this.vetService.create(vet);
        log.info("Vet creado: " + vet);

        // ------------ Delete ---------------
        try {
            this.vetService.delete(vet.getId());
        } catch (VetNotFoundException e) {
            fail("No se pudo eliminar el veterinario: " + e.getMessage());
        }

        // ------------ Validation ---------------
        try {
            this.vetService.findById(vet.getId());
            // Si encuentra el vet, la prueba debe fallar
            assertTrue(false, "El veterinario no debería existir después de eliminarlo");
        } catch (VetNotFoundException e) {
            // Esperado: el vet no debe encontrarse
            assertTrue(true);
        }
    }
}
