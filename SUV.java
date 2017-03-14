/***********************************************
 * Last Name: Loewen
 * First Name: Mark
 * Student ID: 10024804
 * Course: CPSC 233
 * Tutorial Section: T02
 * Assignment: 3
 *
 * SUV class extends car and adds new modes.
 ***********************************************/

 
public class SUV extends Car
{
    public static final int CONSUMPTION_RATE = 2;
    public static final int AWD_RATE = 4;
    public static final int REGULAR_DISTANCE = 3;
    public static final int AWD_DISTANCE = 2;
    
    boolean awdMode = false;

    public SUV(char anAppearance, String carName)
    {
        super(anAppearance, carName);
    }
    /** Display the options for this car.
     */
    public void displayOptions()
    {
        System.out.println("SUV driving options");
        System.out.println("(a)ll wheel drive mode");
        System.out.println("(d)rive normally");
        System.out.println("(q)uit simulation");
        System.out.print("Enter selection: ");
    }
    
    //Change the mode depending on the user input
    public int processOption(char option)
    {
        switch(option)
        {
            case 'a':
                awdMode = true;
                return AWD_DISTANCE;
            case 'd':
                awdMode = false;
                return REGULAR_DISTANCE;
            case 'q':
                System.exit(0);
                break;
        }
        return 0;
    }

    // Return an integer for how far the car moves given the mode.
    public int move()
    {
        if (awdMode)
        {
            if ((Track.getTrackCondition() == Track.TrackCondition.BLIZZARD) && ((fuelLevel - AWD_RATE) >= 0))
                {   
                    fuelLevel -= AWD_RATE;
                    return AWD_DISTANCE;
                }
                else
                    return 0;
        }
        
        else
        {
            if ((Track.getTrackCondition() == Track.TrackCondition.BLIZZARD) && (fuelLevel - (AWD_RATE + CONSUMPTION_RATE) >= 0))
                {
                    fuelLevel -= (AWD_RATE + CONSUMPTION_RATE);
                    return REGULAR_DISTANCE;
                }
                else if ((Track.getTrackCondition() != Track.TrackCondition.BLIZZARD) && ((fuelLevel - CONSUMPTION_RATE) >= 0))
                {
                    fuelLevel -= CONSUMPTION_RATE;
                    return REGULAR_DISTANCE;
                }
                else
                    return 0;
        }
    }


}