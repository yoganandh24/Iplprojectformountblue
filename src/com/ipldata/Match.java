package com.ipldata;

public class Match {
	
	private int matchId;
	private int season;
	private String team1;
	private String team2;
	private String winner;
	
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1=team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2=team2;
	}
	public String getwinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner=winner;
	}
}
