package com.capgemini.userfavouritesongservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.userfavouritesongservice.entity.Song;
import com.capgemini.userfavouritesongservice.entity.UserFavouriteSong;
import com.capgemini.userfavouritesongservice.service.UserFavouriteSongService;

@RestController
@CrossOrigin("*")
public class UserFavouriteSongController {

	@Autowired
	private UserFavouriteSongService userFavouriteService;

	
	
	@PostMapping("/favourite/{userEmail}/{songId}")
	public ResponseEntity<UserFavouriteSong> addFavouriteSong(@PathVariable String userEmail,
			@PathVariable int songId) {
		UserFavouriteSong favouriteSong = userFavouriteService.addFavouriteSong(userEmail, songId);
		return new ResponseEntity<UserFavouriteSong>(favouriteSong, HttpStatus.OK);
	}

	@GetMapping("/favourite/{userEmail}")
	public ResponseEntity<List<Song>> getUserFavouriteSongList(@PathVariable String userEmail) {
		List<Song> favouriteSong = userFavouriteService.getFavouriteSongList(userEmail);
		return new ResponseEntity<List<Song>>(favouriteSong, HttpStatus.OK);
	}

	@PutMapping("/favourite/{userEmail}/{songId}")
	public ResponseEntity<UserFavouriteSong> deleteFavouriteSong(@PathVariable String userEmail, @PathVariable int songId) {
		UserFavouriteSong favouriteSong = userFavouriteService.updateFavouriteSongList(userEmail, songId);
		return new ResponseEntity<UserFavouriteSong>(favouriteSong,HttpStatus.OK);
	}
}
