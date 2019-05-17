package com.capgemini.userfavouritesongservice.service;

import java.util.List;

import com.capgemini.userfavouritesongservice.entity.Song;
import com.capgemini.userfavouritesongservice.entity.UserFavouriteSong;

public interface UserFavouriteSongService {

	public UserFavouriteSong addFavouriteSong(String userEmail,int songId);
	public List<Song> getFavouriteSongList(String userEmail);
	public UserFavouriteSong updateFavouriteSongList(String userEmail,int songId);
}
