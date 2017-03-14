/** 
 * Car.java: The parent class for all car models. <br>
 * @version CPSC 233
 */

public abstract class Car
{
    public static final int DEFAULT_FUELLEVEL = 60;
    private char appearance;
    private String name;
    public int fuelLevel;
    
    /** Constructor: initilize the appearance and fuel level
     * @param letter The symbol representing the car
     * @param fuel The intial fuel level
     */
    public Car(char anAppearance, String carName)
    {
        appearance = anAppearance;
        name = carName;
        
        fuelLevel = DEFAULT_FUELLEVEL;
    }
    
    /** Get the fuel level.
     * @return The current fuel level
     */
    public int getFuelLevel()
    {
        return fuelLevel;
    }

    /** Check whether the fuel is empty.
     * @return True, if the tank is empty.  Otherise, false.
     */
    public boolean isEmpty()
    {
        if (fuelLevel <= 0)
            return true;
        else
            return false;
    }

    /** Consume fuel by reducing fuel level.
     * @param amount The amount of fuel to consume.
     */
    public void consumeFuel(int amount)
    {
        if (amount > 0)
            fuelLevel = fuelLevel - amount;
    }

    /** Get the appearance of a car
     * @return The symbol representing the car
     */
    public final char getAppearance()
    {
        return appearance;
    }
    
    public final String toString() 
    {
        return name + ": " + fuelLevel;
    }
    
    /** An abstract method move() to be defined by specific car model
     * @return The number of moves the car makes.
     */
    public abstract int move ();

    /** Display the options for this car.
     */
    public abstract void displayOptions();
    
    /** Process the option provided by players
     * @param option The option provided by players.
     * @return The distance traveled in this move.
     */
    public abstract int processOption(char option);

}