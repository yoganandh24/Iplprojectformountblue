




package iplproject;
import java.io.*;
import java.util.*;



public class Iplprojectleague {

	public static void main(String[] args) {
		
		String matchcsvFile = "/home/yoganandh24/Desktop/iplproject/matches.csv";
		
		
		BufferedReader matchCol = null;
	
		String column ="";
		
		// System.out.println(totalTeams);
		Map<String,Integer> noOfMatchesWonByATeam = new HashMap<>();
		
		Map<String,Integer> noOfMatchesPerYear = new HashMap<>();
		try 
		{
			//System.out.println("at1st step");
			matchCol = new BufferedReader(new FileReader(matchcsvFile));
			while((column = matchCol.readLine()) != null) {

				String[] row = column.split(",");
				
			//
				int length= (row.length);
				
			//
				for (int i =0; i<length ; i++) {
					int x=i;
					
					if(i==1) {
						if(noOfMatchesPerYear.containsKey(row[i])) {
						
							noOfMatchesPerYear.put(row[i], noOfMatchesPerYear.get(row[i])+1);
						
						}
						else if (row[i] != "Season"){
					
							noOfMatchesPerYear.put(row[i], 1);
						}	;
					}
				
				//
				//
					if((x ==4 ) || (x == 5)) {
						
						if (noOfMatchesWonByATeam.containsKey(row[x])) {
							
						}
						else if((row[i] != "team1") && (row[i]!="team2")) {
							
								
							noOfMatchesWonByATeam.put(row[i],0);
								
						};
					
					}	
					if (x == 10) {
						
						if(noOfMatchesWonByATeam.containsKey(row[i])) {
							noOfMatchesWonByATeam.put(row[i], noOfMatchesWonByATeam.get(row[i])+1);
						}
					}
					
					
						
				
					
				 
				//
				
 			}
			}
			}
		catch(Exception E) {
			E.printStackTrace();
		}
		finally {
			try {
				matchCol.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
		}
		
		
		System.out.println(noOfMatchesPerYear);
		
		// second task
		System.out.println(noOfMatchesWonByATeam);
		
		
	}

}
