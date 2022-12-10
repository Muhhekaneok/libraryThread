package justforfun.library2;

import java.util.concurrent.Semaphore;

/**
 * Написать программу, моделирующую работу библиотеки. В библиотеке доступны к чтению несколько книг.
 * Некоторые из них можно выдавать на руки, некоторые только в читальный зал.
 * Посетители могут брать одновременно по несколько книг на руки и в читальный зал.
 * Использовать можно все знания из Java, включая многопоточность.
 */

// Не получилось реализовать как хотел изначально. Тема весьма непростая :)
// - вылетал stackoverflow.
// - иногда получается, что 2 потока читают одну и ту же книгу
// В итоге реализовал не по условию задачи.
// Также мой пример можно назвать "дурно пахнущим кодом".
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        int booksCount = library.getBooksCount();
        Book bestSeller = library.readTheBestseller();
        Semaphore semaphoreForBestseller = new Semaphore(BestsellerBook.getBestsellerCountPermit());
        for (int i = 0; i < booksCount; i++) {
            final int number = i;
            new Thread(() -> {
                try {
                    System.out.println("sem1--> PERSON №" + (number + 1) + " came to the library");
                    semaphoreForBestseller.acquire();
                    System.out.println("<>PERSON №" + (number + 1) + " is occupied the BESTSELLER \"" + library.readTheBestseller().getBookTitle() + "\"...\n" +
                            "<>...person №" + (number + 1) + " starts reading the famous book. The book is very interesting. It takes a long time...<>");
                    Thread.sleep(1500);
                    System.out.println("<>PERSON №" + (number + 1) + " is ending reading the famous book" + bestSeller.getBookTitle() + "\n" +
                            "<>...the BESTSELLER is free for using...<>");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("<>happy PERSON №" + (number + 1) + " leave the library s1-->");
                    semaphoreForBestseller.release();
                }
            }).start();
        }

        Semaphore semaphoreForOtherBooks = new Semaphore(Book.getBookCountPermit());
        for (int i = 0; i < booksCount; i++) {
            final int number = i;
            new Thread(() -> {
                try {
                    System.out.println("sem2--> person №" + (number + 1) + " came to the library");
                    semaphoreForOtherBooks.acquire();
                    System.out.println("person №" + (number + 1) + " take \"" + library.readSomeInterestingBook().getBookTitle() + "\"...\n" +
                            "   person №" + (number + 1) + " starts reading this book");
                    Thread.sleep(800);
                    System.out.println("   person №" + (number + 1) + " is ending reading" + library.readSomeInterestingBook().getBookTitle() + "\n" +
                            "   the book \"" + library.readSomeInterestingBook().getBookTitle() + "\" is free now");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("person №" + (number + 1) + " is waiting for bestseller now...");
                    semaphoreForOtherBooks.release();
                }
            }).start();
        }
    }
}
