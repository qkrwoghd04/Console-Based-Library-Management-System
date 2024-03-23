import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();

        while (true) {
            System.out.println("\nWelcome to the Library Management System");
            System.out.println("1. Register a new user");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 숫자 입력 후 남은 개행문자 제거

            switch (choice) {
                case 1:
                    registerUser(scanner, dbConnection);
                    break;
                case 2:
                    loginUser(scanner, dbConnection);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerUser(Scanner scanner, DatabaseConnection dbConnection) {
        System.out.print("Enter user type (Student/Faculty): ");
        String userType = scanner.nextLine();

        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNum = scanner.nextLine().replace("-", "").replace(" ", "");

        // Factory Method를 사용하여 새 사용자 생성
        User newUser = UserFactory.createUser(userType, userName, phoneNum);

        // Singleton DatabaseConnection 인스턴스를 사용하여 사용자 추가
        dbConnection.addUser(newUser);

        System.out.println("User successfully registered:");
        newUser.displayInfo();
    }

    private static void loginUser(Scanner scanner, DatabaseConnection dbConnection) {
        System.out.print("Enter user name for login: ");
        String userName = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNum = scanner.nextLine().replace("-", "").replace(" ", "");

        // 데이터베이스에서 사용자 검색
        User user = dbConnection.getUser(userName);

        if (user != null && user.getPhoneNum().equals(phoneNum)) {
            System.out.println("Login successful:");
            user.displayInfo();
            manageBooks(scanner, dbConnection);
        } else {
            System.out.println("Login failed: User not found or phone number does not match.");
        }
    }
    private static void manageBooks(Scanner scanner, DatabaseConnection dbConnection) {
        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View Books");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 숫자 입력 후 남은 개행문자 제거
    
            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    // String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    // String author = scanner.nextLine();
                    // dbConnection.addBook(new Book(title, author));
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter book title to remove: ");
                    // title = scanner.nextLine();
                    // if (dbConnection.removeBook(title)) {
                    //     System.out.println("Book removed successfully.");
                    // } else {
                    //     System.out.println("Book not found.");
                    // }
                    break;
                case 3:
                    System.out.println("Listing all books:");
                    // dbConnection.displayBooks();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
}