package com.mindtree.musicplayerapp.dao;

import java.util.List;

import com.mindtree.musicplayerapp.entity.Playlist;
import com.mindtree.musicplayerapp.entity.Songs;
import com.mindtree.musicplayerapp.exception.dao.DaoException;
/**
 * @author M1056008
 *
 */
public interface MusicPlayerDao {
	/**
	 * @param song
	 * @return added successfully
	 * @throws DaoException
	 */
	public String addSongs(Songs song) throws DaoException;

	/**
	 * @param playlist
	 * @param songId
	 * @return added successfully
	 * @throws DaoException
	 */
	public String addPlaylist(Playlist playlist, int songId) throws DaoException;

	/**
	 * @return list
	 * @throws DaoException
	 */
	public List<Songs> getAllSongs() throws DaoException;

	/**
	 * @return list of playlist
	 * @throws DaoException
	 */
	public List<Playlist> getAllPlaylist() throws DaoException;

	/**
	 * @return sort list
	 */
	public List<Playlist> sort();

	/**
	 * @param playlist
	 * @return boolean value
	 * @throws DaoException
	 */
	public boolean noduplicatePlaylist(Playlist playlist) throws DaoException;

	/**
	 * @param song
	 * @return boolean value
	 * @throws DaoException
	 */
	public boolean noduplicateSong(Songs song) throws DaoException;
}
