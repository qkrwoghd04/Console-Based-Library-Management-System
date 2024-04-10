package library;

import java.util.HashMap;
import java.util.Map;

// Using singleton pattern 
// The constructor of the class is declared as private to prevent instantiation of the class from the outside
public class DatabaseConnection {
  private static DatabaseConnection instance;
  private Map<String, User> users;
  private Map<String, Book> books;

  private DatabaseConnection() {
    users = new HashMap<>();
    books = new HashMap<>(); // 초기화
  }

  public static DatabaseConnection getInstance() {
    if (instance == null) {
      instance = new DatabaseConnection();
    }
    return instance;
  }

  public void addUser(User user) {
    users.put(user.getName(), user);
  }

  public User getUser(String name) {
    return users.get(name);
  }

  public void addBook(Book book) { // 책 추가
    books.put(book.getTitle(), book);
  }

  public boolean removeBook(String title) { // 책 제거
    return books.remove(title) != null;
  }

  public Book getBook(String title) { // 책 조회
    return books.get(title);
  }

  public void displayBooks() { // 모든 책 목록 출력
    if (books.isEmpty()) {
      System.out.println("No books available.");
    } else {
      books.values().forEach(book -> book.displayInfo());
    }
  }
}
