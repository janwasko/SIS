import java.util.LinkedList;
import java.util.List;

public class Student implements Comparable<Student> {

    private int id;
    private String name;
    private String surname;
    private StudentType type;
    private List<Activity> activities;

    private static int nextId = 0;

    public Student(String name, String surname, StudentType type) {
        this.id = generateNextID();
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.activities = new LinkedList<Activity>();
    }

    public StudentType getType() {
        return type;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    private static int generateNextID() {
        return ++nextId;
    }

    @Override
    public int compareTo(Student o) {
        if (surname.compareTo(o.surname) == 0) {
            return name.compareTo(o.name);
        } else {
            return surname.compareTo(o.surname);
        }
    }

    public void assignTo(Activity activity) {
        activities.add(activity);
    }

    public void unassignFrom(Activity activity) {
        activities.remove(activity);
    }

    @Override
    public String toString() {
        String temp = "Student{" +
                      "id=" + id +
                      ", name='" + name + "'" +
                      ", surname='" + surname + "'" +
                      ", type=" + type +
                      ", activities=";
        for (int i = 0; i < activities.size(); i++) {
            Activity activity = activities.get(i);
            if (i == activities.size() - 1) {
                temp += "'" + activity.getName() + "'";
            } else {
                temp += "'" + activity.getName() + "'+";
            }
        }
        temp += "}";
        return temp;
    }

}