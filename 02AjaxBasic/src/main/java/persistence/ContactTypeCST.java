package persistence;

import model.ContactType;

public class ContactTypeCST {
	ContactTypeDao contactTypeDao = DaoFactory.getContactTypeDao();
	
	public ContactType EMAIL() {
		try {
			return contactTypeDao.findContactTypeByType("Email");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ContactType("Email");
	}
	public ContactType MOBILE() {
		try {
			return contactTypeDao.findContactTypeByType("Mobile");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ContactType("Mobile");
	}
	public ContactType FIXPHONE() {
		try {
			return contactTypeDao.findContactTypeByType("FixPhone");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ContactType("FixPhone");
	}
}
