package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by u0090265 on 3/6/14.
 */
@NamedQueries({
        @NamedQuery(name = "findServiceCallsForClient", query = "Select s from ServiceCall s where s.client = :client")
})
@Entity
@Table(name = "serviceoproep")
@XmlRootElement(name = "ServiceCall")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceCall implements persistence.Entity {
    private long id;
    private String shortDescription;
    private String description;
    private Date opened;
    private Date closed;
    private Employee employee;
    private Client client;

    public ServiceCall() {
        setOpened(new Date());
    }

    public ServiceCall(String shortDescription, String description, Employee employee, Client client) {
        setClient(client);
        setDescription(description);
        setShortDescription(shortDescription);
        setEmployee(employee);
        setOpened(new Date());
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

    @Basic
    @Column(name = "KorteOmschrijving")
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Basic
    @Column(name = "Omschrijving")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "Geopend")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getOpened() {
        return opened;
    }

    public void setOpened(Date opened) {
        this.opened = opened;
    }

    @Column(name = "Afgesloten")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getClosed() {
        return closed;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }

    @NotNull
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="M_id",insertable=true, updatable=true, nullable=false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @NotNull
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="K_id",insertable=true, updatable=true, nullable=false)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceCall that = (ServiceCall) o;

        if (id != that.id) return false;
        if (employee != that.employee) return false;
        if (client != that.client) return false;
        if (closed != null ? !closed.equals(that.closed) : that.closed != null) return false;
        if (opened != null ? !opened.equals(that.opened) : that.opened != null) return false;
        if (shortDescription != null ? !shortDescription.equals(that.shortDescription) : that.shortDescription != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }
}
