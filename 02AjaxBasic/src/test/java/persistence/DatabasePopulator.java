package persistence;

import model.ContactType;

/**
 * Created by u0090265 on 3/26/14.
 */
public class DatabasePopulator {
    static void populate() {
        ContactType contactType1 = new ContactType("gsm");
        contactType1.setId(Long.parseLong("1"));
        TestDaoFactory.getContactTypeDao().create(contactType1);
        ContactType contactType2 = new ContactType("email");
        contactType2.setId(Long.parseLong("2"));
        TestDaoFactory.getContactTypeDao().create(contactType2);
    }
}
