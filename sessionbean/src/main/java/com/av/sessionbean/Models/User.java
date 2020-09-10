package com.av.sessionbean.Models;

public class User {
	
	private long id;
	private String nickname;
	private String name;
	private long rating;
	
	public User() {	}
	
	public User(String nickname, String name, long rating) {
		this.nickname = nickname;
		this.name = name;
		this.rating = rating;
	}
	
	public User(long id, String nickname, String name, long rating) {
		this.id = id;
		this.nickname = nickname;
		this.name = name;
		this.rating = rating;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getRating() {
		return rating;
	}
	public void setRating(long rating) {
		this.rating = rating;
	}
}