package com.mindtree.musicplayerapp.service.impl;

import java.util.List;

import com.mindtree.musicplayerapp.dao.MusicPlayerDao;
import com.mindtree.musicplayerapp.dao.impl.MusicPlayerDaoImpl;
import com.mindtree.musicplayerapp.entity.Playlist;
import com.mindtree.musicplayerapp.entity.Songs;
import com.mindtree.musicplayerapp.exception.dao.DaoException;
import com.mindtree.musicplayerapp.exception.service.NoDupicateName;
import com.mindtree.musicplayerapp.exception.service.ServiceException;
import com.mindtree.musicplayerapp.service.MusicPlayerService;

public class MusicPlayerServiceImpl implements MusicPlayerService {
	MusicPlayerDao dao = new MusicPlayerDaoImpl();

	@Override
	public String addSongs(Songs song) throws ServiceException {
		boolean find;
		try {
			find = dao.noduplicateSong(song);

			if (find) {
				return dao.addSongs(song);
			} else {
				throw new NoDupicateName("No duplicate songs");
			}
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public String addPlaylist(Playlist playlist, int songId) throws ServiceException {
		boolean find;
		try {
			find = dao.noduplicatePlaylist(playlist);

			if (find) {
				return dao.addPlaylist(playlist, songId);
			} else {
				throw new NoDupicateName("No duplicate songs");
			}
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Songs> getAllSongs() throws ServiceException {
		try {
			return dao.getAllSongs();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	@Override
	public List<Playlist> getAllPlaylist() throws ServiceException {
		try {
			return dao.getAllPlaylist();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Playlist> sort() {
		return dao.sort();
	}

}
