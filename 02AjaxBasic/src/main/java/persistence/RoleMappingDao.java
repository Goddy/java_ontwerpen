package persistence;

import model.RoleEnum;
import model.RoleMapping;

import java.util.List;

/**
 * Created by u0090265 on 4/11/14.
 */
public interface RoleMappingDao extends Dao<RoleMapping> {
    RoleMapping getRole(String servlet);

    List<RoleMapping> getServlets(RoleEnum role);
}
