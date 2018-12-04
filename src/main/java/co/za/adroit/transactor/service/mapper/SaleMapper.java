package co.za.adroit.transactor.service.mapper;

import co.za.adroit.transactor.domain.*;
import co.za.adroit.transactor.service.dto.SaleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Sale and its DTO SaleDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SaleMapper extends EntityMapper<SaleDTO, Sale> {



    default Sale fromId(Long id) {
        if (id == null) {
            return null;
        }
        Sale sale = new Sale();
        sale.setId(id);
        return sale;
    }
}
