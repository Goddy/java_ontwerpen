package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: Tom De Dobbeleer
 * Date: 2/11/14
 * Time: 11:20 PM
 * Remarks: none
 */
@NamedQueries({
        @NamedQuery(name="findContactTypeByType", query = "select c from ContactType c where c.type = :type")
})
@Table(name = "contacttype")
@Entity
public class ContactType {

    private Long id;
    private String type;

    public ContactType() {}

    public ContactType(String type) {
        setType(type);
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

    @NotNull
    @Column(name="type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
