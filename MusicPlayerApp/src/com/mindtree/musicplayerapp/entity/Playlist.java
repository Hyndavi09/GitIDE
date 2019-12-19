package com.mindtree.musicplayerapp.entity;

public class Playlist implements Comparable<Playlist>{
	private int playlistId;
	private String playlistName;
	private Songs song;

	public Playlist() {
		super();
	}

	public Playlist(int playlistId, String playlistName, Songs song) {
		super();
		this.playlistId = playlistId;
		this.playlistName = playlistName;
		this.song = song;
	}

	public int getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public Songs getSong() {
		return song;
	}

	public void setSong(Songs song) {
		this.song = song;
	}

	@Override
	public String toString() {
		return "Playlist [playlistId=" + playlistId + ", playlistName=" + playlistName + ", song=" + song + "]";
	}

	@Override
	public int compareTo(Playlist arg0) {
		// TODO Auto-generated method stub
		return this.playlistName.compareTo(arg0.playlistName);
	}

}
