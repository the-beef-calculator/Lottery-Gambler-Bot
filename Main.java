import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;
import javax.swing.*;


public class Main {
    public static void main(String[] args)
    {

        int attempts = 0;
        Powerball winningPowerball = new Powerball(true);

        System.out.println("Attempting to win the lottery...");

        Powerball playerPowerball = new Powerball(false);

        while (!winningPowerball.equals(playerPowerball))
        {
            playerPowerball.regenerateNumbers();
            attempts++;
        }

        System.out.println("Jackpot!");
        System.out.println("It only took " + NumberFormat.getNumberInstance().format(attempts) + " attempts!");



    }


}
