import java.util.Scanner;

public class MinKyeonghoA2 {

    public static void main(String[] arg) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the length of an array: ");
        int arrayLength = scanner.nextInt(); // Define the user input as the length of array

        /* [1] Input Array */
        int[] inputArray = new int[arrayLength]; // initial array
        System.out.printf("Please enter %d elements for the array: ", arrayLength);
        // Accept the user inputs as array elements based on the array length
        // Source: https://www.javatpoint.com/how-to-take-array-input-in-java
        for(int i = 0; i < arrayLength; i++) {
            inputArray[i] = scanner.nextInt();
        }
        // Create the method for printing out the array based on user inputs
        printInputArray(inputArray);


        /* [2] Sorted Array in ascending order */
        int[] sortedArray;
        // Create the clone of inputArray
        // Source: https://www.geeksforgeeks.org/array-copy-in-java/
        sortedArray = inputArray.clone();
        // Create the method for printing out the sorted array in ascending order
        printSortedArray(sortedArray);


        /* [3] Search the element and find the index */
        System.out.print("Please enter the number to be searched: ");
        int number = scanner.nextInt();
        // Find the index of elements in the sorted array
        // https://www.geeksforgeeks.org/find-the-index-of-an-array-element-in-java/
        boolean found = false;
        int indexNumber = -1;
        for(int i = 0; i < sortedArray.length; i++) {
            indexNumber++;
            if(number == sortedArray[i]){
                found = true;
                break;
            }
        }
        if(found) // if the user input is in the array
            System.out.println("The element found at index: " + indexNumber);
        else
            System.out.println("The element is not present in the array");


        /* [4] The reverse order array */
        int[] reverseOrderArray;
        reverseOrderArray = inputArray.clone();
        // Create the method for printing out array in reverse order
        printReverseOrderArray(reverseOrderArray);


        System.out.println("\nProgram Completed.");

    }

    // Method for printing out user input array
    private static void printInputArray(int[] inputArray) {
        System.out.print("The input array is: [ ");
        for (int j : inputArray) {
            System.out.print(j + " ");
        }
        System.out.println("]");
    }

    // Method for printing sorted array in ascending order
    // Source: https://www.softwaretestinghelp.com/sort-arrays-in-java/
    private static void printSortedArray(int[] sortedArray) {
        // Sort the array elements in ascending order
        for(int i =0; i < sortedArray.length; i++) {
            for(int j = i + 1; j < sortedArray.length; j++) {
                if(sortedArray[i] > sortedArray[j]) {
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }
        // Print the sorted array
        System.out.print("The sorted array is: [ ");
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println("]");
    }

    // Method for printing out array in reverse order
    // Source: https://www.javatpoint.com/java-program-to-print-the-elements-of-an-array-in-reverse-order
    private static void printReverseOrderArray(int[] reverseOrderArray) {
        System.out.print("The array in reverse order is: [ ");
        for (int i = reverseOrderArray.length - 1; i >= 0; i--) {
            System.out.print(reverseOrderArray[i] + " ");
        }
        System.out.println("]");
    }

}
