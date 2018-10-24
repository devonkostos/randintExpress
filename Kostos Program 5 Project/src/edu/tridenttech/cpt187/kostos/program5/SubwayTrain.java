//FILE : SubwayTrain.java
//PROG : Devon Kostos
//PURP : Class to allow operation of a
//metropolitan subway train that services
//multiple stations along its route, loading
//and unloading either a random generated number
//or a number given from the class TrainStation
//of passengers.

package edu.tridenttech.cpt187.kostos.program5;

import java.util.Random;

public class SubwayTrain 
{
	private int maxCapacity;
	private int homeStation;
	private int numStations;
	private int currentStation;
	private int destStation;
	private int passOnBoard;
	private Random ranNumGenerator;
	
	public SubwayTrain(int maxPass, int startStation, int stationCount)
	{
		maxCapacity = maxPass;
		homeStation = startStation;
		numStations = stationCount;
		currentStation = homeStation;
		destStation = currentStation;
		passOnBoard = 0;
		ranNumGenerator = new Random();
	}
	
	public int getMaxCapacity()
	{
		return maxCapacity;
	}//END method getMaxCapacity
	
	public int getHomeStation()
	{
		return homeStation;
	}//END method getHomeStation
	
	public int getNumStations()
	{
		return numStations;
	}//END method getNumStations
	
	public int getCurrentStation()
	{
		return currentStation;
	}//END method getCurrentStation
	
	public int getDestStation()
	{
		return destStation;
	}//END method getDestStation
	
	public int getPassOnBoard()
	{
		return passOnBoard;
	}//END method getPassOnBoard
	
	public int genRandomNumber(int maxNum)
	{
		return ranNumGenerator.nextInt(maxNum + 1);
	}//END method genRandomNumber
	
	public void loadPass()
	{
		final int PASS_MAX = 350;
		int numSeatsOpen = maxCapacity - passOnBoard;
		int numWaiting = genRandomNumber(PASS_MAX);
		
		if (numWaiting + passOnBoard < maxCapacity)
		{
			System.out.printf("%d passengers are currently waiting to board the Randint Express.\n", numWaiting);
			passOnBoard += numWaiting;
			System.out.printf("%d passengers are now boarding the Randint Express.\n", numWaiting);
		}
		else
		{
			System.out.printf("%d passengers are currently waiting to board the Randint Express.\n", numWaiting);
			passOnBoard = maxCapacity;
			System.out.printf("ONLY %d passengers may board the Randint Express at this time.\n", numSeatsOpen);
		}
		
	}//END method loadPass
	
	public void unloadPass()
	{
		int numLeaving = genRandomNumber(passOnBoard);
	
		System.out.printf("%d passengers are currently waiting to depart the Randint Express.\n", numLeaving);
		passOnBoard -= numLeaving;
		System.out.printf("%d passengers are now departing the Randint Express.\n", numLeaving);
	}//END method unloadPass
	
	public void moveToStation(int nextStation)
	{
		if (currentStation == numStations)
		{
			System.out.printf("ATTENTION: This is your conductor speaking.\nThe Randint Express has a maximum capacity of %d passengers.\n"
					+ "There are currently %d passengers aboard the train.\n", maxCapacity, passOnBoard);
			System.out.printf("We are now leaving station #%d for station #%d.\nThank you for travelling Randint Express!\n\n", 
					currentStation, homeStation);
			System.out.printf("THE RANDINT EXPRESS HAS ARRIVED AT STATION #%d.\n", homeStation);
		}
		else
		{
			destStation = nextStation;
		}
		if (currentStation != numStations)
		{
			System.out.printf("ATTENTION: This is your conductor speaking.\nThe Randint Express has a maximum capacity of %d passengers.\n"
					+ "There are currently %d passengers aboard the train.\n", maxCapacity, passOnBoard);
			System.out.printf("We are now leaving station #%d for station #%d.\nThank you for travelling Randint Express!\n\n", 
					currentStation, nextStation);
			System.out.printf("THE RANDINT EXPRESS HAS ARRIVED AT STATION #%d.\n", destStation);			
		}
		
		currentStation = destStation;
		
	}//END method moveToStation
	
	public void loadFromStation(TrainStation station)
	{	
		if (station.getPassengersWaiting() > maxCapacity)
		{
			passOnBoard += maxCapacity;
			System.out.printf("\n%d passengers are now boarding the Randint Express.\n", maxCapacity);
			station.reduceNumberWaiting(maxCapacity);
		}
		else
		{
			passOnBoard += station.getPassengersWaiting();
			System.out.printf("\n%d passengers are now boarding the Randint Express.\n", passOnBoard);
			station.reduceNumberWaiting(passOnBoard);
		}
		
	}//END method loadFromStation
	
	public void unloadAll(int numDeparting)
	{
		System.out.printf("\n%d passengers are now departing the Randint Express.\n", numDeparting);
		passOnBoard = 0;
	}//END method unloadAll

}//END class SubwayTrain