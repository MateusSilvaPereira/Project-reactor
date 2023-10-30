package com.devmsp.projetoreactor.services;

import com.devmsp.projetoreactor.model.Playlist;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {

	Flux<Playlist> ffindAll();
	Mono<Playlist> findById(String id);
	Mono<Playlist> save(Playlist playlist);
	Mono<Void> delete(String id);
}
