public class MinKyeonghoA5 {

    public static void main(String[] args) {
        // Get ready for new objects for each class - Person, Student, Teacher, and CollegeStudent
        Person person = new Person("Jim Hopper",42, "M");
        Student student = new Student("Eleven Bobby Brown", 13, "F", "Feb192004", 3.3);
        Teacher teacher = new Teacher("Joyce Byers", 35, "F", "America Literature", 55000.0);
        CollegeStudent collegeStudent = new CollegeStudent("Lucas Mclaughlin", 19, "M",
                "ST011013", 3.7, 3, "Electronic Engineering");

        // Print out the information of each object by calling their toString methods
        System.out.println(person);
        System.out.println(student);
        System.out.println(teacher);
        System.out.println(collegeStudent);

        // Update the new values for each object
        person.setAge(44);                                 // update new age of person
        student.setGPA(3.56);                              // update new GPA for student
        teacher.setSalary(124550.0);                       // update new salary for teacher
        collegeStudent.setMajor("Computer Engineering");   // update new major for college student

        // Print out the updated information for each object
        System.out.println("\nPerson: " + person);
        System.out.println("Student: " + student);
        System.out.println("Teacher: " + teacher);
        System.out.println("College Student: " + collegeStudent);

        System.out.println("\n\nProgram Completed");


    }
}

