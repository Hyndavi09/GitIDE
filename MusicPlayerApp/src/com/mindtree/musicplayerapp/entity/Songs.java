package com.mindtree.musicplayerapp.entity;

public class Songs {
	private int songId;
	private String songName;
	private double rating;

	public Songs() {
		super();
	}

	public Songs(int songId, String songName, double rating) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.rating = rating;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Songs [songId=" + songId + ", songName=" + songName + ", rating=" + rating + "]";
	}

}
