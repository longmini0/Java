import java.util.Scanner;

public class MinKyeonghoA3 {

    public static void main(String[] args) {

        // Take two user inputs applying the start and end index for string3
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter start index for string3: ");
        int startIndex = scanner.nextInt();
        System.out.print("Enter end index for string3: ");
        int endIndex = scanner.nextInt();

        /* 1. Print the string1 and string2 */
        String string1 = "This is Java assignment 3 ";
        String string2 = "this Is JAVA Assignment 3 ";
        System.out.println(string1);
        System.out.println(string2);

        /* 2. Compare string1 and string2 */
        // Check if they are lexicographically equal with ignoring case
        // Source: https://beginnersbook.com/2013/12/java-string-comparetoignorecase-method-example/
        int compareTwoStrings = string1.compareToIgnoreCase(string2);
        if(compareTwoStrings == 0) {
            System.out.println("String1 and String2 are lexicographically equal");
        } else {
            System.out.println("String1 and String2 are lexicographically unequal");
        }

        /* 3. Print string3 */
        // Concatenate and print string1 and string2
        // Source: Lecture note 'XChapters-1-2.pdf, page 25'
        String string3 = string1.concat(string2);
        System.out.println("Concatenated string: " + string3);

        /* 4. Print substring */
        // Print substring of string3 applying the user input as start and end index
        // Source: Lecture note 'XChapters-1-2.pdf, page 25'
        String subString = string3.substring(startIndex, endIndex);
        System.out.println("Substring is: " + subString);

        /* 5. Print the longest word in string3 */
        // Create the method to find out the longest string
        System.out.println("Longest Word in String3: " + longestWordInString(string3));

        /* 6. Print the capitalized and reversed string */
        // Capitalize the string3
        // Source: Lecture note 'XChapters-1-2.pdf, page 25'
        String string3Uppercase = string3.toUpperCase();
        // Create the method to arrange the string in the reverse order
        System.out.println("Reversed Capital Paragraph: " + reversedString(string3Uppercase));

        System.out.print("Program Completed");

    }

    // Method of searching the longest word in a given string (sentence)
    // Source: https://stackoverflow.com/questions/43251808/java-how-to-find-the-longest-word-in-a-given-string
    private static String longestWordInString(String str) {
        String[] stringArray = str.split(" ");  // Create the string array splitting by space
        String longestWord = ""; // Initial longest word
        // Compare the length of all the words in the sentence
        for(int i = 0; i < stringArray.length; i++) {
            for(int j = 1 + i; j < stringArray.length; j++) {
                if(stringArray[i].length() >= stringArray[j].length()) {
                    // If the length of word is longer than previous, convert as a new longest word
                    longestWord = stringArray[i];
                }
            }
        }
        return longestWord;  // return longest word in sentence
    }

    // Method to reverse the order of words in a string (sentence)
    // https://www.educative.io/edpresso/how-to-reverse-the-order-of-words-in-a-sentence
    private static String reversedString(String str) {
        String[] stringArray = str.split(" ");  // Create the string array splitting by space
        String revString = ""; // Initial reversed string
        for (int i = stringArray.length - 1; i >=0; i--) {
            // Create new string in the reverse order
            revString += stringArray[i] + " ";
        }
        return revString;   // return the reversed sentence
    }


}
