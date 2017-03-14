/***********************************************
 * Last Name: Loewen
 * First Name: Mark
 * Student ID: 10024804
 * Course: CPSC 233
 * Tutorial Section: T02
 * Assignment: 3
 *
 * Track class displays the track and updates
 * based on cars movement/user input.
 ***********************************************/

import java.util.Random;

public class Track
{
    public static final int TRACK_SIZE = 25;
    public static final int MAX_CARS = 2;
    public static enum TrackCondition {HEATWAVE, BLIZZARD, NORMAL};
    
    public Car[] cars;
    public int[] locations;
    public static TrackCondition condition;
    private boolean finished;

    /** Create the track and place the car at the beginning of a track to start the race.
     * @param aCar The car to be placed.
     */
    public Track(Car aCar, Car bCar)
    {
        cars = new Car[MAX_CARS];
        locations = new int[MAX_CARS];
        cars[0] = aCar;
        cars[1] = bCar;
        for (int i = 0; i < MAX_CARS; i++)
        {
            locations[i] = 0;
        }
        setTrackCondition();
        finished = false;
    }

    //Default constructor
    public Track()
    {
        cars = new Car[MAX_CARS];
        locations = new int[MAX_CARS];
        for (int i = 0; i < MAX_CARS; i++)
        {
            cars[i] = null;
            locations[i] = -1;
        }
        condition = TrackCondition.NORMAL;
        finished = false;
    }

    //Sets the track condition.
    public void setTrackCondition()
    {
        Random randomNumber = new Random(Game.s);
        int randomNum = randomNumber.nextInt(3);
        if (randomNum == 0)
            {condition = TrackCondition.BLIZZARD;}
        else if (randomNum == 1)
            {condition = TrackCondition.HEATWAVE;}
        else
            {condition = TrackCondition.NORMAL;}
    }

    //Returns track condition.
    public static TrackCondition getTrackCondition()
    {
        return condition;
    }

    //Sets the location of a car based on its moves.
    public void setLocation(int carIndex)
    {
            locations[carIndex] += cars[carIndex].move();
            setTrackCondition();
    }
    
    /** Displays the track with a numbered grid.  The car will appeart in the grid reflecting its current location.
     */
    public void display()
    {
        // Display track condition
        System.out.print("Track condition: ");
        switch (condition)
        {
            case BLIZZARD:
                System.out.println ("blizzard");
                break;
            case HEATWAVE:
                System.out.println ("heatwave");
                break;
            case NORMAL:
                System.out.println ("normal");
                break;
            default:
                System.out.println ("unknown");
        }

        // Compile each part the track for display
        char label = 'A';
        String trackLabel = "";
        String separator = "";
        String grid = "";
        grid += "|";
        for (int i = 0; i < TRACK_SIZE; i++)
        {
            for (int j = 0; j < MAX_CARS; j++)
            {
                trackLabel += " ";
                separator += "-";
                if (i == locations[j])
                    grid += cars[j].getAppearance();
                else
                    grid += " ";
            }
            trackLabel += label;
            separator += "-";
            label += 1;  
            grid += "|";         
        }
        //grid += "|";
     
        // Display the track
        System.out.println(trackLabel);
        System.out.println(separator);
        System.out.println(grid);
        System.out.println(separator);
        
    }
}