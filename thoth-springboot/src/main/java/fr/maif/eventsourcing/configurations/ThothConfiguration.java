package fr.maif.eventsourcing.configurations;

import fr.maif.eventsourcing.impl.JdbcTransactionManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.concurrent.ExecutorService;

@Configuration
@ConditionalOnProperty("thoth")
class ThothConfiguration {

	@Bean
	public JdbcTransactionManager jdbcTransactionManager(DataSource dataSource, ExecutorService executorService) {
		return new JdbcTransactionManager(dataSource, executorService);
	}

}