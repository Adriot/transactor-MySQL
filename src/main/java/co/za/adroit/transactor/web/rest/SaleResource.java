package co.za.adroit.transactor.web.rest;

import com.codahale.metrics.annotation.Timed;
import co.za.adroit.transactor.service.SaleService;
import co.za.adroit.transactor.web.rest.errors.BadRequestAlertException;
import co.za.adroit.transactor.web.rest.util.HeaderUtil;
import co.za.adroit.transactor.web.rest.util.PaginationUtil;
import co.za.adroit.transactor.service.dto.SaleDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Sale.
 */
@RestController
@RequestMapping("/api")
public class SaleResource {

    private final Logger log = LoggerFactory.getLogger(SaleResource.class);

    private static final String ENTITY_NAME = "sale";

    private final SaleService saleService;

    public SaleResource(SaleService saleService) {
        this.saleService = saleService;
    }

    /**
     * POST  /sales : Create a new sale.
     *
     * @param saleDTO the saleDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new saleDTO, or with status 400 (Bad Request) if the sale has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sales")
    @Timed
    public ResponseEntity<SaleDTO> createSale(@Valid @RequestBody SaleDTO saleDTO) throws URISyntaxException {
        log.debug("REST request to save Sale : {}", saleDTO);
        if (saleDTO.getId() != null) {
            throw new BadRequestAlertException("A new sale cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SaleDTO result = saleService.save(saleDTO);
        return ResponseEntity.created(new URI("/api/sales/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sales : Updates an existing sale.
     *
     * @param saleDTO the saleDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated saleDTO,
     * or with status 400 (Bad Request) if the saleDTO is not valid,
     * or with status 500 (Internal Server Error) if the saleDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sales")
    @Timed
    public ResponseEntity<SaleDTO> updateSale(@Valid @RequestBody SaleDTO saleDTO) throws URISyntaxException {
        log.debug("REST request to update Sale : {}", saleDTO);
        if (saleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SaleDTO result = saleService.save(saleDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, saleDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sales : get all the sales.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of sales in body
     */
    @GetMapping("/sales")
    @Timed
    public ResponseEntity<List<SaleDTO>> getAllSales(Pageable pageable) {
        log.debug("REST request to get a page of Sales");
        Page<SaleDTO> page = saleService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sales");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /sales/:id : get the "id" sale.
     *
     * @param id the id of the saleDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the saleDTO, or with status 404 (Not Found)
     */
    @GetMapping("/sales/{id}")
    @Timed
    public ResponseEntity<SaleDTO> getSale(@PathVariable Long id) {
        log.debug("REST request to get Sale : {}", id);
        Optional<SaleDTO> saleDTO = saleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(saleDTO);
    }

    /**
     * DELETE  /sales/:id : delete the "id" sale.
     *
     * @param id the id of the saleDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sales/{id}")
    @Timed
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        log.debug("REST request to delete Sale : {}", id);
        saleService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
