import java.util.HashSet;
import java.util.Set;

public class Activity {

    private String name;
    private Set<Student> assignedStudents;

    public Activity(String name) {
        this.name = name;
        this.assignedStudents = new HashSet<Student>();
    }

    public String getName() {
        return name;
    }

    public Set<Student> getAssignedStudents() {
        return assignedStudents;
    }

    public void assignStudent(Student student) {
        assignedStudents.add(student);
    }

    public void unassignStudent(Student student) {
        assignedStudents.remove(student);
    }

    public boolean attendedBy(Student student) {
        return assignedStudents.contains(student);
    }

}
