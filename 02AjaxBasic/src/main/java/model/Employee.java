package model;

import utils.PassCrypter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * Created by u0090265 on 3/5/14.
 */

@Entity
@NamedQueries({
        @NamedQuery(name="findEmployeeByUsername", query = "select e from Employee e where e.username = :username")
})
@Table(name = "medewerker")
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    private long id;
    private String firstName;
    private String givenName;
    private String username;
    private String email;
    private String password;
    private Address address;
    private Role role;
    private List serviceCalls;


    public Employee() {
    }
    public Employee(String firstName, String lastName, String username, String email, Address address, Role role) {
        setGivenName(lastName);
        setUsername(username);
        setFirstName(firstName);
        setEmail(email);
        setAddress(address);
        setRole(role);
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
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
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
                .append(" name: ").append(getFirstName())
                .append(" email: ").append(getEmail())
                .append(" address: ").append(getAddress())
                .append(" role: ").append(getRole()).toString();
    }

    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List getServiceCalls() {
        return serviceCalls;
    }

    public void setServiceCalls(List serviceCalls) {
        this.serviceCalls = serviceCalls;
    }

    @Column(name="wachtwoord")
    public String getPassword() {
        return password;
    }
    /**
     * To be used when setting already encrypted password data
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * To be used when accepting password data before encryption.
     * @param password
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.security.spec.InvalidKeySpecException
     */
    public void setAndEncryptPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.password = PassCrypter.createHash(password);
    }

    @Column(name="familienaam")
    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @Column(name="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


