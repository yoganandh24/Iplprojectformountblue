package com.ipldata;

import java.io.*;
import java.security.KeyStore.Entry;
import java.util.*;

public class Main {
	public static final int MATCH_ID = 0;
	public static final int MATCH_SEASON = 1;
	public static final int MATCH_TEAM_1 = 4;
	public static final int MATCH_TEAM_2 = 5;
	public static final int MATCH_WINNER = 10;

	public static final int DELIVERIES_MATCH_ID = 0;
	public static final int DELIVERIES_BATTING_TEAM = 2;
	public static final int DELIVERIES_BOWLING_TEAM = 3;
	public static final int DELIVERIES_EXTRA_RUNS = 16;
	public static final int DELIVERIES_WIDE_RUNS = 10;
	public static final int DELIVERIES_NO_BALLS = 13;
	public static final int DELIVERIES_TOTAL_RUNS = 17;
	public static final int DELIVERIES_BYES_RUNS = 11;
	public static final int DELIVERIES_LEG_BYES_RUNS = 12;
	public static final int DELIVERIES_PENALTY_RUNS = 14;
	public static final int DELIVERIES_BOWLER_NAME = 8;
	public static final int DELIVERIES_BATSMAN_NAME = 6;
	public static final int DELIVERIES_BATSMAN_RUNS = 15;

	public static void main(String[] args) {

		List<Matches> matches = getMatchesData();
		List<Deliveries> deliveriesData = getDeliveriesData();

		getTotalNumberOfMatchesPlayedPerYear(matches);
		getTotalMatchesWonPerTeam(matches);
		getExtraRunsConcededPerTeamIn2016(matches, deliveriesData);
		getEconomicalBowlerof2015(matches, deliveriesData);
		getToatalRunsScoredByEveryPlayer(deliveriesData);
		
	}

