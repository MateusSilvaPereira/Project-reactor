package com.devmsp.projetoreactor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmsp.projetoreactor.model.Playlist;
import com.devmsp.projetoreactor.repository.PlaylistRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
	private PlaylistRepository repository;
	
	@Override
	public Flux<Playlist> ffindAll() {
		return repository.findAll();
	}

	@Override
	public Mono<Playlist> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Mono<Playlist> save(Playlist playlist) {
		return repository.save(playlist);
	}

	@Override
	public Mono<Void> delete(String id) {
		return repository.deleteById(id);
	}

}
