package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exceptions.VetNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Slf4j
public class SearchVetServiceTest {
    @Autowired
    private VetService vetService ;

    @Test
    public void testFindVetById() {
        String FIRST_NAME_EXPECTED = "James";
        Integer ID = 1;

        Vet vet = null;

        try {
            vet = this.vetService.findById(ID);
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }
        assertEquals(FIRST_NAME_EXPECTED, vet.getFirstName());
    }

    @Test
    public void testFindVetByFirstName() {
        String FIND_FIRST_NAME = "James";
        int SIZE_EXPECTED = 1;

        List<Vet> vets = this.vetService.findByFirstName(FIND_FIRST_NAME);

        assertEquals(SIZE_EXPECTED, vets.size());
    }

    @Test
    public void testFindVetByLastName() {
        String FIND_LAST_NAME = "Carter";
        int SIZE_EXPECTED = 1;

        List<Vet> vets = this.vetService.findByLastName(FIND_LAST_NAME);

        assertEquals(SIZE_EXPECTED, vets.size());
    }
}
