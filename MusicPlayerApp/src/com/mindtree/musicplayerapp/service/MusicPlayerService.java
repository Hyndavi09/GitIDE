package com.mindtree.musicplayerapp.service;

import java.util.List;

import com.mindtree.musicplayerapp.entity.Playlist;
import com.mindtree.musicplayerapp.entity.Songs;
import com.mindtree.musicplayerapp.exception.service.ServiceException;

public interface MusicPlayerService {

	/**
	 * @param song
	 * @return added succesfully
	 * @throws ServiceException
	 */
	public String addSongs(Songs song) throws ServiceException;

	/**
	 * @param playlist
	 * @param songId
	 * @return added succesfully
	 * @throws ServiceException
	 */
	public String addPlaylist(Playlist playlist, int songId) throws ServiceException;

	/**
	 * @return list of songs
	 * @throws ServiceException
	 */
	public List<Songs> getAllSongs() throws ServiceException;

	/**
	 * @return list of playlist
	 * @throws ServiceException
	 */
	public List<Playlist> getAllPlaylist() throws ServiceException;

	/**
	 * @return sorted lis
	 */
	public List<Playlist> sort();
}
