package library;

public class BookBuilder {
    private String title;
    private String author;
    private String publicationDate;
    private String isbn;

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public BookBuilder setISBN(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public Book build() {
        return new Book(title, author, publicationDate, isbn);
    }
}
