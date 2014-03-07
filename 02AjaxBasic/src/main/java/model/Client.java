package model;

import org.codehaus.jackson.annotate.JsonIgnore;

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

    private Address invoiceAddress;
    private Address deliveryAddress;
    private List<Contact> contacts;

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

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "client")
    public List<Contact> getContacts() { return contacts == null ? new ArrayList<Contact>() : this.contacts; }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NotNull
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="FacturatieAdr",insertable=true, updatable=true, nullable=false,unique=true)
    public Address getInvoiceAddress() { return this.invoiceAddress; }

    public void setInvoiceAddress(Address address) {
        this.invoiceAddress = address;
    }

    @NotNull
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="AfleverAdr",insertable=true, updatable=true, nullable=false,unique=true)
    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder =  new StringBuilder("Id: ").append(getId())
                     .append(" name: ").append(getName())
                     .append(" vat: ").append(getVat());

        return  stringBuilder.toString();

    }


}
