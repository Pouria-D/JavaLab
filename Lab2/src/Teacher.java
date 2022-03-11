import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String name;
    private String username;
    private String password;
    private List<Course> courses = new ArrayList<>();

    public Teacher(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }
    public String getName(){ return name;}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public List<Course> getCourses() { return courses; }

    public void setPassword(String password) {
        this.password = password;
    }
}
