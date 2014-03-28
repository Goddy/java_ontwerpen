package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by u0090265 on 3/5/14.
 */

@Entity
@Table(name = "medewerker")
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    private long id;
    private String name;
    private String email;
    private Address address;

    public Employee() {
    }
    public Employee(String name, String email, Address address) {
        setName(name);
        setEmail(email);
        setAddress(address);
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
    @Column(name="naam")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="adres",insertable=true, updatable=true, nullable=false,unique=true)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  new StringBuilder("Id: ").append(getId())
                .append(" name: ").append(getName())
                .append(" email: ").append(getEmail())
                .append(" address: ").append(getAddress()).toString();
    }
}


