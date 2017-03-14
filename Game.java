/***********************************************
 * Last Name: Loewen
 * First Name: Mark
 * Student ID: 10024804
 * Course: CPSC 233
 * Tutorial Section: T02
 * Assignment: 3
 *
 * Game driver implements classes and accepts user input.
 ***********************************************/

import java.util.Scanner;
import java.util.Random;


public class Game
{
	public static Long s;

	//Initiates game and starts receiving user input. Resets track condition every round.
    public static void main(String [] args)
    {
        s = Long.parseLong(args[0]);
        SUV car1 = new SUV('V', "SUV");
        Sports car2 = new Sports('P', "Sports");
        Track newTrack = new Track(car1, car2);
        newTrack.display();
       	for (int j = 0; j < ((Track.TRACK_SIZE)*2); j++)
       	{
       		for (int i = 0; i < (Track.MAX_CARS); i++)
       		{
        		newTrack.cars[i].displayOptions();
        		Scanner keyboard = new Scanner(System.in);
        		char input = keyboard.next().charAt(0);
        		newTrack.cars[i].processOption(input);
        		newTrack.setLocation(i);
        		newTrack.display();
        		System.out.println(newTrack.cars[i].toString());
        		newTrack.setTrackCondition();
        		if (newTrack.locations[i] >= (Track.TRACK_SIZE) - 1)
        		{
        			System.out.println(newTrack.cars[i] + " wins!");
        			System.exit(0);
        		}
        	}
        }
    }


        
        

}