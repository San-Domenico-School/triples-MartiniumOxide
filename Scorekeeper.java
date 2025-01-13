/**
 * Write a description of class Scorekeeper here.
 * 
 * @Martin
 * @Jan 12, 2025
 */
public class Scorekeeper  
{
    private static int deckSize, score;
    private static long startTime = System.currentTimeMillis();
    
    public static void setDeckSize (int deckSize1)
    {
        deckSize = deckSize1;
    }

    public static void updateScore()
    {
        int scoreInc = 1;/*later implementation assign
        the increase in score related to player's time of playing
        to scoreInc
        */
        score = score + scoreInc;
    }
    
    public static int getScore()
    {
        return score;
    }
    
}
