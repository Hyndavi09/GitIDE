package com.mindtree.PlayerAuction.client;

import java.sql.*;
import java.util.Scanner;

import com.mindtree.PlayerAuction.entity.Player;
import com.mindtree.PlayerAuction.entity.Team;
import com.mindtree.PlayerAuction.exception.custom.InvalidCategoryException;
import com.mindtree.PlayerAuction.exception.custom.NotABatsman;
import com.mindtree.PlayerAuction.exception.custom.NotABowlerException;
import com.mindtree.PlayerAuction.exception.service.ServiceException;
import com.mindtree.PlayerAuction.service.PlayerInterface;
import com.mindtree.PlayerAuction.service.Impl.PlayerImplementation;

public class TeamPlayerAuction {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		PlayerInterface players = new PlayerImplementation();
		do {
			Player player = new Player();
			System.out.println("1:Add Player\n2:Display players\n3:Exit");
			System.out.println("enter the choice");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				player = addplayers(player);
				try {
					int player_no = players.addplayer(player);
					System.out.println("Added succesfully with player no=" + player_no);
				} catch (ServiceException e) {
					e.printStackTrace();
				}

				break;
			case 2:

				try {
					System.out.println("Enter the team name");
					String teamname = scan.next();
					System.out.println(players.displayplayer(teamname));
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.exit(0);
			}
		} while (true);
	}

	private static Player addplayers(Player player) {

		System.out.println("Enter the name");
		player.setPlayerName(scan.next());
		try {
			System.out.println("enter the category");
			player.setCategory(scan.next());
			if (!(player.getCategory().equals("batsman") || player.getCategory().equals("bowler")
					|| player.getCategory().equals("allrounder")))
				throw new InvalidCategoryException();
		} catch (InvalidCategoryException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("enter the highest score");
			player.setHighestScore(scan.nextInt());
			if (player.getCategory().equals("batsman"))
				if (!(player.getHighestScore() >= 50 && player.getHighestScore() <= 200))
					throw new NotABatsman("Invalid Batsman please check input");
			if (player.getCategory().equals("bowler"))
				if (!(player.getHighestScore() > 0))
					throw new NotABowlerException("Invalid Bowler please check input");
		} catch (NotABatsman e1) {
			e1.printStackTrace();
		} catch (NotABowlerException e2) {
			e2.printStackTrace();
		}
		System.out.println("Enter the best figure");
		player.setBestFigure(scan.next());
		System.out.println("enter the team name");
		Team t = new Team();
		t.setTeam_name(scan.next());
		player.setT(t);
		return player;

	}

}
