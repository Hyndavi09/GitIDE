package com.mindtree.PlayerAuction.service;

import java.util.Set;

import com.mindtree.PlayerAuction.entity.Player;
import com.mindtree.PlayerAuction.exception.service.ServiceException;

public interface PlayerInterface {
	public int addplayer(Player player) throws ServiceException;

	public Set<String> displayplayer(String teamname) throws ServiceException;
}
