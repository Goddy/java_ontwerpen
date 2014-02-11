package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:55 PM
 * Remarks: none
 */


@NamedQueries({
        @NamedQuery(name = "findClientId", query = "from Client where id = :id"),
        @NamedQuery(name="findClientBySearchTerm", query = "from Client where name = :term")
})
@Entity
@Table(name = "klant")
public class Client {
    private long id;
    private String name;
    private String vat;
    private String primaryPhone;
    private String primaryEmail;
    private List<Address> addresses;

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
    @Column(name="naam")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="btw")
    @NotNull
    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    @Column(name="hfdcontacttel")
    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    @Column(name="hfdcontactemail")
    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "client")
    public List<Address> getAddresses() { return addresses == null ? new ArrayList<Address>() : this.addresses; }

    public void setAddresses(List<Address> adresses) {
        this.addresses = adresses;
    }
}
