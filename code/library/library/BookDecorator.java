package library;

public class BookDecorator {
    private Book book;
    private boolean isOverdue;

    public BookDecorator(Book book) {
        this.book = book;
        this.isOverdue = false; // 초기값은 연체되지 않음
    }

    // 연체 여부를 설정하는 메소드
    public void setOverdue(boolean isOverdue) {
        this.isOverdue = isOverdue;
    }

    // 연체 여부를 반환하는 메소드
    public boolean isOverdue() {
        return this.isOverdue;
    }

    // Book 클래스의 displayInfo 메소드를 확장하여 연체 정보도 출력
    public void displayInfo() {
        book.displayInfo();
        System.out.println("Overdue: " + (isOverdue ? "Yes" : "No"));
    }

    // Book 객체에 대한 getter 메소드, 필요에 따라 사용
    public Book getBook() {
        return book;
    }
}
