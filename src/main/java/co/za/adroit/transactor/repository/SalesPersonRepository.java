package co.za.adroit.transactor.repository;

import co.za.adroit.transactor.domain.SalesPerson;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the SalesPerson entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SalesPersonRepository extends JpaRepository<SalesPerson, Long> {

}
