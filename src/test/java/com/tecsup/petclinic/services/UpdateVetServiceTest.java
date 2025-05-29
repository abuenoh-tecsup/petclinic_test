package com.tecsup.petclinic.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.tecsup.petclinic.entities.Vet;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class UpdateVetServiceTest {

    @Autowired
    private VetService vetService;

    /**
     * Test para actualizar un veterinario.
     * @author eduardobullon
     */
    @Test
    public void testUpdateVet() {

        String VET_FIRST_NAME = "Alvaro";
        String VET_LAST_NAME = "Bueno";

        String UPDATED_VET_FIRST_NAME = "Fernando";
        String UPDATED_VET_LAST_NAME = "Vera";

        Vet vet = new Vet(VET_FIRST_NAME, VET_LAST_NAME);

        log.info(">" + vet);
        Vet vetCreated = this.vetService.create(vet);
        log.info(">>" + vetCreated);

        vetCreated.setFirstName(UPDATED_VET_FIRST_NAME);
        vetCreated.setLastName(UPDATED_VET_LAST_NAME);

        Vet updatedVet = this.vetService.update(vetCreated);
        log.info(">>>>" + updatedVet);

        assertEquals(UPDATED_VET_FIRST_NAME, updatedVet.getFirstName());
        assertEquals(UPDATED_VET_LAST_NAME, updatedVet.getLastName());
    }
}
