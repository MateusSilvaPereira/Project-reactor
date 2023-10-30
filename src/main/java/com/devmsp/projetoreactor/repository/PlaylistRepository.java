package com.devmsp.projetoreactor.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.devmsp.projetoreactor.model.Playlist;

@Repository
public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String>{
	
}
