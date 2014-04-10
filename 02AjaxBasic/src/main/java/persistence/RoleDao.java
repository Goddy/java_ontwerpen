package persistence;

import model.Role;

/**
 * Created by u0090265 on 4/9/14.
 */
public interface RoleDao extends Dao<Role> {
    Role getRoleByName(String name);
}
