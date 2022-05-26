package com.ipldata;

public class Delivery {
	private int matchId;
	private int innings;
	private String battingTeam;
	private String bowlingTeam;
	private int over;
	private int ball;
	private String batsmanName;
	private String nonStriker;
	private String bowlerName;
	private int isSuperOver;
	private int wideRuns;
	private int byeRuns;
	private int legByeRuns;
	private int noballRuns;
	private int penaltyRuns;
	private int batsmanRuns;
	private int extraRuns;
	private int totalRuns;
	private String playerDismissed;
	private String dismissalKind;
	private String fielder;
	
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getInnings() {
		return innings;
	}
	public void setInnings(int innings) {
		this.innings = innings;
	}
	public String getBattingTeam() {
		return battingTeam;
	}
	public void setBattingTeam(String battingTeam) {
		this.battingTeam = battingTeam;
	}
	public String getBowlingTeam() {
		return bowlingTeam;
	}
	public void setBowlingTeam(String bowlingTeam) {
		this.bowlingTeam = bowlingTeam;	
	}
	public int getExtraRuns() {
		return extraRuns;
	}
	public void setExtraRuns(int extraRuns) {
		this.extraRuns = extraRuns;
	}
	public int getWideRuns() {
		return wideRuns;
	}
	public void setWideRuns(int wideRuns) {
		this.wideRuns = wideRuns;
	}
	public int getNoballRuns() {
		return noballRuns;
	}
	public void setNoBallRuns(int noballRuns) {
		this.noballRuns = noballRuns;
	}
	public int getTotalRuns() {
		return totalRuns;
	}
	public void setTotalRuns(int totalRuns) {
		this.totalRuns=totalRuns;
	}
	public int getByesRuns() {
		return byeRuns;
	}
	public void setByeRuns(int byeRuns) {
		this.byeRuns=byeRuns;
	}
	public int getLegByeRuns() {
		return legByeRuns;
	}
	public void setLegByeRuns(int legByeRuns ) {
		this.legByeRuns=legByeRuns;
	}
	public int getPenaltyRuns() {
		return penaltyRuns;
	}
	public void setPenaltyRuns(int penaltyRuns ) {
		this.penaltyRuns=penaltyRuns;
	}
	public String getBowlerName() {
		return bowlerName;
	}
	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}
	public String getBatsmanName() {
		return batsmanName;
	}
	public void setBatsmanName(String batsmanName) {
		this.batsmanName = batsmanName;
	}
	public int getbatsmanRuns() {
		return batsmanRuns;
	}
	public void setBatsmanRuns(int batsmanRuns) {
		this.batsmanRuns = batsmanRuns;
	}
}

