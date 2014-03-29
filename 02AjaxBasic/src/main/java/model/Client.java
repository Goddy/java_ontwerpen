package model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:55 PM
 * Remarks: none
 */


@NamedQueries({
        @NamedQuery(name = "findClientByName", query = "select c from Client c where c.name like :name"),
        @NamedQuery(name = "getClients", query = "select c from Client c")
})
@Entity
@Table(name = "klant")
@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {
    private long id;
    private String name;
    private String vat;

    private Address invoiceAddress;
    private Address deliveryAddress;
    private List<Contact> contacts;

    public Client(String name, String vat, Address iAddress, Address dAddress, List<Contact> contacts) {
        setName(name);
        setVat(vat);
        setInvoiceAddress(iAddress);
        setDeliveryAddress(dAddress);
        setContacts(contacts);
    }

    //Empty constructor
    public Client() {}

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
    @XmlTransient
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
