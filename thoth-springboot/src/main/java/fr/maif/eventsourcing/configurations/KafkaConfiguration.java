package fr.maif.eventsourcing.configurations;

import fr.maif.kafka.KafkaSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(KafkaSettings.class)
@ConditionalOnProperty("thoth.kafka")
public class KafkaConfiguration {

	private final KafkaProperties properties;

	@Autowired
	public KafkaConfiguration(KafkaProperties properties) {
		this.properties = properties;
	}

	@Bean
	public KafkaSettings settings() {
		return KafkaSettings.newBuilder(String.format("%s:%d", properties.getHost(), properties.getPort())).build();
	}

}
