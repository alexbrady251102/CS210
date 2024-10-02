import java.util.Arrays;
import java.util.Scanner;

public class StudentMedianScore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // Number of inputs
        scanner.nextLine(); // Move to the next line after reading N

        String[] names = new String[N];
        int[] scores = new int[N];

        // Read names and scores into arrays
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            names[i] = parts[0];
            scores[i] = Integer.parseInt(parts[1]);
        }

        // Find and output the name of the student with the median score
        String medianStudent = findMedianStudent(names, scores);
        System.out.println("Student with the median score: " + medianStudent);
    }

    // Function to find the name of the student with the median score
    public static String findMedianStudent(String[] names, int[] scores) {
        int[] sortedScores = scores.clone();
        Arrays.sort(sortedScores);

        int middleIndex = sortedScores.length / 2;

        if (sortedScores.length % 2 == 0) {
            // If even number of students, find the first name that matches the lower median score
            for (int i = 0; i < scores.length; i++) {
                if (scores[i] == sortedScores[middleIndex - 1]) {
                    return names[i];
                }
            }
        } else {
            // If odd number of students, find the name that matches the median score
            for (int i = 0; i < scores.length; i++) {
                if (scores[i] == sortedScores[middleIndex]) {
                    return names[i];
                }
            }
        }

        // This should not happen in the given constraints, but return null if something goes wrong
        return null;
    }
}
