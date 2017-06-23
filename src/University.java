import java.util.*;

public class University {

    private List<Student> students;
    private List<Activity> activities;

    public University() {
        this.students = new LinkedList<Student>();
        this.activities = new LinkedList<Activity>();
    }

    public Student addStudent(String name, String surname, StudentType type) {
        Student student = new Student(name, surname, type);
        students.add(student);
        return student;
    }

    public Activity addActivity(String name) {
        Activity activity = new Activity(name);
        activities.add(activity);
        return activity;
    }

    public void assignStudent(Student student, Activity activity) {
        student.assignTo(activity);
        activity.assignStudent(student);
    }

    public void removeStudent(Student student) {
        for (Activity activity : activities) {
            student.unassignFrom(activity);
            activity.unassignStudent(student);
        }
        students.remove(student);
    }

    public boolean attendsActivity(Student student, Activity activity) {
        return activity.attendedBy(student);
    }

    public Queue<Student> getUnassignedStudents() {
        Queue<Student> unassingnedStudents = new LinkedList<>();
        for (Student student : students) {
            if (student.getActivities().isEmpty()) {
                unassingnedStudents.add(student);
            }
        }
        return unassingnedStudents;
    }

    public Stack<Student> getStuddentsAttendingActivities(int n) {
        Stack<Student> stack = new Stack<>();
        for (Student student : students) {
            if (student.getActivities().size() == n) {
                stack.add(student);
            }
        }
        return stack;
    }

    public Student getStudentAttendingMostActivities() {
        return Collections.max(students, (student1, student2) -> Integer.compare(student1.getActivities().size(), student2.getActivities().size()));
    }

    public HashMap<StudentType, Integer> getNumberOfStudentsByType() {
        HashMap<StudentType, Integer> map = new HashMap<>();
        for (Student student : students) {
            if (map.get(student.getType()) == null) {
                map.put(student.getType(), 1);
            } else {
                map.put(student.getType(), map.get(student.getType()) + 1);
            }
        }
        return map;
    }

    public void printStudents() {
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public boolean getStudentsAttendingSameActivities(Activity activity1, Activity activity2) {
        return !Collections.disjoint(activity1.getAssignedStudents(), activity2.getAssignedStudents());
    }

}
