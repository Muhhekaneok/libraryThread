package justforfun.library2;

public class Book {
    private final String bookTitle;
    private final int bookCardNumber;
    public static int getBookCountPermit() {
        return 4;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getBookCardNumber() {
        return bookCardNumber;
    }

    public Book(String bookTitle, int bookCardNumber) {
        this.bookTitle = bookTitle;
        this.bookCardNumber = bookCardNumber;
    }
}