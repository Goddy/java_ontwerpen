package persistence;

import model.Address;
import model.AddressType;
import model.Client;
import model.ContactType;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:54 PM
 * Remarks: none
 */
public class HbnClientDao extends AbstractHbnDao implements ClientDao {

    public HbnClientDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void registerClient(Client client, Address address) {
        Transaction tx = null;

        try {
            tx = getSession().beginTransaction();
            address.setClient(client);
            client.getAddresses().add(address);
            super.create(client);
            super.create(address);

            tx.commit(); // Flush happens automatically
        }
        catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e; // or display error message
        }
        finally {
            getSession().close();
        }
    }

    @Override
    public ContactType findContactTypeByName(String type) {
        Transaction tx = null;
        try {
            tx = getSession().beginTransaction();
            Query q = getSession().getNamedQuery("findContactTypeByType");
            q.setParameter("type", type);
            ContactType contactType = (ContactType) q.uniqueResult();
            tx.commit();

            return contactType;
        }
        catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e; // or display error message
        }
        finally {
            getSession().close();
        }


    }

    @Override
    public AddressType findAddressTypeById(Long id) {
        Transaction tx = null;
        try {
            tx = getSession().beginTransaction();
            Query q = getSession().getNamedQuery("findAddressTypeById");
            q.setParameter("id", id);
            AddressType addressType = (AddressType) q.uniqueResult();
            tx.commit();

            return addressType;
        }
        catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e; // or display error message
        }
        finally {
            getSession().close();
        }


    }

    @Override
    public List<Client> findClientById(Long id) {
        Transaction tx = null;
        try {
            tx = getSession().beginTransaction();
            Query q = getSession().getNamedQuery("findClientById");
            q.setParameter("id", id);
            List<Client> clients = (List<Client>) q.list();
            tx.commit();

            return clients;
        }
        catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e; // or display error message
        }
        finally {
            getSession().close();
        }
    }

    @Override
    public List<Client> findClientByName(String name) {
        Transaction tx = null;
        try {
            tx = getSession().beginTransaction();
            Query q = getSession().getNamedQuery("findClientByName");
            q.setParameter("name", "%" + name + "%");
            List<Client> clients = (List<Client>) q.list();
            tx.commit();

            return clients;
        }
        catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e; // or display error message
        }
        finally {
            getSession().close();
        }
    }
}
