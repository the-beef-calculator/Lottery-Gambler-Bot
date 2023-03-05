import java.text.DecimalFormat;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#,###");
//        long duplicateEntry = 0;
//        long duplicateThreshold = 50;

        long moneySpent = 0;
        long attempts = 0;
        long threshold = 1000;

        System.out.println("Generating PowerBall numbers...");

        List<Integer> powerballNumbers = new ArrayList<>();

        populateArray(powerballNumbers);

        System.out.println("Finished!");

        System.out.println("Winning lottery numbers are " + powerballNumbers);

        List<Integer> playerEntry = new ArrayList<>();
        //HashMap<List<Integer>, String > duplicates = new HashMap<>();

        populateArray(playerEntry);
        //duplicates.put(playerEntry.stream().toList(),"true");

        System.out.println("Attempting to win the lottery...");


        while(!playerEntry.equals(powerballNumbers))
        {
            attempts++;
            moneySpent+=2;
            playerEntry.clear();
            populateArray(playerEntry);

//            if(duplicates.containsKey(playerEntry.stream().toList()))
//            {
//                while (duplicates.containsKey(playerEntry.stream().toList())) {
//                    playerEntry.clear();
//                    populateArray(playerEntry);
//                    duplicateEntry++;
//
//                    if (duplicateEntry == duplicateThreshold)
//                    {
//                        System.out.println(formatter.format(duplicateEntry) + " duplicates have been generated.");
//                        duplicateThreshold *= 2;
//                    }
//
//                }
//            }
//            else
//            {
//                duplicates.put(playerEntry.stream().toList(),"true");
//            }


            if (attempts == threshold)
            {
                System.out.println(formatter.format(attempts) + " attempts have passed.");
                threshold*=2;
            }


        }
        System.out.println("Jackpot!");
        System.out.println("It only took " + formatter.format(attempts) + " attempts, and $" + formatter.format(moneySpent) +".");



    }

    public static void populateArray(List<Integer> list) //populates array with Powerball restrictions
    {
        Random rand = new Random();
        for (int i = 0; i < 5; i++)
        {
            list.add(rand.nextInt(1, 69));
        }
        list.add(rand.nextInt(1,26));
    }


}
