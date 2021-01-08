public class MinKyeonghoA1 {
    public static void main(String[] args) {

        if(args.length != 2) {
            // print USAGE if the length of arguments is not 2
            // Source: https://stackoverflow.com/questions/18446509/args-length-and-command-line-arguments
            System.out.println("Usage: java KyeonghoMinA1 {number1 number2}");
        }
        else {
            int area = 0; // create initial number of area, 0

            // Command line arguments are stored as a string, so convert them into integers using Parse method
            // Source: https://javatutoring.com/command-line-arguments-java-with-examples/
            int number1 = Integer.parseInt(args[0]); // length of a rectangle
            int number2 = Integer.parseInt(args[1]); // breadth of a rectangle

            area = number1 * number2;
            areaOfRectangle(area); //Method for calculating area using given two natural numbers
        }

        System.out.println("Program Completed");
    }

    // Create areaOfRectangle method
    private static void areaOfRectangle(int area) {
        if(area < 100) {
            System.out.printf("The area for given rectangle is %d and it is less than 100 \n", area);
        } else if(area > 100) {
            System.out.printf("The area for given rectangle is %d and it is greater than 100 \n", area);
        } else {
            System.out.printf("The area for given rectangle is %d and it is the same as 100 \n", area);
        }
    }
}
