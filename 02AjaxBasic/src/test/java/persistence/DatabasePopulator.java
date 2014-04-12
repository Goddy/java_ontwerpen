package persistence;

import factory.TestDaoFactory;
import model.ContactType;
import model.RoleEnum;
import model.RoleMapping;

import static utils.Constants.CONTACTTYPE_EMAIL;
import static utils.Constants.CONTACTTYPE_PHONE;

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
        RoleMapping roleMapping1 = new RoleMapping("/admin.html", RoleEnum.ADMIN);
        RoleMapping roleMapping2 = new RoleMapping("/normal.html", RoleEnum.NORMAL);
        RoleMapping roleMapping3 = new RoleMapping("/public.html", RoleEnum.PUBLIC);
        TestDaoFactory.getRoleMappingDao().create(roleMapping1);
        TestDaoFactory.getRoleMappingDao().create(roleMapping2);
        TestDaoFactory.getRoleMappingDao().create(roleMapping3);
    }
}
