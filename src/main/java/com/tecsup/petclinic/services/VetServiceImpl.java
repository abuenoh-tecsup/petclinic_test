package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exceptions.VetNotFoundException;
import com.tecsup.petclinic.repositories.VetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de veterinarios.
 *
 * @author edu
 *
 */
@Service
@Slf4j
public class VetServiceImpl implements VetService {

    VetRepository vetRepository;

    public VetServiceImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    /**
     *
     * @param vet
     * @return
     */
    @Override
    public Vet create(Vet vet) {
        return vetRepository.save(vet);
    }

    /**
     *
     * @param vet
     * @return
     */
    @Override
    public Vet update(Vet vet) {
        return vetRepository.save(vet);
    }

    /**
     *
     * @param id
     * @throws VetNotFoundException
     */
    @Override
    public void delete(Integer id) throws VetNotFoundException {
        Vet vet = findById(id);
        vetRepository.delete(vet);
    }

    /**
     *
     * @param id
     * @return
     * @throws VetNotFoundException
     */
    @Override
    public Vet findById(Integer id) throws VetNotFoundException {
        Optional<Vet> vet = vetRepository.findById(id);

        if (!vet.isPresent())
            throw new VetNotFoundException("Vet with ID " + id + " not found!");

        return vet.get();
    }

    /**
     *
     * @param firstName
     * @return
     */
    @Override
    public List<Vet> findByFirstName(String firstName) {
        List<Vet> vets = vetRepository.findByFirstName(firstName);

        vets.forEach(vet -> log.info("" + vet));

        return vets;
    }

    /**
     *
     * @param lastName
     * @return
     */
    @Override
    public List<Vet> findByLastName(String lastName) {
        List<Vet> vets = vetRepository.findByLastName(lastName);

        vets.forEach(vet -> log.info("" + vet));

        return vets;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Vet> findAll() {
        return vetRepository.findAll();
    }
}
