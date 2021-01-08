import java.util.Scanner;

public class MinKyeonghoA4 {

    // Create the member method - tax calculator
    public static class TaxCalculator {
        private double taxableIncome;
        private String filingStatus;

        // Constructor
        public TaxCalculator() {
            this("",0);
        }

        // Constructor
        public TaxCalculator(String filingStatus, double taxableIncome) {
            this.filingStatus = filingStatus;
            this.taxableIncome = taxableIncome;
        }

        // Create setter and getter for the private variables
        // Source: Lecture Note 'XChapters_3-4.pdf, page 9'
        public void setFilingStatus(String filingStatus) {
            this.filingStatus = filingStatus;
        }
        public void setTaxableIncome(double taxableIncome) {
            this.taxableIncome = taxableIncome;
        }
        public double getTaxableIncome() {
            return taxableIncome;
        }
        public String getFilingStatus() {
            return filingStatus;
        }

        // Create a method for calculating single's tax
        public double calculateSinglesTax() {
            double myTax = 0;

            if(taxableIncome <= 0) // if taxable income is less than 0, tax returns 0
                return myTax;

            if((0 < taxableIncome) && (taxableIncome <= 27050)) {
                myTax = taxableIncome * 0.15;
            } else if((27050 < taxableIncome) && (taxableIncome <= 65550)) {
                myTax = (taxableIncome - 27050) * 0.275 + 4057.5;
            } else if((65550 < taxableIncome) && (taxableIncome <= 136750)) {
                myTax = (taxableIncome - 65550) * 0.305 + 14645;
            } else if((136750 < taxableIncome) && (taxableIncome <= 297350)) {
                myTax = (taxableIncome - 136750) * 0.355 + 36361;
            } else {
                myTax = (taxableIncome - 297350) * 0.391 + 93374;
            }

            return myTax;
        }

        // Create a method for calculating married's tax
        public double calculateMarriedTax() {
            double myTax = 0;

            if(taxableIncome <= 0)
                return myTax;

            if((0 < taxableIncome) && (taxableIncome <= 45200)) {
                myTax = taxableIncome * 0.15;
            } else if((45200 < taxableIncome) && (taxableIncome <= 109250)) {
                myTax = (taxableIncome - 45200) * 0.275 + 6780.00;
            } else if((109250 < taxableIncome) && (taxableIncome <= 166500)) {
                myTax = (taxableIncome - 109250) * 0.305 + 24393.75;
            } else if((166500 < taxableIncome) && (taxableIncome <= 297350)) {
                myTax = (taxableIncome - 166500) * 0.355 + 41855.00;
            } else {
                myTax = (taxableIncome - 297350) * 0.391 + 88306.00;
            }

            return myTax;
        }

        // Create a method for calling to single's or married's tax calculator based on user's input
        public double calculateTax() {
            double myTax;
            if (filingStatus.toLowerCase().equals("single")) {
                myTax = calculateSinglesTax();
            } else if (filingStatus.toLowerCase().equals("married")) {
                myTax = calculateMarriedTax();
            } else {
                myTax = 0;
            }
            return myTax;
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaxCalculator taxCal = new TaxCalculator(); // initialize

        // get user inputs - filing status as a string and income as a double
        // Source: https://www.w3schools.com/java/java_user_input.asp
        System.out.print("Please enter your filing status (single / married): ");
        String myStatus = input.nextLine();
        System.out.print("Please enter your taxable income: ");
        double taxIncome = input.nextDouble();

        // set the filing status and income and call to Tax Calculator method
        taxCal.setFilingStatus(myStatus);
        taxCal.setTaxableIncome(taxIncome);

        // print out the result of calculated tax based on user's input - filing status and income
        // in order to print out, use getter methods that I created above
        // Source: Lecture note 'XChapter_3-4.pdf, page12'
        System.out.println("Your filing status is " + taxCal.getFilingStatus().toUpperCase() +
                ", and you are responsible to pay $" + taxCal.calculateTax() + " federal tax for your $" +
                taxCal.getTaxableIncome() + " of taxable income.");

        System.out.println("\nProgram Completed");

    }


}