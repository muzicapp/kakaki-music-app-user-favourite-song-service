package com.capgemini.userfavouritesongservice.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_favourite")
public class UserFavouriteSong {

	@Id
	private String userEmail;
	private List<Integer> favouriteSong=new ArrayList<Integer>();

	public UserFavouriteSong() {
		super();
	}

	public UserFavouriteSong(String userEmail, List<Integer> favouriteSong) {
		super();
		this.userEmail = userEmail;
		this.favouriteSong = favouriteSong;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public List<Integer> getFavouriteSong() {
		return favouriteSong;
	}

	public void setFavouriteSong(List<Integer> favouriteSong) {
		this.favouriteSong = favouriteSong;
	}

}
