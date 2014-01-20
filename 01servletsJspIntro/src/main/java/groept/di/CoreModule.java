package groept.di;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class CoreModule extends AbstractModule {
	@Provides
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
	
    @Override
    protected void configure() {
    	install(new BaseAWSModule());
    }
}