package library;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

  public void addUser(User user) {
    users.put(user.getName(), user);
  }

  public User getUser(String name) {
    return users.get(name);
  }

  public void addBook(Book book) { 
    books.put(book.getTitle(), book);
  }

  public boolean removeBook(String title) { 
    return books.remove(title) != null;
  }

  public Book getBook(String title) { 
    return books.get(title);
  }

  public void displayBooks() { 
    if (books.isEmpty()) {
      System.out.println("No books available.");
    } else {
      books.values().forEach(book -> book.displayInfo());
    }
  }


  public boolean borrowBook(String title, String userName) {
    Book book = books.get(title);
    if (book != null && book.isAvailable()) {
      book.setAvailable(false);
      List<Book> borrowedBooks = userBorrowedBooks.computeIfAbsent(userName, k -> new ArrayList<>());
      borrowedBooks.add(book);
      borrowedDates.put(book.getTitle(), LocalDate.now());
      return true;
    }
    return false;
  }

  
  public boolean returnBook(String title, String userName) {
    List<Book> borrowedBooks = userBorrowedBooks.get(userName);
    if (borrowedBooks != null) {
      for (Book book : borrowedBooks) {
        if (book.getTitle().equals(title)) {
          book.setAvailable(true); 
          borrowedBooks.remove(book);
          return true;
        }
      }
    }
    return false;
  }

  public List<BookDecorator> getBorrowedBooks(String userName) {
    List<Book> originalBorrowedBooks = userBorrowedBooks.getOrDefault(userName, Collections.emptyList());
    List<BookDecorator> decoratedBooks = new ArrayList<>();
    for (Book book : originalBorrowedBooks) {
      BookDecorator decoratedBook = new BookDecorator(book);
      LocalDate borrowedDate = borrowedDates.get(book.getTitle());
      if (borrowedDate != null && ChronoUnit.DAYS.between(borrowedDate, LocalDate.now()) > 3) {
        decoratedBook.setOverdue(true);
      }
      decoratedBooks.add(decoratedBook);
    }
    return decoratedBooks;
  }
}
