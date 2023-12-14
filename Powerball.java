import java.util.HashSet;
import java.util.Random;

public class Powerball
{
    private HashSet<Integer> powerBall5;
    private int jackpotNumber;
    int randInt;


    public Powerball(boolean isFirstPowerball)
    {
        Random rand = new Random();
        if (isFirstPowerball)
        {
            System.out.println("Generating winning Powerball numbers...");
        }
        powerBall5 = new HashSet<>();
        for (int i = 0; i < 5; i++)
        {
            randInt = rand.nextInt(1,70);  // Generating random numbers from 1-69
            while(powerBall5.contains(randInt))
            {
               randInt = rand.nextInt(1,70);
            }
            powerBall5.add(randInt);
        }

        jackpotNumber = rand.nextInt(1,27); // Generating random number from 1-26

        if (isFirstPowerball)
        {
            System.out.println("Finished!");
            System.out.println("Winning Lottery numbers are: " + powerBall5.toString() + "\nJackpot: " + jackpotNumber );
        }

    }

    public void regenerateNumbers()
    {
        powerBall5.clear();
        Random rand = new Random();
        for (int i = 0; i < 5; i++)
        {
            randInt = rand.nextInt(1,70);  // Generating random numbers from 1-69
            while(powerBall5.contains(randInt))
            {
                randInt = rand.nextInt(1,70);
            }
            powerBall5.add(randInt);
        }

        jackpotNumber = rand.nextInt(1,27);
    }


    public boolean equals(Powerball other)
    {
        return (this.powerBall5.equals(other.powerBall5) && this.jackpotNumber == other.jackpotNumber);
    }



}
