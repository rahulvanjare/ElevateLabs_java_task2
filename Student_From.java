package Taks2;
import java.util.*;
public class Student_From {
	static Scanner sc = new Scanner(System.in);
	static List<Student> studentList = new ArrayList<>();
	
	public static void main(String[] args) {
		int choice ;
		
		do {
			System.out.println("\n--- Student Management System ---");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Update Studnet");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			System.out.println("Eneter Your Choice");
			
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				addStudent();
				break;
				
			case 2:
				viewStudents();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				deleteStudent();
				break;
			case 5:
				System.out.println("Thank you for using Student Managemant System!");
				break;
				
				default:
					System.out.println("Invalid choice ! Try Agin");			
			}
			
		}	while  (choice !=5);
	}	
	
	static void addStudent() {
		System.out.print("Eneter ID : ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter Name : ");
		String name = sc.nextLine();
		
		System.out.print("Enetr Marks : ");
		float marks = sc.nextFloat();
		
		Student student = new Student(id, marks, name);
		studentList.add(student);
		
		System.out.println("Student Add Successfully!");	
	}
	// 2. View All Students
    static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to show.");
        } else {
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    // 3. Update Student
    static void updateStudent() {
        System.out.print("Enter ID of student to update: ");
        int id = sc.nextInt();

        boolean found = false;
        for (Student s : studentList) {
            if (s.getId() == id) {
                sc.nextLine(); // consume newline
                System.out.print("Enter new name: ");
                String name = sc.nextLine();

                System.out.print("Enter new marks: ");
                float marks = sc.nextFloat();

                s.setName(name);
                s.setMarks(marks);
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // 4. Delete Student
    static void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        int id = sc.nextInt();

        Iterator<Student> iterator = studentList.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getId() == id) {
                iterator.remove();
                System.out.println("Student deleted successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}



