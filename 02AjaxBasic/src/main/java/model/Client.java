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
        @NamedQuery(name = "findClientById", query = "from Client where id = :id"),
        @NamedQuery(name = "findClientByName", query = "from Client where name like :name")
})
@Entity
@Table(name = "klant")
public class Client {
    private long id;
    private String name;
    private String vat;
    private Contact primaryPhone;
    private Contact primaryEmail;
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

    @NotNull
    @Column(name="btw")
    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="hfdcontacttel",insertable=true, updatable=true, nullable=false,unique=true)
    public Contact getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(Contact primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="hfdcontactemail",insertable=true, updatable=true, nullable=false,unique=true)
    public Contact getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(Contact primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "client")
    public List<Address> getAddresses() { return addresses == null ? new ArrayList<Address>() : this.addresses; }

    public void setAddresses(List<Address> adresses) {
        this.addresses = adresses;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder =  new StringBuilder("Id: ").append(getId())
                     .append(" name: ").append(getName())
                     .append(" vat: ").append(getVat())
                     .append(" primary phone: ").append(getPrimaryPhone().getContactData())
                     .append(" primary email: ").append(getPrimaryEmail().getContactData());
        for (Address address:getAddresses()) {
            stringBuilder.append(" address: " + address.toString());
        }

        return  stringBuilder.toString();

    }
}
