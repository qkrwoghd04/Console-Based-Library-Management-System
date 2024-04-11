package library;

import java.util.ArrayList;
import java.util.List;


public class Book implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String title;
    private String author; // 저자 정보 추가
    private String publicationDate; // 출판일 정보 추가
    private String isbn; // ISBN 정보 추가
    private boolean isAvailable;
    


    // 생성자에 저자, 출판일, ISBN 파라미터 추가
    public Book(String title, String author, String publicationDate, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.isAvailable = true; // 초기 상태는 대출 가능으로 가정
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.isAvailable ? "Available" : "Not Available");
        }
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
        notifyObservers();
    }

    // 책 정보를 출력하는 메서드에 저자, 출판일, ISBN 정보 출력 추가
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Date: " + publicationDate);
        System.out.println("ISBN: " + isbn);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

}
