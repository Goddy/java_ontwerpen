package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * User: Tom De Dobbeleer
 * Date: 2/11/14
 * Time: 11:24 PM
 * Remarks: none
 */

@Entity
@Table(name="contact")
@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contact {
    private Long id;
    private String contactData;
    private ContactType contactType;
    @XmlTransient
    private Client client;

    public Contact() {}
    public Contact(String contactData, ContactType contactType, Client client) {
        setClient(client);
        setContactData(contactData);
        setContactType(contactType);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="contact")
    public String getContactData() {
        return contactData;
    }

    public void setContactData(String contact) {
        this.contactData = contact;
    }

    @NotNull
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="ct_id",insertable=true, updatable=true, nullable=false)
    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "k_id", nullable = false)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
