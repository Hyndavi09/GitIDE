package com.mindtree.musicplayerapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mindtree.musicplayerapp.dao.MusicPlayerDao;
import com.mindtree.musicplayerapp.entity.Playlist;
import com.mindtree.musicplayerapp.entity.Songs;
import com.mindtree.musicplayerapp.exception.dao.DaoException;
import com.mindtree.musicplayerapp.exception.db.DbConnection;
import com.mindtree.musicplayerapp.utility.DbUtility;

public class MusicPlayerDaoImpl implements MusicPlayerDao {
	DbUtility daoUtility = new DbUtility();
	List<Songs> list = new ArrayList<Songs>();
	List<Playlist> list2 = new ArrayList<Playlist>();

	@Override
	public String addSongs(Songs song) throws DaoException {
		String query = "insert into songs values(?,?,?)";
		try (Connection con = daoUtility.getConnection();
				PreparedStatement preparedstatement = con.prepareStatement(query)) {
			preparedstatement.setInt(1, song.getSongId());
			preparedstatement.setString(2, song.getSongName());
			preparedstatement.setDouble(3, song.getRating());
			preparedstatement.executeUpdate();
		} catch (SQLException | DbConnection e) {
			throw new DaoException(e.getMessage(), e);
		}
		return "Added Succesfully";
	}

	@Override
	public String addPlaylist(Playlist playlist, int songId) throws DaoException {
		String query = "insert into playlist values(?,?,?)";
		try (Connection con = daoUtility.getConnection();
				PreparedStatement preparedstatement = con.prepareStatement(query)) {
			preparedstatement.setInt(1, playlist.getPlaylistId());
			preparedstatement.setString(2, playlist.getPlaylistName());
			preparedstatement.setDouble(3, songId);
			preparedstatement.executeUpdate();
		} catch (SQLException | DbConnection e) {
			throw new DaoException(e.getMessage(), e);
		}
		return "Added Succesfully";
	}

	@Override
	public List<Songs> getAllSongs() throws DaoException {
		String query = "select * from songs";
		try (Connection con = daoUtility.getConnection();
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(query)) {
			while (rs.next()) {
				Songs songs = new Songs();
				songs.setSongId(rs.getInt(1));
				songs.setSongName(rs.getString(2));
				songs.setRating(rs.getInt(3));
				list.add(songs);

			}
		} catch (SQLException | DbConnection e) {
			throw new DaoException(e.getMessage(), e);
		}
		return list;

	}

	@Override
	public List<Playlist> getAllPlaylist() throws DaoException {
		String query = "select * from playlist";
		try (Connection con = daoUtility.getConnection();
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(query)) {
			while (rs.next()) {
				Playlist playlist = new Playlist();
				playlist.setPlaylistId((rs.getInt(1)));
				playlist.setPlaylistName(rs.getString(2));
				Songs songs = new Songs();
				songs.setSongId(rs.getInt(3));
				playlist.setSong(songs);
				list2.add(playlist);

			}
		} catch (SQLException | DbConnection e) {
			throw new DaoException(e.getMessage(), e);
		}
		return list2;
	}

	@Override
	public List<Playlist> sort() {
		Collections.sort(list2);
		return list2;
	}

	public boolean noduplicatePlaylist(Playlist playlist) throws DaoException {
		String query = "select playlistName from playlist where name=?";
		try (Connection con = daoUtility.getConnection();
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(query)) {
			if (rs.next()) {
				return false;

			}
		} catch (SQLException | DbConnection e) {
			throw new DaoException(e.getMessage(), e);
		}
		return true;

	}

	public boolean noduplicateSong(Songs song) throws DaoException {
		String query = "select songName from songs where name=?";
		try (Connection con = daoUtility.getConnection();
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(query)) {
			if (rs.next()) {
				return false;

			}
		} catch (SQLException | DbConnection e) {
			throw new DaoException(e.getMessage(), e);
		}
		return true;

	}

}
