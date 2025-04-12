import java.util.*;

class Student {
    private String name;
    private int id;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

public class StudentManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Name can't be empty. Enter name: ");
            name = sc.nextLine().trim();
        }

        System.out.print("Enter ID: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID! Must be a number.");
            return;
        }

        Student s = new Student(name, id);
        students.add(s);
        System.out.println("Student Added.\n");
    }

    public static void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.\n");
            return;
        }

        System.out.println("All Students:");
        for (Student s : students) {
            s.display();
        }
        System.out.println();
    }

    public static void searchStudent() {
        System.out.print("Enter ID to Search: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.\n");
            return;
        }

        for (Student s : students) {
            if (s.getId() == id) {
                s.display();
                return;
            }
        }
        System.out.println("Student not found.\n");
    }

    public static void deleteStudent() {
        System.out.print("Enter ID to Delete: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.\n");
            return;
        }

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getId() == id) {
                it.remove();
                System.out.println("Student Deleted.\n");
                return;
            }
        }

        System.out.println("Student not found.\n");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= Student Management System =========");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            String input = sc.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }
}
