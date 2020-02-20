package at.luzi.easy.billy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 *
 * Configuration for Mongo DB.
 *
 * @author lukaszimmermann
 *
 */
@Configuration
@EnableMongoAuditing
public class MongoClientConfiguration extends AbstractMongoClientConfiguration {

	@Value("${mongo.connection.url}")
	private String url;

	@Value("${mongo.db}")
	private String db;

	@Override
	protected String getDatabaseName() {
		return db;
	}

	/**
	 * Provides the {@link MongoClient}.
	 */
	@Override
	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create(url);
	}

	/**
	 * Provides the {@link MongoOperations} interface.
	 *
	 * @return {@link MongoOperations}
	 */
	@Bean
	public MongoOperations ops() {
		return new MongoTemplate(new SimpleMongoClientDbFactory(MongoClients.create(), getDatabaseName()));
	}

}
