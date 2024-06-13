package LibrarySystem_Using_DesignPatterns;

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


    public boolean isOverdue() {
        return this.isOverdue;
    }

    public void displayInfo() {
        book.displayInfo();
        System.out.println("Overdue: " + (isOverdue ? "Yes" : "No"));
    }

   
    public Book getBook() {
        return book;
    }
}

