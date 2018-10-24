//FILE : MainClass.java
//PROG : Devon Kostos
//PURP : A simulation of a metropolitan
//subway train using the class SubwayTrain
//and the class TrainStation.

package edu.tridenttech.cpt187.kostos.program5;

import java.util.Scanner;

public class MainClass 
{

	public static void main(String[] args) 
	{	
		Scanner input = new Scanner(System.in);
		
		final int MIN_VALUE = 0;
		int awayStation;
		int numHomeSta;
		int numDestSta;
		
		SubwayTrain intExpress = new SubwayTrain(100, 1, 30);
		
		//GREETING
		System.out.printf("Welcome to the Randint Express train simulator!\n\n");
		
		//INPUT awayStation
		System.out.printf("Please enter a destination station number to continue: ");
		awayStation = input.nextInt();
		
		while (awayStation > intExpress.getNumStations() || awayStation < intExpress.getHomeStation())
		{
			System.out.printf("Sorry, but the Randint Express cannot go there. Please try again: ");
			awayStation = input.nextInt();
			
			if (awayStation == intExpress.getHomeStation())
			{
				System.out.printf("The Randint Express is already stationed at Station #1. Please try again: ");
				awayStation = input.nextInt();
			}
		}
		
		//INPUT numHomeSta
		System.out.printf("\nPlease enter the number of Station #%d passengers travelling to Station #%d: ", 
				intExpress.getHomeStation(), awayStation);
		numHomeSta = input.nextInt();
		
		while (numHomeSta < MIN_VALUE)
		{
			System.out.printf("Sorry, but that is not a valid number. Please try again: ");
			numHomeSta = input.nextInt();
		}
		
		//INPUT numDestSta
		System.out.printf("\nPlease enter the number of Station #%d passengers travelling to Station #%d: ", 
				awayStation, intExpress.getHomeStation());
		numDestSta = input.nextInt();
		
		while (numDestSta < MIN_VALUE)
		{
			System.out.printf("Sorry, but that is not a valid number. Please try again: ");
			numDestSta = input.nextInt();
		}
			
		TrainStation trainHomeSta = new TrainStation(numHomeSta);
		TrainStation trainDestSta = new TrainStation(numDestSta);
		
		while (trainHomeSta.getPassengersWaiting() != MIN_VALUE || trainDestSta.getPassengersWaiting() != MIN_VALUE)
		{
			System.out.printf("\n\n>>>>>ALL ABOARD THE RANDINT EXPRESS!<<<<<\n");
			intExpress.loadFromStation(trainHomeSta);
			System.out.printf("\nThere are %d passengers waiting at Station #%d.\n", 
					trainHomeSta.getPassengersWaiting(), intExpress.getHomeStation());
			intExpress.moveToStation(awayStation);
			intExpress.unloadAll(intExpress.getPassOnBoard());
			
			System.out.printf("\n\n>>>>>ALL ABOARD THE RANDINT EXPRESS!<<<<<\n");
			intExpress.loadFromStation(trainDestSta);
			System.out.printf("\nThere are %d passengers waiting at Station #%d.\n", 
					trainDestSta.getPassengersWaiting(), intExpress.getDestStation());
			intExpress.moveToStation(intExpress.getHomeStation());
			intExpress.unloadAll(intExpress.getPassOnBoard());
		}
		
		//FAREWELL
		System.out.printf("\n\nThank you for using the Randint Express train simulator!");
		
		input.close();

	}//END method main

}//END MainClass
