public class CollegeStudent extends Student{
    private String major; // major of college student
    private int year; // year of college student

    // constructor for CollegeStudent class
    public CollegeStudent (String name, int age, String gender,
                           String idNum, double gpa, int year, String major) {
        // Use the constructor from super classes - Student, Person
        super(name, age, gender, idNum, gpa);

        // initialize the new ones
        this.major = major;
        this.year = year;
    }

    // Getter and setter for college student's major
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    // Getter and setter for college student's year
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    // override the toString method from the super class
    public String toString() {
        return super.toString() + ", year: " + year + ", major: " + major;
    }
}
