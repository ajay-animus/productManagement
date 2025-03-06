package com.ecommerce.productservice.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;

@Configuration
public class DataSourceConfig extends AbstractMongoClientConfiguration{

	@Override
	protected String getDatabaseName() {
		return "product-service";
	}
	
	@Override
	public MongoTemplate mongoTemplate(MongoDatabaseFactory databaseFactory, MappingMongoConverter converter) {
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		MongoTemplate template = new MongoTemplate(databaseFactory, converter);
		template.setReadPreference(ReadPreference.primary());
		template.setWriteConcern(WriteConcern.MAJORITY);
		return template;
	}

}
