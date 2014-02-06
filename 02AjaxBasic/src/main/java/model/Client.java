package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:55 PM
 * Remarks: none
 */


@NamedQueries({
        @NamedQuery(name = "findClientId", query = "from Client where id = :id")
})
@Entity
@Table(name = "klant")
public class Client {
    private long id;
    private String name;
    private String vat;
    private String primaryPhone;
    private String primaryEmail;
    private Address Address;

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
    @Column(name="Naam")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="BTW")
    @NotNull
    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    @Column(name="HfdContactTel")
    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    @Column(name="HfdContactEmail")
    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    @NotNull
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="Id", referencedColumnName="K_id", insertable=true, updatable=true, nullable=false,unique=true)
    public Address getAddress() {
        return Address;
    }

    public void setAddress(Address address) {
        Address = address;
    }
}
