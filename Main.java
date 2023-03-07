import java.awt.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;
import javax.swing.*;


public class Main {
    public static void main(String[] args)  {
        DecimalFormat formatter = new DecimalFormat("#,###");
        long duplicateEntry = 0;
        long duplicateThreshold = 50;

        JFrame frame = new JFrame("Live attempt count:"); // create a new frame
        JLabel label = new JLabel("Attempts: "); // create a new label with initial value 0
        JLabel jackpotNumbers = new JLabel("Jackpot Numbers: ");


        frame.add(label); // add the label to the frame
        frame.pack(); // resize the frame to fit the label
        frame.setBounds(new Rectangle(200,100));
        frame.setVisible(true); // show the frame

        long moneySpent = 0;
        long attempts = 0;
        long threshold = 1000;

        System.out.println("Generating PowerBall numbers...");

        List<Integer> powerballNumbers = new ArrayList<>();

        populateArray(powerballNumbers);

        System.out.println("Finished!");

        System.out.println("Winning lottery numbers are " + powerballNumbers);

        jackpotNumbers.setText("Winning lottery numbers are: : " + powerballNumbers);

        List<Integer> playerEntry = new ArrayList<>();
        HashMap<List<Integer>, String > duplicates = new HashMap<>();

        populateArray(playerEntry);
        duplicates.put(playerEntry.stream().toList(),"true");

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

            label.setText("Attempts: " + formatter.format(attempts) ");


        }
        System.out.println("Jackpot!");
        System.out.println("It only took " + formatter.format(attempts) + " attempts, and $" + formatter.format(moneySpent) +".");



    }

    public static void populateArray(List<Integer> list) //populates array with Powerball restrictions
    {
        Random rand = new Random();
        for (int i = 0; i < 5; i++)
        {
            list.add(rand.nextInt(1, 70));
        }
        list.add(rand.nextInt(1,25));
    }


}