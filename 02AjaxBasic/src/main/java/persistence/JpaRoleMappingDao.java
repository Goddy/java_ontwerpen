package persistence;

import model.Role;
import model.RoleMapping;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by u0090265 on 4/11/14.
 */
public class JpaRoleMappingDao extends AbstractJpaDao<RoleMapping> implements RoleMappingDao {
    public JpaRoleMappingDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public RoleMapping getRole(String servlet) {
        return getSingleResultQuery("getRoleByServlet", getParameterMap("servlet", servlet));
    }

    @Override
    public List<RoleMapping> getServlets(Role role) {
        return getMultipleResultQuery("getServletsByRole", getParameterMap("role", role));
    }
}
