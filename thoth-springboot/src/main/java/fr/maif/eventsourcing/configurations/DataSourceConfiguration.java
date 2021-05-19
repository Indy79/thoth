package fr.maif.eventsourcing.configurations;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Optional;

@Configuration
@ConditionalOnBean(DataSource.class)
public class DataSourceConfiguration {

	private final DataSourceProperties properties;

	@Autowired
	public DataSourceConfiguration(DataSourceProperties properties) {
		this.properties = properties;
	}

	@Bean
	public DataSource dataSource() {
		PGSimpleDataSource dataSource = new PGSimpleDataSource();
		dataSource.setServerName(properties.getHost());
		Optional.ofNullable(properties.getCredential())
				.ifPresent(credentialConfiguration -> {
					dataSource.setUser(credentialConfiguration.getUsername());
					dataSource.setPassword(credentialConfiguration.getPassword());
				});
		dataSource.setDatabaseName(properties.getName());
		dataSource.setPortNumber(properties.getPort());
		return dataSource;
	}

}
