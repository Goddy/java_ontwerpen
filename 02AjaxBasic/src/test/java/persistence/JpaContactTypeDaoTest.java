package persistence;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by u0090265 on 3/28/14.
 */
public class JpaContactTypeDaoTest {

    ContactTypeDao contactTypeDao = TestDaoFactory.getContactTypeDao();

    @Test
    public void testFindContactTypeByType() throws Exception {
        assertNotNull(contactTypeDao.findContactTypeByType("gsm"));
        assertNotNull(contactTypeDao.findContactTypeByType("email"));
    }
}
