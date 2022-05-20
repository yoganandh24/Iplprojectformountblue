




package iplproject;
import java.io.*;
import java.util.*;



public class Iplprojectleague {

	public static void main(String[] args) {
		
		String matchcsvFile = "/home/yoganandh24/Desktop/iplproject/matches.csv";
		
		
		BufferedReader matchCol = null;
	
		String column ="";
		Map<String,Integer> noOfMatchesPerYear = new HashMap<>();
		try 
		{
			//System.out.println("at1st step");
			matchCol = new BufferedReader(new FileReader(matchcsvFile));
			while((column = matchCol.readLine()) != null) {

				String[] row = column.split(",");
				
			
				
	
				
				if(noOfMatchesPerYear.containsKey(row[1])) {
					
						noOfMatchesPerYear.put(row[1], noOfMatchesPerYear.get(row[1])+1);

						
					}
				else if(row[1] != "Season") {
					
						noOfMatchesPerYear.put(row[1], 1);
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
		
		
		
	}

}
