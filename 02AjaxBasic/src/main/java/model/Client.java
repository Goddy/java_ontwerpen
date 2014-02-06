package model;

import javax.persistence.*;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:55 PM
 * Remarks: none
 */


@NamedQueries({
        @NamedQuery(name = "findClientId", query = "from Client where id = :id")
})
@Entity
@Table(name = "klant")
public class Client {
    private long id;
    private String name;
    private String vat;
    private String primaryPhone;
    private String primaryEmail;
    private Address Address;




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

}
