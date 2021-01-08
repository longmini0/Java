public class Teacher extends Person{
    private String subject; // subject of teacher
    private double salary; // salary of teacher

    // Constructor for teacher class
    public Teacher (String name, int age, String gender, String subject, double salary) {
        // use the constructor of the super class - Person
        super(name, age, gender);

        // initialize the new ones
        this.subject = subject;
        this.salary = salary;
    }

    // Getter and setter for teacher's subject
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Getter and setter for teacher's salary
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // override the toString method from the super class
    public String toString() {
        return super.toString() + ", subject: " + subject + ", salary: " + salary;
    }


}
