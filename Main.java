import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;
import javax.swing.*;


public class Main {
    public static void main(String[] args)
    {
        int threshold = 10000;
        int attempts = 0;

        Powerball winningPowerball = new Powerball(true);

        System.out.println("Attempting to win the lottery...\n");

        Powerball playerPowerball = new Powerball(false);

        while (!winningPowerball.equals(playerPowerball))
        {
            playerPowerball.regenerateNumbers();
            attempts++;
            if (attempts == threshold)
            {
                threshold *= 2;
                System.out.println(NumberFormat.getNumberInstance().format(attempts) + " failed attempts so far.");
            }
        }
        int dollarAmount = attempts*2;

        System.out.println("Jackpot!");
        System.out.println("It only took " + NumberFormat.getNumberInstance().format(attempts) + " attempts, wasting $" +
                NumberFormat.getNumberInstance().format(dollarAmount) + " dollars.");



    }


}
