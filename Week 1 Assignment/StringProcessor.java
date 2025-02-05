package Week1.programs;

public class StringProcessor {

    public static final String REVERSED_STRING_MESSAGE = "Reversed String is : ";
    public static final String OCCURRENCE_COUNT_MESSAGE = "Occurrences Count is : ";
    public static final String CAPITALIZED_STRING_MESSAGE = "Capitalized String is : ";

    public String reverseString(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return inputString;
        }
        return new StringBuilder(inputString).reverse().toString();
    }


    public int countOccurrences(String text, String subString) {
        if (text == null || subString == null || subString.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;

        // Iterate through the text and count occurrences of subString
        while ((index = text.indexOf(subString, index)) != -1) {
            count++;
            index += subString.length();
        }
        return count;
    }

    public String splitAndCapitalize(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return inputString;
        }

        String[] words = inputString.split(" ");
        StringBuilder capitalizedString = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                capitalizedString.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1)).append(" ");
            }
        }

        return capitalizedString.toString().trim();
    }

    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();
        String reversed = processor.reverseString("hello world");
        System.out.println(REVERSED_STRING_MESSAGE + reversed);
        int occurrences = processor.countOccurrences("redundancy", "ancy");
        System.out.println(OCCURRENCE_COUNT_MESSAGE + occurrences);
        String capitalized = processor.splitAndCapitalize("java is fun");
        System.out.println(CAPITALIZED_STRING_MESSAGE + capitalized);
    }
}
