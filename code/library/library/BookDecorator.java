// package library;

// public abstract class BookDecorator implements Book {
//     protected Book decoratedBook;

//     public BookDecorator(Book decoratedBook) {
//         this.decoratedBook = decoratedBook;
//     }

//     public void borrow() {
//         decoratedBook.borrow();
//     }

//     // 기타 메서드 구현...
// }

// public class OverdueFeeDecorator extends BookDecorator {
//     private double fee;

//     public OverdueFeeDecorator(Book decoratedBook, double fee) {
//         super(decoratedBook);
//         this.fee = fee;
//     }

//     @Override
//     public void returnBook() {
//         System.out.println("Additional overdue fee: " + fee);
//         decoratedBook.returnBook();
//     }
// }
