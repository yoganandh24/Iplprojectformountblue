




package iplproject;
import java.io.*;
import java.util.*;



public class Iplprojectleague {

	public static void main(String[] args) {
		
		// requirements for 1 and 2 tasks...>>
		String matchCsvFile = "/home/yoganandh24/Desktop/iplproject/matches.csv";
		BufferedReader matchCol = null;
		String column ="";
		Map<String,Integer> noOfMatchesWonByATeam = new HashMap<>();
		Map<String,Integer> noOfMatchesPerYear = new HashMap<>();
		int skip = 0;
		//int ol=0;
		//requirements from 3rd 4th task...>>
		String deliveriesCsvFile ="/home/yoganandh24/Desktop/iplproject/deliveries.csv";
		BufferedReader deliveriesCol=null;
		List<Integer> matchIdsList = new ArrayList<>();
		String deliveriesline="";
		int skip2= 0;
		Map<String,Integer> noOfExtras2016= new HashMap<>();	
		
		//###
		//
		try 
		{
			//System.out.println("at1st step");
			matchCol = new BufferedReader(new FileReader(matchCsvFile));
			while((column = matchCol.readLine()) != null) {
				if (skip==0) {
					skip++;
					continue;
				}
				String[] row = column.split(",");
				
			//
				int length= (row.length);

//------------------////////////// for first two tasks/////////---------------->>>
				for (int i =0; i<length ; i++) {
					int x=i;
					
					
        //////////////////////////task-1--------------//>>
					if(i==1) {
						if(noOfMatchesPerYear.containsKey(row[i])) {
						
							noOfMatchesPerYear.put(row[i], noOfMatchesPerYear.get(row[i])+1);
						
						}
						else if (row[i] != "Season"){
					
							noOfMatchesPerYear.put(row[i], 1);
						}	;
					}
				
        ////////////////////////task-2-------------//>>
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
					};;;
			// ----------------------finished two tasks-----------------//
					
				}
///////////////////////////////////////For 3rd task----------->>
				
				String year=row[1];
				int i1 =Integer.parseInt(row[0]);
				
				if(year .equals("2016")) {
					//ol=ol+1;
					matchIdsList.add(i1);
					//System.out.println("60");
				}
				
			}
//task-3 and 4	
			
			//int w=0;
			
			deliveriesCol = new BufferedReader(new FileReader(deliveriesCsvFile));
			while((deliveriesline= deliveriesCol.readLine()) != null) {
				if (skip2==0) {
					skip2++;
					continue;
				}
				String[] row1 = deliveriesline.split(",");
				
				//int row1length = (row1.length);
				
				for (Integer matchId :matchIdsList ) {
					int index = Integer.parseInt(row1[0]);
					
					if( matchId == index ) {
						//w=w+1;
						//System.out.println(w);
						int extras =Integer.parseInt( row1[16]);
						if(extras >0 ) {
							if (noOfExtras2016.containsKey(row1[3])) {
								noOfExtras2016.put(row1[3], noOfExtras2016.get(row1[3])+extras);
								
							}
							else {
								noOfExtras2016.put(row1[3],extras);
							}
							
							
						}
					}
					
					
					
					
					
					
					
				}
				
				
				
			}//end of 2nd while
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
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
		//System.out.println(ol);
		//System.out.println(matchIdsList);
		//System.out.println(matchIdsList.get(1)+matchIdsList.get(2));
		
		////////
		System.out.println(noOfExtras2016);	
		
		
		
		
		
		
		
		
		
		
		
	}

}
