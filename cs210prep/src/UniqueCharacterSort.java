import java.util.*;

public class UniqueCharacterSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of words
        scanner.nextLine(); // Move to the next line after reading n

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }

        List<String> sortedList = sortWordsByUniqueCharacters(words);

        for (String word : sortedList) {
            System.out.print(word + " ");
        }
    }

    public static List<String> sortWordsByUniqueCharacters(String[] words) {
        List<String> wordList = Arrays.asList(words);

        // Sort words based on the number of unique characters using a custom comparator
        Collections.sort(wordList, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                int uniqueChars1 = countUniqueCharacters(word1);
                int uniqueChars2 = countUniqueCharacters(word2);

                // If the number of unique characters is the same, sort alphabetically
                if (uniqueChars1 == uniqueChars2) {
                    return word1.compareTo(word2);
                }

                // Sort by the number of unique characters in ascending order
                return Integer.compare(uniqueChars1, uniqueChars2);
            }
        });

        return wordList;
    }

    public static int countUniqueCharacters(String word) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : word.toCharArray()) {
            uniqueChars.add(c);
        }
        return uniqueChars.size();
    }
}

