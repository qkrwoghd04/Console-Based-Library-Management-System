package LibrarySystem_Using_DesignPatterns;

import java.util.ArrayList;
import java.util.List;


// The Book class implements the Subject interface, making it observable by observers.
// It represents a book that can notify observers about its availability changes.
public class Book implements Subject {
    private List<Observer> observers = new ArrayList<>(); // Holds references to observers.
    private String title;
    private String author; 
    private String publicationDate; 
    private String isbn; 
    private boolean isAvailable;
    


    
    public Book(String title, String author, String publicationDate, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.isAvailable = true; 
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
