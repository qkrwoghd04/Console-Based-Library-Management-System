package LibrarySystem_Using_DesignPatterns;

import java.util.Scanner;
import java.util.List;

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
            manageBooks(scanner, dbConnection, user); 
        } else {
            System.out.println("Login failed: User not found or phone number does not match.");
        }
    }

    private static void manageBooks(Scanner scanner, DatabaseConnection dbConnection, User user) {
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
                    borrowBook(scanner, dbConnection, user);
                    break;
                case 2:
                    returnBook(scanner, dbConnection, user);
                    break;
                case 3:
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
        System.out.print("Enter ISBN: "); 
        String isbn = scanner.nextLine();

        
        Book book = new Book(title, author, publicationDate, isbn);
        dbConnection.addBook(book);

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

    private static void borrowBook(Scanner scanner, DatabaseConnection dbConnection, User user) {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine();
        if (dbConnection.borrowBook(title, user.getName())) {
            System.out.println(title + " has been borrowed successfully.");
        } else {
            System.out.println("Failed to borrow " + title + ".");
        }
    }

    private static void returnBook(Scanner scanner, DatabaseConnection dbConnection, User user) {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();
        if (dbConnection.returnBook(title, user.getName())) {
            System.out.println(title + " has been returned successfully.");
        } else {
            System.out.println("Failed to return " + title + ".");
        }
    }

    private static void viewBorrowedBooks(DatabaseConnection dbConnection, User user) {
        List<BookDecorator> borrowedBooks = dbConnection.getBorrowedBooks(user.getName());
        if (borrowedBooks.isEmpty()) {
            System.out.println("You have not borrowed any books.");
        } else {
            System.out.println("Borrowed Books:");
            for (BookDecorator bookDecorator : borrowedBooks) {
                bookDecorator.displayInfo();
            }
        }
    }

}