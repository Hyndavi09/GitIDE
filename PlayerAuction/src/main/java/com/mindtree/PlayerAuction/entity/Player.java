package com.mindtree.PlayerAuction.entity;

public class Player {
	private int player_no;
	private String playerName;
	private String category;
	private int highestScore;
	private String bestFigure;
	private Team t;

	public Player() {
		super();
	}

	public Player(int player_no, String playerName, String category, int highestScore, String bestFigure, Team t) {
		super();
		this.player_no = player_no;
		this.playerName = playerName;
		this.category = category;
		this.highestScore = highestScore;
		this.bestFigure = bestFigure;
		this.t = t;
	}

	public Team getT() {
		return t;
	}

	public void setT(Team t) {
		this.t = t;
	}

	public int getPlayer_no() {
		return player_no;
	}

	public void setPlayer_no(int player_no) {
		this.player_no = player_no;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}

	public String getBestFigure() {
		return bestFigure;
	}

	public void setBestFigure(String bestFigure) {
		this.bestFigure = bestFigure;
	}

	@Override
	public String toString() {
		return "Player [player_no=" + player_no + ", playerName=" + playerName + ", category=" + category
				+ ", highestScore=" + highestScore + ", bestFigure=" + bestFigure + ", t=" + t + "]";
	}
}
