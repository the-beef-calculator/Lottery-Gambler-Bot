import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Powerball
{
    private int[] powerBall5;
    private int jackpotNumber;


    public Powerball(boolean isFirstPowerball)
    {
        Random rand = new Random();
        if (isFirstPowerball)
        {
            System.out.println("Generating winning Powerball numbers...");
        }
        powerBall5 = new int[5];

        for (int i = 0; i < 5; i++)
        {
            powerBall5[i] = rand.nextInt(1,70); // Generating random numbers from 1-69
        }
        jackpotNumber = rand.nextInt(1,27); // Generating random number from 1-26

        if (isFirstPowerball)
        {
            System.out.println("Finished!");
            System.out.println("Winning Lottery numbers are: " + Arrays.toString(powerBall5) + "\nJackpot: " + jackpotNumber );
        }

    }

    public void regenerateNumbers()
    {
        Random rand = new Random();
        for (int i = 0; i < 5; i++)
        {
            powerBall5[i] = rand.nextInt(1,70); // Generating random numbers from 1-69
        }
        jackpotNumber = rand.nextInt(1,27); // Generating random number from 1-26
    }

    private Map<Integer, Integer> getFrequencyMap(int[] array)
    {
        Map<Integer,Integer> freqMap = new HashMap<>();

        for (int num : array)
        {
            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);
        }
        return freqMap;
    }


    public boolean equals(Powerball other)
    {
        Map<Integer, Integer> thisFreqMap = getFrequencyMap(this.powerBall5);
        Map<Integer, Integer> otherFreqMap = getFrequencyMap(other.powerBall5);

        return (thisFreqMap.equals(otherFreqMap) && this.jackpotNumber == other.jackpotNumber);

    }



}
