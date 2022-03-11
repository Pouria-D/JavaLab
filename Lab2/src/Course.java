import java.util.ArrayList;
import java.util.List;

class Course{
    public String name;
    private Teacher teacher;
    private String department;
    private int unit;
    public int code;
    private List<Student> students = new ArrayList<>();
    // score[i] is student[i]'s score of this course
    private List<Double> scores = new ArrayList<>();

    public Course(String name, int code, int unit, Teacher teacher, String department){
        this.name = name;
        this.code = code;
        this.unit = unit;
        this.teacher = teacher;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public List<Double> getScores() {
        return scores;
    }

    public int getCode() {
        return code;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setScore(int i, double score){
        scores.set(i, score);
    }
    void printInformation(){

        System.out.println("Course Name : " + name);
        System.out.println("Course Code : " + code);
        System.out.println("Units       : " + unit);
        System.out.println("Department  : " + department);
        System.out.println("Teacher     : " + teacher.getName());
    }

    void printStudents(){
        System.out.println("List of Students:");
        for (Student student : students){
            System.out.println(student.getName());
        }
    }

    void addStudent(Student student) {
        if (students.contains(student))
            System.out.println("This student has this course already!");
        else {
            students.add(student);
            scores.add(0.0);
        }
    }
    void removeStudent(Student student){
        if (students.contains(student)) {
            students.remove(student);
            scores.remove(students.indexOf(student));
        }
        else
            System.out.println("This student doesn't have this course");
    }


}
