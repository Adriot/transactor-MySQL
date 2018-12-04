package co.za.adroit.transactor.service.mapper;

import co.za.adroit.transactor.domain.*;
import co.za.adroit.transactor.service.dto.SalesPersonDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity SalesPerson and its DTO SalesPersonDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SalesPersonMapper extends EntityMapper<SalesPersonDTO, SalesPerson> {



    default SalesPerson fromId(Long id) {
        if (id == null) {
            return null;
        }
        SalesPerson salesPerson = new SalesPerson();
        salesPerson.setId(id);
        return salesPerson;
    }
}
