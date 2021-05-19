package fr.maif.eventsourcing.configurations;

import akka.actor.ActorSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@ConditionalOnBean({ ActorSystem.class, ExecutorService.class })
public class AkkaConfiguration {

	@Value("${thoth.threads:2}")
	private Integer threadCount;

	@Bean
	public ActorSystem actorSystem() {
		return ActorSystem.create();
	}

	@Bean
	public ExecutorService executorService() {
		return Executors.newFixedThreadPool(threadCount);
	}

}
