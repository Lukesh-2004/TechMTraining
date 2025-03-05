package Week1.programs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
public class Anagram {

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        int sLength = s.length();
        int pLength = p.length();

        if (pLength > sLength) {
            return result;
        }

        int[] pCharFrequency = new int[26]; // Frequency of characters in p
        int[] windowCharFrequency = new int[26]; // Frequency of characters in sliding window

        // Populate the frequency array for p
        for (char c : p.toCharArray()) {
            pCharFrequency[c - 'a']++;
        }

        // Sliding window approach
        for (int i = 0; i < sLength; i++) {
            // Add current character to window frequency
            windowCharFrequency[s.charAt(i) - 'a']++;

            // Remove character that is left outside the window
            if (i >= pLength) {
                windowCharFrequency[s.charAt(i - pLength) - 'a']--;
            }

            // Compare arrays when window reaches pLength
            if (Arrays.equals(pCharFrequency, windowCharFrequency)) {
                result.add(i - pLength + 1);
            }
        }

        return result;


    }

    public static void main(String[] args) {
        String s = "listening";
        String p = "Lukesh";

        List<Integer> result = findAnagrams(s, p);
        System.out.println("Anagram start indices: " + result);
    }
}
