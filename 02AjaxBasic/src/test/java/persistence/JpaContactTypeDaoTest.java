package persistence;

import general.AbstractTest;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static utils.Constants.CONTACTTYPE_EMAIL;
import static utils.Constants.CONTACTTYPE_PHONE;

/**
 * Created by u0090265 on 3/28/14.
 */
public class JpaContactTypeDaoTest extends AbstractTest {

    @Test
    public void testFindContactTypeByType() throws Exception {
        assertNotNull(contactTypeDao.findContactTypeByType(CONTACTTYPE_EMAIL));
        assertNotNull(contactTypeDao.findContactTypeByType(CONTACTTYPE_PHONE));
    }
}
