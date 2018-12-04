package co.za.adroit.transactor.service;

import co.za.adroit.transactor.service.dto.SalesPersonDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing SalesPerson.
 */
public interface SalesPersonService {

    /**
     * Save a salesPerson.
     *
     * @param salesPersonDTO the entity to save
     * @return the persisted entity
     */
    SalesPersonDTO save(SalesPersonDTO salesPersonDTO);

    /**
     * Get all the salesPeople.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SalesPersonDTO> findAll(Pageable pageable);


    /**
     * Get the "id" salesPerson.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<SalesPersonDTO> findOne(Long id);

    /**
     * Delete the "id" salesPerson.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
