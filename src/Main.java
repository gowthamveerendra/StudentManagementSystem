
import java.util.ArrayList;
import java.util.Scanner;

// Student class with encapsulation
class Student {
    private int id;
    private String name;
    private String branch;
    private double percentage;

    // Constructor
    public Student(int id, String name, String branch, double percentage) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.percentage = percentage;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public double getPercentage() {
        return percentage;
    }

    // Display student details
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Branch: " + branch + ", Percentage: " + percentage);
    }
}

// StudentManagement class with add, display, search, delete
class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();

    // Add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // View all students
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        for (Student s : students) {
            s.display();
        }
    }

    // Search student by ID
    public void searchStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.display();
                return;
            }
        }
        System.out.println("Student not found with ID: " + id);
    }

    // Delete student by ID
    public void deleteStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student not found with ID: " + id);
    }
}

// Main class with menu
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagement sm = new StudentManagement();
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Branch: ");
                    String branch = sc.nextLine();
                    System.out.print("Enter Percentage: ");
                    double percentage = sc.nextDouble();
                    sm.addStudent(new Student(id, name, branch, percentage));
                    break;
                case 2:
                    sm.viewAllStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();
                    sm.searchStudent(searchId);
                    break;
                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();
                    sm.deleteStudent(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}
