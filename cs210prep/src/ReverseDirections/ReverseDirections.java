package ReverseDirections;

import java.util.Stack;

public class ReverseDirections {

    public static void main(String[] args) {
        String instructions = "Go North, Go North, Go West, Go Back, Arrived";
        String reversedInstructions = reverseDirections(instructions);
        System.out.println("Reversed Instructions: " + reversedInstructions);
    }

    public static String reverseDirections(String instructions) {
        String[] instructionArray = instructions.split(", ");

        Stack<String> stack = new Stack<>();
        for (String instruction : instructionArray) {
            if (instruction.equals("Arrived")) {
                break;
            } else if (instruction.equals("Go Back")) {
                stack.pop();
            } else {
                stack.push(instruction);
            }
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            String instruction = stack.pop();
            if (instruction.equals("Go North")) {
                reversed.append("Go South ");
            } else if (instruction.equals("Go South")) {
                reversed.append("Go North ");
            } else if (instruction.equals("Go East")) {
                reversed.append("Go West ");
            } else if (instruction.equals("Go West")) {
                reversed.append("Go East ");
            }
        }

        return reversed.toString().trim();
    }
}