/***********************************************
 * Last Name: Loewen
 * First Name: Mark
 * Student ID: 10024804
 * Course: CPSC 233
 * Tutorial Section: T02
 * Assignment: 3
 *
 * Sports car class extends car and adds new modes.
 ***********************************************/


public class Sports extends Car
{
    public static final int CONSUMPTION_RATE = 2;
    public static final int OVERHEATED_RATE = 4;
    public static final int REGULAR_DISTANCE = 4;
    public static final int OVERHEATED_DISTANCE = 1;

    private boolean cooldownMode = false;
    private boolean overheatedMode = false;
    private boolean driveNormal = true;
    private boolean driveOverheated = false;
    private boolean cooled = false;

    
    public Sports(char anAppearance, String carName)
    {
        super(anAppearance, carName);
    }

    /** Display the options for this car.
     */
    public void displayOptions()
    {
        System.out.println("Sportscar driving options");
         if (isOverheated())
             System.out.println("WARNING: car is overheated.");
         System.out.println("(c)ool off");
         System.out.println("(d)rive normally");
         System.out.println("(q)uit simulation");
         System.out.print("Enter selection: ");
    }
    
    //boolean indicating if the car is overheated
    public boolean isOverheated()
    {
        if (!cooled && (Track.getTrackCondition() == Track.TrackCondition.HEATWAVE))
            overheatedMode = true;
        else if ((Track.getTrackCondition() != Track.TrackCondition.HEATWAVE) && cooldownMode)
            cooled = false;
        return overheatedMode;
    }

    //Change the mode depending on the user input
    public int processOption(char option)
    {
        switch(option)
        { 
            case 'c':
                cooldownMode = true;
                cooled = true;
                return 0;
            case 'd':
                if (isOverheated())
                {
                    driveOverheated = true;
                    driveNormal = false;
                    cooldownMode = false;
                    return OVERHEATED_DISTANCE;
                }
                else
                {
                    driveNormal = true;
                    return REGULAR_DISTANCE;
                }
            case 'q':
                System.exit(0);
                break;

        }
        return 0;
    }
    
    //Return an integer for how far the car moves given the mode.
    public int move()
    {
        if (cooldownMode)
            return 0;
        else if (driveOverheated)
        {
            if ((fuelLevel - OVERHEATED_RATE) >= 0)
            {
                fuelLevel -= OVERHEATED_RATE;
                return OVERHEATED_DISTANCE;
            }
            else
                return 0;
        }
        else if (driveNormal)
        {
            if ((fuelLevel - CONSUMPTION_RATE) >= 0)
            {
                fuelLevel -= CONSUMPTION_RATE;
                return OVERHEATED_DISTANCE;
            }
            else
                return 0;
        }
        return 0;
    }
}