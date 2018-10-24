//FILE : TrainStation.java
//PROG : Devon Kostos
//PURP : Class to allow operation of a
//metropolitan train station that serves
//to both hold and reduce a given number 
//of passengers waiting.

package edu.tridenttech.cpt187.kostos.program5;

public class TrainStation 
{
	private int passengersWaiting;
	
	public TrainStation(int passWait)
	{
		passengersWaiting = passWait;
	}//END constructor TrainStation
	
	public int getPassengersWaiting()
	{
		return passengersWaiting;
	}//END method getPassengersWaiting
	
	public void reduceNumberWaiting(int numBoarding)
	{
		passengersWaiting -= numBoarding;
	}//END method reduceNumberWaiting

}//END class TrainStation
