package persistence;

import model.Role;

import javax.persistence.EntityManager;

/**
 * Created by u0090265 on 4/9/14.
 */
public class JpaRoleDao extends AbstractJpaDao<Role> implements RoleDao {

    public JpaRoleDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Role getRoleByName(String name) {
        return getSingleResultQuery("findRolByName", getParameterMap("name", name));
    }
}
