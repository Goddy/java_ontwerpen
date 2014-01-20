package groept;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Rule;
import org.junit.Test;

import groept.di.BaseAWSModule;
import groept.fixture.ContainerRule;

import com.amazonaws.services.ec2.AmazonEC2;

public class SanityTest {
	@Rule
	public ContainerRule containerRule = new ContainerRule(new BaseAWSModule());
	
	@Inject
	AmazonEC2 amazonEC2;

	@Test
	public void sanityCheckTest() {
		assertNotNull(amazonEC2);
	}

}
