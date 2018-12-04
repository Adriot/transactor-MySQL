package co.za.adroit.transactor.service.impl;

import co.za.adroit.transactor.service.SalesPersonService;
import co.za.adroit.transactor.domain.SalesPerson;
import co.za.adroit.transactor.repository.SalesPersonRepository;
import co.za.adroit.transactor.service.dto.SalesPersonDTO;
import co.za.adroit.transactor.service.mapper.SalesPersonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing SalesPerson.
 */
@Service
@Transactional
public class SalesPersonServiceImpl implements SalesPersonService {

    private final Logger log = LoggerFactory.getLogger(SalesPersonServiceImpl.class);

    private final SalesPersonRepository salesPersonRepository;

    private final SalesPersonMapper salesPersonMapper;

    public SalesPersonServiceImpl(SalesPersonRepository salesPersonRepository, SalesPersonMapper salesPersonMapper) {
        this.salesPersonRepository = salesPersonRepository;
        this.salesPersonMapper = salesPersonMapper;
    }

    /**
     * Save a salesPerson.
     *
     * @param salesPersonDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SalesPersonDTO save(SalesPersonDTO salesPersonDTO) {
        log.debug("Request to save SalesPerson : {}", salesPersonDTO);

        SalesPerson salesPerson = salesPersonMapper.toEntity(salesPersonDTO);
        salesPerson = salesPersonRepository.save(salesPerson);
        return salesPersonMapper.toDto(salesPerson);
    }

    /**
     * Get all the salesPeople.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SalesPersonDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SalesPeople");
        return salesPersonRepository.findAll(pageable)
            .map(salesPersonMapper::toDto);
    }


    /**
     * Get one salesPerson by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SalesPersonDTO> findOne(Long id) {
        log.debug("Request to get SalesPerson : {}", id);
        return salesPersonRepository.findById(id)
            .map(salesPersonMapper::toDto);
    }

    /**
     * Delete the salesPerson by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SalesPerson : {}", id);
        salesPersonRepository.deleteById(id);
    }
}
