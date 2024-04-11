## Console-Based Library Management System(LMS)

### 1. How to run java code on cmd
### Step 1:
#### Compile whole java classes in library package
<img width="736" alt="1" src="https://github.com/qkrwoghd04/Console-Based-Library-Management-System/assets/122519801/ede69e30-50dc-4468-8874-0c7e43a4dd1c">

### Step 2:
#### Using "-cp ." command
#### When using the "-cp ." option, it instructs the Java runtime environment to include the current directory in the classpath. This allows Java programs to recognize and use .class files located in the current directory
<img width="734" alt="2" src="https://github.com/qkrwoghd04/Console-Based-Library-Management-System/assets/122519801/a4ebb2a7-957c-4dd8-b6fe-2cb906f13d33">

### 2. Design Patterns for LMS
### Singleton Pattern for Database class
```Java
// The DatabaseConnection class implements the Singleton Design Pattern.
// It ensures that only one instance of the DatabaseConnection class can exist.
public class DatabaseConnection {
  private static DatabaseConnection instance;
  private Map<String, User> users;
  private Map<String, Book> books;
  private Map<String, List<Book>> userBorrowedBooks = new HashMap<>();
  private Map<String, LocalDate> borrowedDates = new HashMap<>();

  private DatabaseConnection() {
    users = new HashMap<>();
    books = new HashMap<>(); 
    userBorrowedBooks = new HashMap<>();
  }

  public static DatabaseConnection getInstance() {
    if (instance == null) {
      instance = new DatabaseConnection();
    }
    return instance;
  }

```
### Factory Pattern for User class
```Java
// The UserFactory class implements the Factory Design Pattern.
// It provides a static method to create objects of User subclasses (Student or Faculty) based on the type parameter.
class UserFactory{
  // This static method creates and returns User objects.
  // The type of User object (Student or Faculty) depends on the type argument.
  public static User createUser(String type, String name, String phoneNum){
    switch(type.toLowerCase()){
      case "student":
        return new Student(name, phoneNum);

      case "faculty":
        return new Faculty(name, phoneNum);
        
      default:
        throw new IllegalArgumentException("Unknown user type.");
    }
  }
}
```

### Decorator Pattern for managing **overdue books**
```Java
// BookDecorator class serves as a decorator for the Book class. It follows the Decorator Pattern,
// allowing dynamic addition of new behaviors (in this case, tracking overdue status) to Book objects.
public class BookDecorator {
    private Book book;
    private boolean isOverdue;

    // Constructor wraps a Book object, enabling dynamic extension of its behavior without modifying the original class
    public BookDecorator(Book book) {
        this.book = book;
        this.isOverdue = false; 
    }

    
    public void setOverdue(boolean isOverdue) {
        this.isOverdue = isOverdue;
    }
```

### Observer Pattern for state changes
```Java
// The Observer interface declares the update method that is called by the subject.
// Observers implement this interface to react to changes in the subject's state.
public interface Observer {
    void update(String availability);
}

// The Subject interface declares a set of methods for managing observers.
// It allows subjects to register, remove, and notify observers about the state changes.
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
```
