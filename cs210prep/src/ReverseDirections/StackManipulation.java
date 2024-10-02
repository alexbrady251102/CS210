package ReverseDirections;

import java.util.Stack;
import java.util.Scanner;

public class StackManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Number of commands to follow
        scanner.nextLine(); // Move to the next line after reading N

        Stack<Integer> stack = new Stack<>(); // Initialize the stack

        // Process the commands
        for (int i = 0; i < N; i++) {
            String command = scanner.next();
            if (command.equals("PUSH")) {
                int num = scanner.nextInt();
                stack.push(num); // Push the integer onto the stack
            } else if (command.equals("POP")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Pop the top element from the stack (if not empty)
                }
            }
        }

        // Output the result (the integer at the top of the stack)
        if (!stack.isEmpty()) {
            System.out.println(stack.peek());
        } else {
            System.out.println("empty");
        }
    }
}

