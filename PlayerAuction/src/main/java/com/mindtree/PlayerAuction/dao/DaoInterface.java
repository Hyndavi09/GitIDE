package com.mindtree.PlayerAuction.dao;

import java.util.Set;

import com.mindtree.PlayerAuction.entity.Player;
import com.mindtree.PlayerAuction.exception.dao.DaoException;

public interface DaoInterface {
	public int addplayer(Player player) throws DaoException;

	public Set<String> displayplayer(String teamname) throws DaoException;
}
