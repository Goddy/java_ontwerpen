package persistence;

import general.AbstractTest;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by u0090265 on 3/28/14.
 */
public class JpaContactTypeDaoTest extends AbstractTest {

    @Test
    public void testFindContactTypeByType() throws Exception {
        assertNotNull(contactTypeDao.findContactTypeByType("gsm"));
        assertNotNull(contactTypeDao.findContactTypeByType("email"));
    }
}
