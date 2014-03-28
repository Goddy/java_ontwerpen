package persistence;

import model.ContactType;

/**
 * Created by u0090265 on 3/26/14.
 */
public interface ContactTypeDao extends Dao<ContactType> {
    ContactType findContactTypeByType(String type);
}
