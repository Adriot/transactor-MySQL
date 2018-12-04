package co.za.adroit.transactor.service.dto;

import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Sale entity.
 */
public class SaleDTO implements Serializable {

    private Long id;

    @NotNull
    private ZonedDateTime timestamp;

    @NotNull
    private String productCode;

    @NotNull
    private Integer quantity;

    @NotNull
    private Double subTotal;

    @NotNull
    private String salesPersonNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public String getSalesPersonNumber() {
        return salesPersonNumber;
    }

    public void setSalesPersonNumber(String salesPersonNumber) {
        this.salesPersonNumber = salesPersonNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SaleDTO saleDTO = (SaleDTO) o;
        if (saleDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), saleDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SaleDTO{" +
            "id=" + getId() +
            ", timestamp='" + getTimestamp() + "'" +
            ", productCode='" + getProductCode() + "'" +
            ", quantity=" + getQuantity() +
            ", subTotal=" + getSubTotal() +
            ", salesPersonNumber='" + getSalesPersonNumber() + "'" +
            "}";
    }
}
