package co.za.adroit.transactor.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A SalesPerson.
 */
@Entity
@Table(name = "sales_person")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SalesPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "sales_person_number", nullable = false)
    private String salesPersonNumber;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "surname", nullable = false)
    private String surname;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalesPersonNumber() {
        return salesPersonNumber;
    }

    public SalesPerson salesPersonNumber(String salesPersonNumber) {
        this.salesPersonNumber = salesPersonNumber;
        return this;
    }

    public void setSalesPersonNumber(String salesPersonNumber) {
        this.salesPersonNumber = salesPersonNumber;
    }

    public String getName() {
        return name;
    }

    public SalesPerson name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public SalesPerson surname(String surname) {
        this.surname = surname;
        return this;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SalesPerson salesPerson = (SalesPerson) o;
        if (salesPerson.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), salesPerson.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SalesPerson{" +
            "id=" + getId() +
            ", salesPersonNumber='" + getSalesPersonNumber() + "'" +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            "}";
    }
}
