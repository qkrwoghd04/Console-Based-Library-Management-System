package library;

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
            scanner.nextLine();

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

        // Using Factory Method generate new user
        User newUser = UserFactory.createUser(userType, userName, phoneNum);

        // Using Singleton DatabaseConnection instance generate new user
        dbConnection.addUser(newUser);

        System.out.println("User successfully registered:");
        newUser.displayInfo();
    }

    private static void loginUser(Scanner scanner, DatabaseConnection dbConnection) {
        System.out.print("Enter user name for login: ");
        String userName = scanner.nextLine();
    
        System.out.print("Enter phone number: ");
        String phoneNum = scanner.nextLine().replace("-", "").replace(" ", "");
    
        User user = dbConnection.getUser(userName);
    
        if (user != null && user.getPhoneNum().equals(phoneNum)) {
            System.out.println("Login successful:");
            user.displayInfo();
            manageBooks(scanner, dbConnection, user); // 로그인한 사용자 객체를 함께 전달
        } else {
            System.out.println("Login failed: User not found or phone number does not match.");
        }
    }
    
    private static void manageBooks(Scanner scanner, DatabaseConnection dbConnection, User user) {
        // 사용자가 교직원(Faculty)일 때만 책 관리 메뉴를 보여줍니다.
        if (user instanceof Faculty) {
            while (true) {
                System.out.println("\n1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. View Books");
                System.out.println("4. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addBook(scanner, dbConnection);
                        break;
                    case 2:
                        removeBook(scanner, dbConnection);
                        break;
                    case 3:
                        dbConnection.displayBooks();
                        break;
                    case 4:
                        System.out.println("Logging out...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else if (user instanceof Student) {
            manageStudentActions(scanner, dbConnection, user);
        }
    }

    private static void manageStudentActions(Scanner scanner, DatabaseConnection dbConnection, User user) {
        // 학생(Student)이 수행할 수 있는 동작을 보여주는 메뉴
        while (true) {
            System.out.println("\n1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. View Borrowed Books");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // 학생이 책을 빌리는 기능을 구현
                    borrowBook(scanner, dbConnection, user);
                    break;
                case 2:
                    // 학생이 책을 반납하는 기능을 구현
                    returnBook(scanner, dbConnection, user);
                    break;
                case 3:
                    // 학생이 빌린 책을 보는 기능을 구현
                    viewBorrowedBooks(dbConnection, user);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook(Scanner scanner, DatabaseConnection dbConnection) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter publication date: ");
        String publicationDate = scanner.nextLine();
        System.out.print("Enter ISBN: "); // ISBN 입력 받기
        String isbn = scanner.nextLine();

        // ISBN 정보를 포함하여 새로운 Book 객체 생성
        Book book = new Book(title, author, publicationDate, isbn);
        dbConnection.addBook(book); // 생성된 Book 객체를 데이터베이스에 추가

        System.out.println("Book added successfully.");
    }

    private static void removeBook(Scanner scanner, DatabaseConnection dbConnection) {
        System.out.print("Enter book title to remove: ");
        String title = scanner.nextLine();

        if (dbConnection.removeBook(title)) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // borrowBook, returnBook, viewBorrowedBooks 메서드는 구현 필요
    // 예시를 위한 가상의 구현입니다.
    private static void borrowBook(Scanner scanner, DatabaseConnection dbConnection, User user) {
        // 학생이 책을 빌리는 로직 구현
    }

    private static void returnBook(Scanner scanner, DatabaseConnection dbConnection, User user) {
        // 학생이 책을 반납하는 로직 구현
    }

    private static void viewBorrowedBooks(DatabaseConnection dbConnection, User user) {
        // 학생이 빌린 책 목록을 보는 로직 구현
    }
}