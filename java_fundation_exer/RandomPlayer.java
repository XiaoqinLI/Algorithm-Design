package java_fundation_exer;
/**
 * Student version of RandomPlayer for CS 312 Assignment Rock Paper Scissors.
 * @author (Vallath Nandakumar) 
 * @version (v 1.0, Sept. 23, 2013)
 */
import java.util.Random;
public class RandomPlayer
{
    private Random rand;
    
    RandomPlayer () 
    {
        rand = new Random();
    }
    
    /*
     * Generates a random sequence of integers among 1, 2, and 3.
     */
    public int play ()
    {
        int play = 1 + rand.nextInt(3);
        return play;
    }
}
