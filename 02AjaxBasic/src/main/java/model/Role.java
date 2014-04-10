package model;

import javax.persistence.*;

@Entity
@NamedQueries({
@NamedQuery(name = "findAllRoles", query = "SELECT r FROM Role r"),
@NamedQuery(name = "findRolByName", query = "SELECT r FROM Role r where r.roleName like :name")
})
@Table(name = "rol")
public class Role {

	private int id;
	private String roleName;

	public Role(){}
	public Role(String name){
		this.roleName =name;
	}

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

    @Column(name="rolname", nullable = false)
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String rolname) {
		this.roleName = rolname;
	}

}
