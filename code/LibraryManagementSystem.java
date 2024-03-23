import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library Management System");
        System.out.println("Register a new user");
        System.out.print("Enter user type (Student/Faculty): ");
        String userType = scanner.nextLine();

        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();

        // Factory Method를 사용하여 새 사용자 생성
        User newUser = userFactory.createUser(userType, userName);

        // Singleton DatabaseConnection 인스턴스를 사용하여 사용자 추가
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        dbConnection.addUser(newUser);

        System.out.println("User successfully registered:");
        newUser.displayInfo();

        scanner.close();
    }
}