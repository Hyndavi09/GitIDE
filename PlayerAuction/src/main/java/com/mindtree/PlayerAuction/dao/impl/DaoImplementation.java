package com.mindtree.PlayerAuction.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.mindtree.PlayerAuction.dao.DaoInterface;
import com.mindtree.PlayerAuction.entity.Player;
import com.mindtree.PlayerAuction.exception.custom.DuplicateEntryException;
import com.mindtree.PlayerAuction.exception.custom.InvalidTeamNameException;
import com.mindtree.PlayerAuction.exception.dao.DaoException;
import com.mindtree.PlayerAuction.util.DaoUtil;

public class DaoImplementation implements DaoInterface {
	Connection con;
	DaoUtil dao = new DaoUtil();

	public int addplayer(Player player) throws DaoException {
		con = dao.getConnection();
		int player_id, team_id;
		try {
			PreparedStatement preparedstatement0 = con.prepareStatement(
					"select player.player_no,player_name,category from player join team_player on player.player_no=team_player.player_no join team on team_player.team_no=team.team_id where team_name=? and player_name=? and category=?;");
			preparedstatement0.setString(1, player.getPlayerName());
			preparedstatement0.setString(2, player.getCategory());
			preparedstatement0.setString(3, player.getT().getTeam_name());
			ResultSet rs = preparedstatement0.executeQuery();
			try {
				if (rs.next())
					throw new DuplicateEntryException("Player details already exists");
			} catch (DuplicateEntryException e) {
				throw new DaoException("Exception from sql");
			}

		} catch (SQLException e) {
			throw new DaoException("Exception from sql", e);
		}
		try {
			PreparedStatement preparedstatement = con.prepareStatement(
					"Insert into player(player_name,category,highest_score,best_figure) values(?,?,?,?)");
			// preparedstatement.setInt(1, player.getPlayer_no());
			preparedstatement.setString(1, player.getPlayerName());
			preparedstatement.setString(2, player.getCategory());
			preparedstatement.setInt(3, player.getHighestScore());
			preparedstatement.setString(4, player.getBestFigure());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Exception from sql", e);
		}

		PreparedStatement preparedstatement1;
		try {
			preparedstatement1 = con.prepareStatement("Select team_id from team where team_name=? ");
			preparedstatement1.setString(1, player.getT().getTeam_name());
			ResultSet rs = preparedstatement1.executeQuery();
			if (!rs.next())
				try {
					throw new InvalidTeamNameException();
				} catch (InvalidTeamNameException e) {
					throw new DaoException("Player details already exist", e);
				}
			// rs.next();
			team_id = rs.getInt(1);
		} catch (SQLException e1) {
			throw new DaoException("Exception from sql", e1);
		}

		try {
			PreparedStatement preparedstatement2 = con
					.prepareStatement("Select player_no from player where player_name=? ");
			preparedstatement2.setString(1, player.getPlayerName());
			ResultSet rs1 = preparedstatement2.executeQuery();
			rs1.next();
			player_id = rs1.getInt(1);
		} catch (SQLException e2) {
			throw new DaoException("Exception from sql", e2);
		}
		try {
			PreparedStatement preparedstatement3 = con.prepareStatement("insert into team_player values(?,?)");
			preparedstatement3.setInt(1, player_id);
			preparedstatement3.setInt(2, team_id);
			preparedstatement3.executeUpdate();
			con.close();
			return player_id;

		} catch (SQLException e3) {
			throw new DaoException("Exception from sql", e3);

		}
	}

	public Set<String> displayplayer(String teamname) throws DaoException {
		Set<String> set = new HashSet<String>();
		con = dao.getConnection();
		PreparedStatement preparedstatement1;
		try {
			preparedstatement1 = con.prepareStatement("Select team_id from team where team_name=? ");
			preparedstatement1.setString(1, teamname);
			ResultSet rs = preparedstatement1.executeQuery();
			if (!rs.next())
				try {
					throw new InvalidTeamNameException();
				} catch (InvalidTeamNameException e) {
					throw new DaoException("Player check", e);
				}
			// rs.next();

		} catch (SQLException e1) {
			throw new DaoException("Exception from sql", e1);
		}

		try {

			PreparedStatement preparedstatement3 = con.prepareStatement(
					"select player_name,category from player  join team_player on player.player_no=team_player.player_no join team on team.team_id=team_player.team_no where team_name=? order by player_name");
			preparedstatement3.setString(1, teamname);
			ResultSet rs = preparedstatement3.executeQuery();
			while (rs.next()) {
				set.add("" + rs.getString(1) + "   " + rs.getString(2) + "");
			}
			con.close();
		} catch (SQLException e3) {
			throw new DaoException("Exception from sql", e3);
		}
		return set;
	}

}
