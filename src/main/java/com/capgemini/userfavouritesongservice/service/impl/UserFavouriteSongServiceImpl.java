package com.capgemini.userfavouritesongservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capgemini.userfavouritesongservice.dao.UserFavouriteSongDao;
import com.capgemini.userfavouritesongservice.entity.Song;
import com.capgemini.userfavouritesongservice.entity.UserFavouriteSong;
import com.capgemini.userfavouritesongservice.service.UserFavouriteSongService;

@Service
public class UserFavouriteSongServiceImpl implements UserFavouriteSongService {

	@Autowired
	private UserFavouriteSongDao userFavouriteDao;

	
	@Autowired
	private RestTemplate restTemplate;
	
	private String baseUrl= "http://localhost:8082/song/";
	
	@Override
	public UserFavouriteSong addFavouriteSong(String userEmail, int songId) {
		UserFavouriteSong favouriteSong = userFavouriteDao.findByuserEmail(userEmail);

		if (favouriteSong == null) {
			favouriteSong = new UserFavouriteSong();
		}

		favouriteSong.setUserEmail(userEmail);
		List<Integer> songList = favouriteSong.getFavouriteSong();
		songList.add(songId);
		favouriteSong.setFavouriteSong(songList);

		return userFavouriteDao.save(favouriteSong);
	}

	@Override
	public List<Song> getFavouriteSongList(String userEmail) {
		UserFavouriteSong favouriteSong=userFavouriteDao.findByuserEmail(userEmail);
			List<Song> songs = new ArrayList<Song>();
			for (int songId :favouriteSong.getFavouriteSong() ) {
				Song song = restTemplate.getForEntity(baseUrl + songId, Song.class).getBody();
				songs.add(song);
			}
			return songs;
	}

	@Override
	public UserFavouriteSong updateFavouriteSongList(String userEmail, int songId) {
		UserFavouriteSong favouriteSong = userFavouriteDao.findByuserEmail(userEmail);

		int variable = -1;

		for (int i = 0; i < favouriteSong.getFavouriteSong().size(); i++) {
			if (favouriteSong.getFavouriteSong().get(i) == songId) {
				variable = i;
				break;
			}
		}
		if (variable >= 0) {
			favouriteSong.getFavouriteSong().remove(variable);
		}

		return userFavouriteDao.save(favouriteSong);
	}
}
