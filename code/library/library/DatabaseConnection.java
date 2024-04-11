package library;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Using singleton pattern 
// The constructor of the class is declared as private to prevent instantiation of the class from the outside
public class DatabaseConnection {
  private static DatabaseConnection instance;
  private Map<String, User> users;
  private Map<String, Book> books;
  private Map<String, List<Book>> userBorrowedBooks = new HashMap<>();
  // DatabaseConnection 클래스 내에 추가
  private Map<String, LocalDate> borrowedDates = new HashMap<>();

  private DatabaseConnection() {
    users = new HashMap<>();
    books = new HashMap<>(); // 초기화
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

  // borrowBook 메소드 수정
  public boolean borrowBook(String title, String userName) {
    Book book = books.get(title);
    if (book != null && book.isAvailable()) {
      book.setAvailable(false);
      List<Book> borrowedBooks = userBorrowedBooks.computeIfAbsent(userName, k -> new ArrayList<>());
      borrowedBooks.add(book);
      borrowedDates.put(book.getTitle(), LocalDate.now()); // 책을 빌린 날짜 기록
      return true;
    }
    return false;
  }

  // 책 반납
  public boolean returnBook(String title, String userName) {
    List<Book> borrowedBooks = userBorrowedBooks.get(userName);
    if (borrowedBooks != null) {
      for (Book book : borrowedBooks) {
        if (book.getTitle().equals(title)) {
          book.setAvailable(true); // 책을 대출 가능 상태로 변경
          borrowedBooks.remove(book);
          return true;
        }
      }
    }
    return false;
  }

  // getBorrowedBooks 메소드 수정
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
