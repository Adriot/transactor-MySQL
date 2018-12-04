package co.za.adroit.transactor.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SalesPerson entity.
 */
public class SalesPersonDTO implements Serializable {

    private Long id;

    @NotNull
    private String salesPersonNumber;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalesPersonNumber() {
        return salesPersonNumber;
    }

    public void setSalesPersonNumber(String salesPersonNumber) {
        this.salesPersonNumber = salesPersonNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SalesPersonDTO salesPersonDTO = (SalesPersonDTO) o;
        if (salesPersonDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), salesPersonDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SalesPersonDTO{" +
            "id=" + getId() +
            ", salesPersonNumber='" + getSalesPersonNumber() + "'" +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            "}";
    }
}
