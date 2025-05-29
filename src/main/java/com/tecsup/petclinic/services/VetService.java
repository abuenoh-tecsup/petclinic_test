package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exceptions.VetNotFoundException;

import java.util.List;

public interface VetService {

    /**
     * Crea un nuevo veterinario.
     *
     * @param vet
     * @return Vet creado
     */
    Vet create(Vet vet);

    /**
     * Actualiza un veterinario existente.
     *
     * @param vet
     * @return Vet actualizado
     */
    Vet update(Vet vet);

    /**
     * Elimina un veterinario por ID.
     *
     * @param id
     * @throws VetNotFoundException
     */
    void delete(Integer id) throws VetNotFoundException;

    /**
     * Busca un veterinario por ID.
     *
     * @param id
     * @return Vet encontrado
     * @throws VetNotFoundException
     */
    Vet findById(Integer id) throws VetNotFoundException;

    /**
     * Busca veterinarios por nombre.
     *
     * @param firstName
     * @return Lista de veterinarios que coinciden con el nombre
     */
    List<Vet> findByFirstName(String firstName);

    /**
     * Lista todos los veterinarios.
     *
     * @return Lista completa de veterinarios
     */
    List<Vet> findAll();
}
