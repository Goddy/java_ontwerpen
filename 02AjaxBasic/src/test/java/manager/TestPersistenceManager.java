package manager;

import persistence.DatabasePopulator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by u0090265 on 3/25/14.
 */
public class TestPersistenceManager {
    //Application managed entity manager
    public static EntityManager ENTITY_MGR = null;
    private static EntityManagerFactory ENTITY_MGR_FACT = null;

    public static EntityManager getEntityManager(){
        if(ENTITY_MGR == null || !ENTITY_MGR.isOpen()){
            if(ENTITY_MGR_FACT == null || !ENTITY_MGR_FACT.isOpen())
                ENTITY_MGR_FACT = Persistence.createEntityManagerFactory("testServiceManagerPU");
            ENTITY_MGR = ENTITY_MGR_FACT.createEntityManager();
            DatabasePopulator.populate();
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
