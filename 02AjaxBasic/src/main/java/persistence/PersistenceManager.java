package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Singleton class to hold the Application managed JPA EntityManager
 * @author Stijn Heylen
 *
 */
public class PersistenceManager {
    //Application managed entity manager
    public static EntityManager ENTITY_MGR = null;
    private static EntityManagerFactory ENTITY_MGR_FACT = null;

    public static EntityManager getEntityManager(){
        if(ENTITY_MGR == null || !ENTITY_MGR.isOpen()){
            if(ENTITY_MGR_FACT == null || !ENTITY_MGR_FACT.isOpen())
                ENTITY_MGR_FACT = Persistence.createEntityManagerFactory("serviceManagerPU");
            ENTITY_MGR = ENTITY_MGR_FACT.createEntityManager();
        }
        return ENTITY_MGR;
    }
    public static void cleanResources(){
        if(ENTITY_MGR!=null && ENTITY_MGR.isOpen())
            ENTITY_MGR.close();
        if(ENTITY_MGR_FACT != null && ENTITY_MGR_FACT.isOpen())
            ENTITY_MGR_FACT.close();
    }
}
