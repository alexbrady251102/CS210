package montecarlo;

import java.util.Random;

public class DiceRollSimulation {
    public static void main(String[] args) {
        int numSimulations = 10000; // Number of simulations
        int totalRolls = 0;

        for (int i = 0; i < numSimulations; i++) {
            int rollsNeeded = simulateRolls();
            totalRolls += rollsNeeded;
        }

        double averageRolls = (double) totalRolls / numSimulations;
        System.out.println("Average number of rolls needed to see the same number 6 times: " + averageRolls);
    }

    // Simulate rolling a dice until the same number comes up 6 times consecutively
    private static int simulateRolls() {
        Random random = new Random();
        int consecutiveCount = 0;
        int prevRoll = 0;
        int rolls = 0;

        while (consecutiveCount < 6) {
            int rollResult = random.nextInt(6) + 1; // Random number between 1 and 6 (inclusive)
            if (rollResult == prevRoll) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1;
            }
            prevRoll = rollResult;
            rolls++;
        }

        return rolls;
    }
}
