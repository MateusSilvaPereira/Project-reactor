package com.devmsp.projetoreactor.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmsp.projetoreactor.model.Playlist;
import com.devmsp.projetoreactor.services.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

	@Autowired
	private PlaylistService service;
	
	@GetMapping
	public ResponseEntity<Flux<Playlist>> findAll(){
		return ResponseEntity.ok().body(service.ffindAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mono<Playlist>> findById(@PathVariable String id){
		Mono<Playlist> playlist = service.findById(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(playlist);
	}
	
	@PostMapping
	public ResponseEntity<Mono<Playlist>> create(@RequestBody Playlist playlist){
		return ResponseEntity.ok().body(service.save(playlist));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Mono<Void>> delete(@PathVariable String id){
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
	}
	
	@GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Playlist>> getPlayListByEvents(){
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
		Flux<Playlist> events =  service.ffindAll();
		System.out.println("Passou aqui events");
		return Flux.zip(interval, events);
	}
}
