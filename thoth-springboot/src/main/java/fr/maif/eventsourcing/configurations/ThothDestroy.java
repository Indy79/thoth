package fr.maif.eventsourcing.configurations;

import akka.actor.ActorSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.util.Optional;
import java.util.concurrent.ExecutorService;

@Configuration
public class ThothDestroy {

	private final ActorSystem actorSystem;
	private final ExecutorService executorService;

	@Autowired
	public ThothDestroy(ActorSystem actorSystem, ExecutorService executorService) {
		this.actorSystem = actorSystem;
		this.executorService = executorService;
	}

	@PreDestroy
	public void destroy() {
		Optional.ofNullable(executorService)
				.ifPresent(ExecutorService::shutdown);
		Optional.ofNullable(actorSystem)
				.ifPresent(ActorSystem::terminate);
	}

}
