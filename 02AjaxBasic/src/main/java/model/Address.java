package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: Tom De Dobbeleer
 * Date: 2/05/14
 * Time: 9:47 PM
 * Remarks: none
 */

@NamedQueries({
        @NamedQuery(name = "findAddressById", query = "select a from Address a where a.id = :id")
})
@Entity
@Table(name = "adres")
@XmlRootElement(name = "ServiceCall")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    private long id;
    private int postalCode;
    private String street;
    private int number;
    private String city;
    private String country;
    private boolean active;

    public Address() {}
    public Address(int postalCode, String street, int number, String city, String country) {
        this.setPostalCode(postalCode);
        this.setStreet(street);
        this.setPostalCode(postalCode);
        this.setNumber(number);
        this.setCity(city);
        this.setCountry(country);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "postcode")
    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @NotNull
    @Column(name = "straat")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @NotNull
    @Column(name = "woonplaats")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @NotNull
    @Column(name="nr")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @NotNull
    @Column(name="land")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @NotNull
    @Column(name="actief")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
       return new StringBuilder().append("id: ").append(getId())
                .append(" postalCode: ").append(getPostalCode())
                .append(" street: ").append(getStreet())
                .append(" number: ").append(getNumber())
                .append(" city: ").append(getCity())
                .append(" country: ").append(getCountry())
                .append(" active: ").append(isActive()).toString();
    }
}
