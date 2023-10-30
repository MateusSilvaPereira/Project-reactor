package com.devmsp.projetoreactor;

/*@Component
public class DummyData implements CommandLineRunner {

	private final PlaylistRepository repository;

	DummyData(PlaylistRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll()
				.thenMany(Flux
						.just("API REST Spring Boot", "Deplay de uma aplicação java no IBM cloud", "Java 8", "GitHub",
							  "Spring Security", "Web service RestFull", "Bean no Spring Framework")
						.map(nome -> new Playlist(UUID.randomUUID().toString(), nome))
						.flatMap(repository::save))
				.subscribe(System.out::println);

	}

}*/
