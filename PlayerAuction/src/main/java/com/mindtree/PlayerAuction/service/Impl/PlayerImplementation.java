package com.mindtree.PlayerAuction.service.Impl;

import java.util.HashSet;
import java.util.Set;

import com.mindtree.PlayerAuction.dao.DaoInterface;
import com.mindtree.PlayerAuction.dao.impl.DaoImplementation;
import com.mindtree.PlayerAuction.entity.Player;
import com.mindtree.PlayerAuction.exception.dao.DaoException;
import com.mindtree.PlayerAuction.exception.service.ServiceException;
import com.mindtree.PlayerAuction.service.PlayerInterface;

public class PlayerImplementation implements PlayerInterface {
	DaoInterface dao = new DaoImplementation();
	// Set<String> set = new HashSet<String>();
@Override
	public int addplayer(Player player) throws ServiceException {
		try {
			return dao.addplayer(player);
		} catch (DaoException e) {
			throw new ServiceException("Some error in dao implementation", e);
		}

	}
@Override
	public Set<String> displayplayer(String teamname) throws ServiceException {
		Set<String> set = new HashSet<String>();
		try {
			set = dao.displayplayer(teamname);
		} catch (DaoException e) {
			throw new ServiceException("Some error in dao implementation");
		}
		return set;

	}

}
