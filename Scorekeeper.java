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
        long currentTime = System.currentTimeMillis();
        int timeElapsed = (int) ((currentTime - startTime) / 1000); // Time in seconds
        score += Math.max(27 - timeElapsed, 10); // Example scoring logic
        startTime = currentTime; // Reset the start time
    }
    
    public static void resetScore()
    {
        score = 0;
    }
    
    public static int getScore()
    {
        return score;
    }
    
}
