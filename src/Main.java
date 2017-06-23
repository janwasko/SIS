public class Main {

    public static void main(String[] args) {

        University university = new University();

        Student s1 = university.addStudent("Jan", "Wasko", StudentType.STATIONARY);
        Student s2 = university.addStudent("Tom", "Smith", StudentType.NONSTATIONARY);
        Student s3 = university.addStudent("Ewa", "Nowak", StudentType.POSTGRADUATE);
        Student s4 = university.addStudent("Ron", "Adams", StudentType.POSTGRADUATE);
        Student s5 = university.addStudent("Tim", "Jones", StudentType.STATIONARY);

        Activity a1 = university.addActivity("Java");
        Activity a2 = university.addActivity("C");
        Activity a3 = university.addActivity("Pascal");

        System.out.println("---Current students:");
        university.printStudents();

        university.assignStudent(s1, a1);
        university.assignStudent(s2, a1);
        university.assignStudent(s3, a1);
        university.assignStudent(s3, a2);
        university.assignStudent(s4, a3);

        System.out.println("---Assigned students:");
        university.printStudents();

        university.removeStudent(s1);

        System.out.println("---Current students (one expelled):");
        university.printStudents();

        System.out.println("---Student s2 attends activity a2.");
        System.out.println(university.attendsActivity(s2, a2));
        System.out.println("---Student s3 attends activity a1.");
        System.out.println(university.attendsActivity(s3, a1));

        System.out.println("---Unassigned students:");
        System.out.println(university.getUnassignedStudents());

        System.out.println("---Students attending 1 activity:");
        System.out.println(university.getStuddentsAttendingActivities(1));
        System.out.println("---Students attending 2 activities:");
        System.out.println(university.getStuddentsAttendingActivities(2));

        System.out.println("---Student attending most activities:");
        System.out.println(university.getStudentAttendingMostActivities());

        System.out.println("---Number of students by type:");
        System.out.println(university.getNumberOfStudentsByType());

        System.out.println("---There is a student attending both a1 and a2.");
        System.out.println(university.getStudentsAttendingSameActivities(a1, a2));
        System.out.println("---There is a student attending both a2 and a3.");
        System.out.println(university.getStudentsAttendingSameActivities(a2, a3));

    }
}
