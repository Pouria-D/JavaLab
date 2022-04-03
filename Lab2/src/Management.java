import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {
    static List<Student> AllStudents = new ArrayList<>();
    static List<Teacher> AllTeachers = new ArrayList<>();
    static List<Course> AllCourses = new ArrayList<>();

    public static void main(String[] args) {
        Initialize();
        CLI();
    }

    public static void Initialize(){
        Teacher teacher = new Teacher("Fatemi", "12340","12345");
        Teacher teacher1 = new Teacher("Fanai", "12341","12345");
        Teacher teacher2 = new Teacher("Naebi","12342","12345");
        AllTeachers.add(teacher);AllTeachers.add(teacher1);AllTeachers.add(teacher2);

        Course course = new Course("Statistics",25000,3,teacher2,"Electric");
        Course course1 = new Course("Learning",25001,3,teacher,"computer");
        Course course2 = new Course("Math1",22000,4,teacher1,"Math");
        AllCourses.add(course);
        AllCourses.add(course1);
        AllCourses.add(course2);

        Student student = new Student(96106485,"Pouria","Dadkhah","1272974421","Electric");
        Student student1 = new Student(96106486,"Ali","Hoseini","1270000000","Computer");
        Student student2 = new Student(96106487,"Reza", "zarei","1270000001","Math");
        Student student3 = new Student(96106488, "Danial", "Ehsani", "1270000002","Physics");
        Student student4 = new Student(96106489,"Mohammad", "Karimi", "1270000003","Electric");
        Student student5 = new Student(96106490, "Hosein", "Kiani", "1270000004", "Computer");
        AllStudents.add(student);AllStudents.add(student1);AllStudents.add(student2);AllStudents.add(student3);
        AllStudents.add(student4);AllStudents.add(student5);

        student.addCourse(course);student.addCourse(course1);student.addCourse(course2);
        student1.addCourse(course1);student1.addCourse(course2);
        student2.addCourse(course);student2.addCourse(course1);
        student3.addCourse(course1);student3.addCourse(course);
        student4.addCourse(course2);
        student5.addCourse(course1);
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
                        Teacher teacher = new Teacher("","","");
                        int flag = 0;
                        for (Teacher teacher1 : AllTeachers) {
                            if (teacher1.getUsername().equals(username) && teacher1.getPassword().equals(password)){
                                teacher = teacher1;
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1){
                            System.out.println("Welcom to Dr." + teacher.getName() + " Portal \n you can do these actions by typing them : \n" +
                                    "Give students of your course's grade \n watch your student's profile \n change your password \n " +
                                    "Now type the action that you want to do");
                            String operation = scanner.next();
                            teacherCLI(teacher, operation);
                        }
                        else
                            System.out.println("Username or Password is wrong Try logging on again");

                        break;
                    case "3":
                        Student student = new Student(0,"","","","");
                        flag = 0;
                        for (Student student1 : AllStudents) {
                            if (student1.getStudentID() == Integer.parseInt(username) && student1.getNationalID().equals(password)){
                                student = student1;
                                flag = 1;
                                break;
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
                    Teacher teacher1 = new Teacher("","","");
                    int flag = 0;
                    for (Teacher teacher2 : AllTeachers) {
                        if (teacher2.getName().equals(teacherName)) {
                            teacher1 = teacher2;
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1) {
                        Course course = new Course(name, code, unit, teacher1, department);
                        AllCourses.add(course);
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
                AllCourses.removeIf(course1 -> course1.getName().equals(name));
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
                for (Course course : AllCourses)
                    System.out.println(course.getName());
                break;
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
            Course course = new Course("",0,0,teacher,"");
            for (Course course1 : teacher.getCourses()){
                if (course1.getCode() == code){
                    course = course1;
                    flag = 1;
                    break;
                }
            }
            if (flag == 1){
                for (Student student: course.getStudents()){
                    int index = course.getStudents().indexOf(student);
                    System.out.println("Student Name:" + student.getName() + "\n Current Score:" + course.getScores().get(index));
                    System.out.println("New Score:");
                    course.setScore(index, scanner.nextDouble());
                }
                System.out.println("End Of Students!");
            }
            else
                System.out.println("You don't have this course");
        }
        else if (operation.equalsIgnoreCase("StudentProfile")){
            System.out.println("Enter the Student ID");
            int studentID = scanner.nextInt();
            int flag = 0;

            outlook:
            for (Course course : teacher.getCourses())
                for (Student student : course.getStudents()){
                    if (student.getStudentID() == studentID) {
                        student.printInformation();
                        flag = 1;
                        break outlook;
                    }
                }
            if (flag == 0)
                System.out.println("You don't have this student");
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
        else
            System.out.println("Invalid Operation");

        operation = scanner.next();
        teacherCLI(teacher, operation);
    }

    public static void studentCLI(Student student, String operation){
        Scanner scanner = new Scanner(System.in);

        if (operation.equalsIgnoreCase("AddCourse")){
            System.out.println("Enter Course code:");
            int code = scanner.nextInt();
            int flag = 0;
            for (Course course : AllCourses){
                if (course.getCode() == code){
                    student.addCourse(course);
                    System.out.println("You were added successfully");
                    flag = 1;
                    break;
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
                    System.out.println("You were Deleted successfully");
                    flag = 1;
                    break;
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
            for (Course course : AllCourses){
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
        else if (operation.equalsIgnoreCase("CourseList")){
            System.out.println("You have registered in these courses:\n" + student.getCourses());
        }
        else if (operation.equalsIgnoreCase("Exit"))
            return;
        else
            System.out.println("Invalid operation");

        operation = scanner.next();
        studentCLI(student, operation);
    }
}



