package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: Tom De Dobbeleer
 * Date: 2/6/14
 * Time: 5:00 PM
 * Remarks: none
 */

@Entity
@Table(name="AdresType")
public class AddressType {
    private Long id;
    private String type;

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
    @Column(name="Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