	public static List<Matches> getMatchesData() {

		List<Matches> matchData = new ArrayList<Matches>();

		String csvMatchesFile = "/home/yoganandh24/Desktop/iplalldata/ipldatastorage/matches.csv";

		BufferedReader matchCol = null;
		String line = "";
		int skip = 1;
		
		try {
			matchCol = new BufferedReader(new FileReader(csvMatchesFile));
			while ((line = matchCol.readLine()) != null) {
				if (skip == 1) {
					skip++;
					continue;
				}
				String[] data = line.split(",");
				Matches match = new Matches();

				int matchId = Integer.parseInt(data[MATCH_ID]);
				int season = Integer.parseInt(data[MATCH_SEASON]);

				match.setMatchId(matchId);
				match.setSeason(season);
				match.setTeam1(data[MATCH_TEAM_1]);
				match.setTeam2(data[MATCH_TEAM_2]);
				match.setWinner(data[MATCH_WINNER]);

				matchData.add(match);
			}

		} 
		
		catch (Exception e) {
			e.printStackTrace();
		} 
		
		finally {
			if (matchCol != null) {
				try {
					matchCol.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return matchData;
	}

	public static List<Deliveries> getDeliveriesData() {

		List<Deliveries> deliveriesData = new ArrayList<Deliveries>();
		String csvDeliveriesFile = "/home/yoganandh24/Desktop/iplalldata/ipldatastorage/deliveries.csv";
		BufferedReader matchCol = null;
		String line = "";
		int skip = 1;

		try {
			matchCol = new BufferedReader(new FileReader(csvDeliveriesFile));
			while ((line = matchCol.readLine()) != null) {
				if (skip == 1) {
					skip++;
					continue;
				}

				String[] data = line.split(",");
				Deliveries deliveries = new Deliveries();

				int matchId = Integer.parseInt(data[DELIVERIES_MATCH_ID]);
				int extraRuns = Integer.parseInt(data[DELIVERIES_EXTRA_RUNS]);
				int wideRuns = Integer.parseInt(data[DELIVERIES_WIDE_RUNS]);
				int noballs = Integer.parseInt(data[DELIVERIES_NO_BALLS]);
				int total = Integer.parseInt(data[DELIVERIES_TOTAL_RUNS]);
				int byes = Integer.parseInt(data[DELIVERIES_BYES_RUNS]);
				int legByes = Integer.parseInt(data[DELIVERIES_LEG_BYES_RUNS]);
				int penalty = Integer.parseInt(data[DELIVERIES_PENALTY_RUNS]);
				int batsManRuns = Integer.parseInt(data[DELIVERIES_BATSMAN_RUNS]);

				deliveries.setMatchId(matchId);
				deliveries.setBattingTeam(data[DELIVERIES_BATTING_TEAM]);
				deliveries.setBowlingTeam(data[DELIVERIES_BOWLING_TEAM]);
				deliveries.setExtraRuns(extraRuns);
				deliveries.setWideRuns(wideRuns);
				deliveries.setNoBallRuns(noballs);
				deliveries.setTotalRuns(total);
				deliveries.setByeRuns(byes);
				deliveries.setLegByeRuns(legByes);
				deliveries.setPenaltyRuns(penalty);
				deliveries.setBowlerName(data[DELIVERIES_BOWLER_NAME]);
				deliveries.setBatsmanRuns(batsManRuns);
				deliveries.setBatsmanName(data[DELIVERIES_BATSMAN_NAME]);

				deliveriesData.add(deliveries);
			}

		}

		catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			if (matchCol != null) {
				try {
					matchCol.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return deliveriesData;
	}

	public static void getTotalNumberOfMatchesPlayedPerYear(List<Matches> matches) {

		Map<Integer, Integer> totalMatchesAndYears = new HashMap<Integer, Integer>();
		System.out.println("PROBLEM - 1");
		System.out.println("Number of matches played per year in IPL");

		for (Matches match : matches) {
			int season = match.getSeason();
			if (totalMatchesAndYears.containsKey(season)) {
				totalMatchesAndYears.put(season, totalMatchesAndYears.get(season) + 1);
			} else {
				totalMatchesAndYears.put(season, 1);
			}
		}

		totalMatchesAndYears.forEach((year, noOfMatches) -> {
			System.out.println(year + " : " + noOfMatches);
		});

		System.out.println();
	}

	public static void getTotalMatchesWonPerTeam(List<Matches> matches) {
		
		Map<String, Integer> totalMatchesAndWins = new HashMap<String, Integer>();
				
		for (Matches match : matches) {			
			String team1 = match.getTeam1();
			String team2 = match.getTeam2();
			String winner = match.getwinner();			
			if (totalMatchesAndWins.containsKey(winner)) {
				totalMatchesAndWins.put(winner, totalMatchesAndWins.get(winner) + 1);
			} else {
				totalMatchesAndWins.put(winner, 1);
			}			
		}
		
		System.out.println("PROBLEM - 2");
		System.out.println("Number of matches won of all teams over all the years of IPL");
		
		totalMatchesAndWins.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		
		System.out.println();
	}

	public static void getExtraRunsConcededPerTeamIn2016(List<Matches> matches, List<Deliveries> deliveriesData) {
		
		Map<String, Integer> extraRunsConcededPerTeam2016 = new HashMap<String, Integer>();
		List<Integer> matchIdList2016 = new ArrayList<>();
		
		for (Matches match : matches) {
			int matchIds = match.getMatchId();
			int season = match.getSeason();
			if (season == 2016) {
				matchIdList2016.add(matchIds);
			}
		}
		
		for (Deliveries deliveries : deliveriesData) {
			int deliveriesMatchId = deliveries.getMatchId();
			for (Integer matchId : matchIdList2016) {
				if (deliveriesMatchId == matchId) {
					int extras = deliveries.getExtraRuns();
					String team = deliveries.getBowlingTeam();
					if (extras > 0) {
						if (extraRunsConcededPerTeam2016.containsKey(team)) {
							extraRunsConcededPerTeam2016.put(team, extraRunsConcededPerTeam2016.get(team) + extras);
						} else {
							extraRunsConcededPerTeam2016.put(team, extras);
						}
					}
				}
			}
		}
		
		System.out.println("PROBLEM - 3");
		System.out.println("Extra runs conceded per team For the yeat 2016");
		
		extraRunsConcededPerTeam2016.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		
		System.out.println();
	}

	public static void getEconomicalBowlerof2015(List<Matches> matches, List<Deliveries> deliveriesData) {
		Map<String, Double> mostEconomicalBowler2015 = new HashMap<String, Double>();
		Map<String, Integer> totalBallsByBowler = new HashMap<String, Integer>();
		Map<String, Integer> totalRunsConceded = new HashMap<String, Integer>();
		List<Integer> matchIdList2015 = new ArrayList<>();
		Map<String, Double> bowlersOvers = new HashMap<String, Double>();
		for (Matches match : matches) {
			int matchIds = match.getMatchId();
			int season = match.getSeason();
			if (season == 2015) {
				matchIdList2015.add(matchIds);
			}
		}
		for (Deliveries deliveries : deliveriesData) {

			int deliveriesMatchId = deliveries.getMatchId();

			for (Integer matchId : matchIdList2015) {
				int wides = deliveries.getWideRuns();
				int noBalls = deliveries.getNoballRuns();
				int totalRuns = deliveries.getTotalRuns();
				int legByes = deliveries.getLegByeRuns();
				int byes = deliveries.getByesRuns();
				int penaltyRuns = deliveries.getPenaltyRuns();
				String bowlerName = deliveries.getBowlerName();
				int balls = 0;
				int runs = 0;

				if (deliveriesMatchId == matchId) {
					if ((wides == 0) && (noBalls == 0)) {
						balls = 1;
					}
					if ((totalRuns != 0) && (byes == 0) && (legByes == 0) && (penaltyRuns == 0)) {
						runs = totalRuns;
					}

					if (totalBallsByBowler.containsKey(bowlerName)) {
						totalBallsByBowler.put(bowlerName, totalBallsByBowler.get(bowlerName) + balls);
					} else {
						totalBallsByBowler.put(bowlerName, balls);
					}
					if (totalRunsConceded.containsKey(bowlerName)) {
						totalRunsConceded.put(bowlerName, totalRunsConceded.get(bowlerName) + runs);
					} else {
						totalRunsConceded.put(bowlerName, runs);
					}
				}
			}

		}
		for (String bowler : totalBallsByBowler.keySet()) {
			int totalBalls = totalBallsByBowler.get(bowler);
			if (totalBalls >= 6) {

				bowlersOvers.put(bowler, (double) (totalBallsByBowler.get(bowler) / 6));
			}
		}
		double economy;
		for (String bowler : bowlersOvers.keySet()) {
			economy = totalRunsConceded.get(bowler) / bowlersOvers.get(bowler);
			mostEconomicalBowler2015.put(bowler, economy);
		}

		List<Map.Entry<String, Double>> sortingMostEconomicalBowler2015 = new LinkedList<Map.Entry<String, Double>>(mostEconomicalBowler2015.entrySet());
		
		Collections.sort(sortingMostEconomicalBowler2015, new Comparator<Map.Entry<String, Double>>() {
			@Override
			public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		System.out.println();
		System.out.println("PROBLEM - 4");
		System.out.println("Economy of bowlers in year 2015");
		System.out.println(sortingMostEconomicalBowler2015.get(0));
		
	}

	
	public static void getToatalRunsScoredByEveryPlayer(List<Deliveries> deliveriesData) {
		
		Map<String, Integer> runsByEveryPlayer = new HashMap<String, Integer>();

		for (Deliveries deliveries : deliveriesData) {
			String batsmanName = deliveries.getBatsmanName();
			int runs = deliveries.getbatsmanRuns();
			if (runsByEveryPlayer.containsKey(batsmanName)) {
				runsByEveryPlayer.put(batsmanName, runsByEveryPlayer.get(batsmanName) + runs);
			} else {
				runsByEveryPlayer.put(batsmanName, runs);
			}
		}
		
		System.out.println();
		System.out.println("PROBLEM - 5");
		System.out.println("players total score over all the ipl seasons");
		
		runsByEveryPlayer.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		
		System.out.println();		
	}

}
	
		

	
		
		


