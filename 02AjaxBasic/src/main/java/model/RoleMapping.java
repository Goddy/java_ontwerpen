package model;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "getRoleByServlet", query = "SELECT r FROM RoleMapping r where r.servlet = :servlet"),
        @NamedQuery(name = "getServletsByRole", query = "SELECT r FROM RoleMapping r where r.role = :role")
})
@Cache(
        type = CacheType.SOFT, // Cache everything until the JVM decides memory is low.
        size = 10000,
        expiry = 1800000  // 30 minutes
)
@Table(name = "rolmap")
public class RoleMapping {
    private String servlet;
    private Role role;

    public RoleMapping(String servlet, Role role) {
        setServlet(servlet);
        setRole(role);
    }

    public RoleMapping() {
    }

    @Id
    @Column(name = "servlet")
    public String getServlet() {
        return servlet;
    }

    public void setServlet(String servlet) {
        this.servlet = servlet;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rol")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
