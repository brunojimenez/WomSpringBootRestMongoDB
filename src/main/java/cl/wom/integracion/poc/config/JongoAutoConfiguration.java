package cl.wom.integracion.poc.config;

import org.jongo.Jongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.mongodb.DB;
import com.mongodb.Mongo;

@Configuration
@ConditionalOnClass({ Jongo.class })
public class JongoAutoConfiguration {

	/**
	 * Mongo
	 */
	@Autowired
	protected Mongo mongo;

	@Autowired
	protected Environment env;

	/**
	 * Create a instance of the {@code Jongo} class.
	 *
	 * @return The instance of {@code Jongo} class.
	 */
	@Bean
	@SuppressWarnings("deprecation")
	public Jongo jongo() {
		String databaseName = env.getProperty("spring.data.mongodb.database");
		final DB database = mongo.getDB(databaseName);
		return new Jongo(database);
	}

}
