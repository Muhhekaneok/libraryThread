package justforfun.library2;

public class BestsellerBook extends Book {
    private String bookTitle;
    private int bookCardNumber;

    public static int getBestsellerCountPermit() {
        return 1;
    }

    @Override
    public String getBookTitle() {
        return bookTitle;
    }

    public BestsellerBook(String bookTitle, int bookCardNumber) {
        super(bookTitle, bookCardNumber);
    }
}