package CoinTossMonteCarlo.java;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DiceMonteCarlo {

    public static void main(String[] args) {
        int numSimulations = 100000; // Number of Monte Carlo simulations
        int numFaces = 6; // Number of faces on the dice

        double averageRolls = calculateAverageRolls(numSimulations, numFaces);
        System.out.println("Average number of rolls needed to see all " + numFaces + " numbers: " + averageRolls);
    }

    public static double calculateAverageRolls(int numSimulations, int numFaces) {
        int totalRolls = 0;

        for (int i = 0; i < numSimulations; i++) {
            Set<Integer> numbersSeen = new HashSet<>();
            int rollsNeeded = 0;

            while (numbersSeen.size() < numFaces) {
                int roll = rollDice(numFaces);
                numbersSeen.add(roll);
                rollsNeeded++;
            }

            totalRolls += rollsNeeded;
        }

        return (double) totalRolls / numSimulations;
    }

    public static int rollDice(int numFaces) {
        Random random = new Random();
        return random.nextInt(numFaces) + 1;
    }
}
