package com.capgemini.userfavouritesongservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.userfavouritesongservice.entity.UserFavouriteSong;

@Repository
public interface UserFavouriteSongDao extends MongoRepository<UserFavouriteSong, String> {

	public UserFavouriteSong findByuserEmail(String userEmail);
}
