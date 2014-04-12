package persistence;

import factory.TestDaoFactory;
import model.ContactType;
import model.Role;
import model.RoleMapping;

import static utils.Constants.*;

/**
 * Created by u0090265 on 3/26/14.
 */
public class DatabasePopulator {
    public static void populate() {
        ContactType contactType1 = new ContactType(CONTACTTYPE_PHONE);
        contactType1.setId(Long.parseLong("1"));
        TestDaoFactory.getContactTypeDao().create(contactType1);
        ContactType contactType2 = new ContactType(CONTACTTYPE_EMAIL);
        contactType2.setId(Long.parseLong("2"));
        TestDaoFactory.getContactTypeDao().create(contactType2);
        Role role1 = new Role(ROLETYPE_ADMIN);
        Role role2 = new Role(ROLETYPE_NORMAL);
        Role role3 = new Role(ROLETYPE_PUBLIC);
        TestDaoFactory.getRoleDao().create(role1);
        TestDaoFactory.getRoleDao().create(role2);
        TestDaoFactory.getRoleDao().create(role3);
        RoleMapping roleMapping1 = new RoleMapping("/admin.html", role1);
        RoleMapping roleMapping2 = new RoleMapping("/normal.html", role2);
        RoleMapping roleMapping3 = new RoleMapping("/public.html", role3);
        TestDaoFactory.getRoleMappingDao().create(roleMapping1);
        TestDaoFactory.getRoleMappingDao().create(roleMapping2);
        TestDaoFactory.getRoleMappingDao().create(roleMapping3);
    }
}
