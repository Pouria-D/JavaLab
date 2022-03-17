import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {
    static List<Student> AllStudents = new ArrayList<>();
    static List<Teacher> AllTeachers = new ArrayList<>();
    static List<Course> Allcourses = new ArrayList<>();

    public static void main(String[] args) {
        CLI();
    }

    public static void CLI(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Welcome to Education System \n Choose your roll that you want log in and type it's number \n " +
                    " \n 1.Education Manager \n 2.Teacher \n 3.Student \n in each level you can log out of your account by typing \" Exit \"" +
                    " and quit the program by typing \" quit \"");
            String input = scanner.next();
            if (input.equals("quit"))
                return;
            else if (input.equals("1") || input.equals("2") || input.equals("3")) {
                System.out.println("Enter Username:");
                String username = scanner.next();
                System.out.println("Enter Password");
                String password = scanner.next();
                switch (input) {
                    case "1":
                        // we set only one admin for edu and he can add and delete students and courses from list
                        // user and password is admin
                        String user = "admin";
                        String pass = "admin";
                        if (username.equals(user) && password.equals(pass)) {
                            System.out.println("Welcome to Management portal. \n you can do these actions by typing them : \n " +
                                    "Add and Delete Students, Teachers, Courses \n Print Student, Teachers, Courses Lists");
                            String operation = scanner.next();
                            managerCLI(operation);
                        }
                        else
                            System.out.println("Username or Password is wrong Try logging on again");
                        break;
                    case "2":
                        Teacher teacher = AllTeachers.get(0);
                        int flag = 0;
                        for (Teacher teacher1 : AllTeachers) {
                            if (teacher1.getUsername().equals(username) && teacher1.getPassword().equals(password)){
                                teacher = teacher1;
                                flag = 1;
                            }
                        }
                        if (flag == 1){
                            System.out.println("Welcom to Dr" + teacher.getName() + " Portal \n you can do these actions by typing them : \n" +
                                    "Give students of your course's grade \n watch your student's profile \n change your password \n " +
                                    "Now type the action that you want to do");
                            String operation = scanner.next();
                            teacherCLI(teacher, operation);
                        }
                        else
                            System.out.println("Username or Password is wrong Try logging on again");

                        break;
                    case "3":
                        Student student = AllStudents.get(0);
                        flag = 0;
                        for (Student student1 : AllStudents) {
                            if (student1.getStudentID() == Integer.parseInt(username) && student1.getNationalID().equals(password)){
                                student = student1;
                                flag = 1;
                            }
                        }
                        if (flag == 1){
                            System.out.println("Welcom to " + student.getName() + " Portal \n you can do these actions by typing them : \n" +
                                    "Add and delete courses \n see your profile \n calculate your average \n see course Information" +
                                    "Now type the action that you want to do");
                            String operation = scanner.next();
                            studentCLI(student, operation);
                        }
                        else
                            System.out.println("Username or Password is wrong Try logging on again");

                        break;
                }
            }
            else if (input.equalsIgnoreCase("exit"))
                System.out.println("You haven't log in yet");
        }
    }

    public static void managerCLI(String operation){
        Scanner scanner = new Scanner(System.in);
        switch (operation){
            case "AddStudent":
                System.out.println("First Name:");
                String firstName = scanner.next();
                System.out.println("Last Name:");
                String lastName = scanner.next();
                System.out.println("Student ID:");
                int studentID = scanner.nextInt();
                System.out.println("national ID:");
                String nationalID = scanner.next();
                System.out.println("Field Study:");
                String field = scanner.next();
                Student student = new Student(studentID, firstName, lastName, nationalID, field);
                AllStudents.add(student);
                System.out.println("Student added successfully \n if you're done type \" exit \" else type your next operation");
                break;
            case "DeleteStudent":
                System.out.println("Enter the student ID");
                studentID = scanner.nextInt();
                AllStudents.removeIf(student1 -> student1.getStudentID() == studentID);
                System.out.println("If the was such a student it's gone!");
                break;
            case "AddTeacher":
                System.out.println("Name:");
                String name = scanner.next();
                System.out.println("Username:");
                String username = scanner.next();
                System.out.println("Password:");
                String password = scanner.next();
                Teacher teacher = new Teacher(name, username, password);
                AllTeachers.add(teacher);
                System.out.println("Teacher added successfully \n if you're done type \" exit \" else type your next operation");
                break;
            case "DeleteTeacher":
                System.out.println("Enter the Teacher Name");
                name = scanner.next();
                AllTeachers.removeIf(teacher1 -> teacher1.getName().equals(name));
                System.out.println("If the was such a teacher it's gone!");
                break;
            case "AddCourse":
                System.out.println("Name:");
                name = scanner.next();
                System.out.println("Code:");
                int code = scanner.nextInt();
                System.out.println("unit:");
                int unit = scanner.nextInt();
                System.out.println("Department:");
                String department = scanner.next();
                System.out.println("Teacher's Name:");
                while (true) {
                    String teacherName = scanner.next();
                    Teacher teacher1 = AllTeachers.get(0);
                    int flag = 0;
                    for (Teacher teacher2 : AllTeachers) {
                        if (teacher2.getName().equals(teacherName)) {
                            teacher1 = teacher2;
                            flag = 1;
                        }
                    }
                    if (flag == 1) {
                        Course course = new Course(name, code, unit, teacher1, department);
                        Allcourses.add(course);
                        teacher1.addCourse(course);
                        System.out.println("Course added successfully \n if you're done type \" exit \" else type your next operation");
                        break;
                    }
                    else
                        System.out.println("There is no Teacher with that name in this department.\n Try Again");
                }
                break;
            case "DeleteCourse":
                System.out.println("Enter the Course Name");
                name = scanner.next();
                Allcourses.removeIf(course1 -> course1.getName().equals(name));
                System.out.println("If the was such a course it's gone!");
                break;
            case "PrintStudents":
                for(Student student1 : AllStudents)
                    System.out.println(student1.getName());
                break;
            case "PrintTeachers":
                for (Teacher teacher1 : AllTeachers)
                    System.out.println(teacher1.getName());
                break;
            case "PrintCourses":
                for (Course course : Allcourses)
                    System.out.println(course.getName());
            case "Exit":
                return;
            default:
                System.out.println("Invalid operation");
        }
        operation = scanner.next();
        managerCLI(operation);
    }

    public static void teacherCLI(Teacher teacher, String operation){
        Scanner scanner = new Scanner(System.in);

        if (operation.equalsIgnoreCase("GiveScore")){
            System.out.println("Enter the course code");
            int code = scanner.nextInt();
            int flag = 0;
            Course course = Allcourses.get(0);
            for (Course course1 : Allcourses){
                if (course1.getCode() == code){
                    course = course1;
                    flag = 1;
                }
            }
            if (flag == 1){
                if (course.getTeacherName() == teacher.getName()){
                    for (Student student: course.getStudents()){
                        int index = course.getStudents().indexOf(student);
                        System.out.println("Student Name:" + student.getName() + "\n Current Score:" + course.getScores().get(index));
                        System.out.println("New Score:");
                        course.setScore(index, scanner.nextDouble());
                    }
                }
                else
                    System.out.println("You don't have this course.");    
            }
            else
                System.out.println("There's no course with this code.");
        }
        else if (operation.equalsIgnoreCase("StudentProfile")){
            System.out.println("Enter the Student ID");
            int studentID = scanner.nextInt();
            int flag = 0;

            outlook:
            for (Student student : AllStudents){
                if (student.getStudentID() == studentID) {
                    flag = 1;
                    student.printInformation();
                    break outlook;
                }
            }
            if (flag == 0)
                System.out.println("There's no student with this Student ID.");
        }
        else if (operation.equalsIgnoreCase("ChangePass")){
            System.out.println("Enter current Password:");
            while (true) {
                String currentPass = scanner.next();
                if (currentPass.equals(teacher.getPassword()))
                    break;
                else
                    System.out.println("Incorrect Password Try Again:");
            }
            System.out.println("Enter new Password:");
            String newPass = scanner.next();
            teacher.setPassword(newPass);
            System.out.println("Password changed successfully");
        }
        else if (operation.equalsIgnoreCase("Exit"))
            return;

        operation = scanner.next();
        teacherCLI(teacher, operation);
    }

    public static void studentCLI(Student student, String operation){
        Scanner scanner = new Scanner(System.in);

        if (operation.equalsIgnoreCase("AddCourse")){
            System.out.println("Enter Course code:");
            int code = scanner.nextInt();
            int flag = 0;
            for (Course course : Allcourses){
                if (course.getCode() == code){
                    student.addCourse(course);
                    course.addStudent(student);
                    System.out.println("You were added successfully");
                    flag = 1;
                }
            }
            if (flag == 0)
                System.out.println("There is no course with that code");
        }
        else if (operation.equalsIgnoreCase("DeleteCourse")){
            System.out.println("Enter Course code:");
            int code = scanner.nextInt();
            int flag = 0;
            for (Course course : student.getCourses()){
                if (course.getCode() == code){
                    student.removeCourse(course);
                    course.removeStudent(student);
                    System.out.println("You were deleted successfully");
                    flag = 1;
                }
            }
            if (flag == 0)
                System.out.println("There is no course with that code");
        }
        else if (operation.equalsIgnoreCase("Profile")){
            student.printInformation();
        }
        else if (operation.equalsIgnoreCase("CourseInformation")){
            System.out.println("Enter the course name:");
            String courseName = scanner.next();
            int flag = 0;
            for (Course course : Allcourses){
                if (course.getName().equals(courseName)) {
                    course.printInformation();
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                System.out.println("There is no course with that name !");
        }
        else if (operation.equalsIgnoreCase("Average")){
            System.out.println("Your Average is:" + student.calculateAverage());
        }
        else if (operation.equalsIgnoreCase("Exit"))
            return;
        else
            System.out.println("Invalid operation");

        operation = scanner.next();
        studentCLI(student, operation);
    }
}



