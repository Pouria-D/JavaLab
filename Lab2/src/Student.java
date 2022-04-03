import java.util.ArrayList;
import java.util.List;

class Student{
    private String firstName;
    private String lastName;
    private String nationalID;
    public int studentID;
    private String field;
    private List<Course> courses = new ArrayList<>();

    public Student(int studentID, String firstName, String lastName, String nationalID, String field){
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalID = nationalID;
        this.field = field;
    }

    public String getName (){
        String name = firstName + " " + lastName;
        return name;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getNationalID() {
        return nationalID;
    }

    public List<Course> getCourses() {
        return courses;
    }

    void printInformation(){

        System.out.println("student ID  : " + studentID);
        System.out.println("Name        : " + firstName);
        System.out.println("LastName    : " + lastName);
        System.out.println("National ID : " + nationalID);
        System.out.println("Study Field : " + field);
        System.out.println("Current Courses are :");
        for (Course course : courses){
            System.out.print(course.name + " ");
        }
    }

    void addCourse(Course course){
        if (courses.contains(course))
            System.out.println("Already Have this course!");
        else {
            course.addStudent(this);
            courses.add(course);
        }
    }

    void removeCourse(Course course){
        if (courses.contains(course)) {
            courses.remove(course);
            course.removeStudent(this);
        }
        else
            System.out.println("You don't have this course!");
    }

    double calculateAverage(){
        double average;
        double sum = 0.0;
        int number = 0;
        for (Course course : courses){
            for (Student student : course.getStudents())
                if (student.getStudentID() == studentID){
                    int index = course.getStudents().indexOf(student);
                    double score = course.getScores().get(index);
                    if (score != 0.0) {
                        sum += score;
                        number += 1;
                    }
                    break;
                }
        }

        average = sum / number;
        return average;
    }
}