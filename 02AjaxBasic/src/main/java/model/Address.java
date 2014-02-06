package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: Tom De Dobbeleer
 * Date: 2/05/14
 * Time: 9:47 PM
 * Remarks: none
 */

@NamedQueries({
        @NamedQuery(name = "findAddressById", query = "from Address where id = :id")
})
@Entity
@Table(name = "Adres")
public class Address {
    private long id;
    private int postalCode;
    private String street;
    private int number;
    private String city;
    private String country;
    private AddressType type;

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
    @Column(name = "Postcode")
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
    @Column(name = "Woonplaats")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @NotNull
    @Column(name="Nr")
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
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="AT_id",insertable=true, updatable=true, nullable=false,unique=true)
    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }
}
