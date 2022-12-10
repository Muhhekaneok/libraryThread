package justforfun.library2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Library {
    List<Book> books = new ArrayList<>();
    List<Book> bestsellerBook = new ArrayList<>();

    public int getBooksCount() {
        return books.size();
    }

    public Library() {
        books.add(new Book("A Brief History of Time. Stephen Hawking", 1));
        books.add(new Book("Astrophysics for People in a Hurry. Neil deGrasse Tyson", 2));
        books.add(new Book("Spin Dictators. Sergei Guriev and Daniel Treisman", 3));
        books.add(new Book("The fifth essence: the search for dark matter in the universe. Lawrence Krauss", 4));
        books.add(new Book("The God Delusion. Richard Dawkins", 5));
        books.add(new Book("I, Robot. Isaac Asimov", 6));
        books.add(new Book("Code. Charles Petzold", 7));
        books.add(new Book("Effective Java. Joshua Bloch", 8));
        bestsellerBook.add(new Book("Piglet (Winnie-the-Pooh)", 10));
    }

    public Book readTheBestseller() {
        for (int i = 0; i < bestsellerBook.size(); i++) {
            bestsellerBook.set(0, new Book("Piglet (Winnie-the-Pooh)", 10));
        }
        return bestsellerBook.get(0);
    }

    public Book readSomeInterestingBook() {
        for (int i = 0; i < books.size(); i++) {
            books.set(0, new Book("A Brief History of Time. Stephen Hawking", 1));
            books.set(1, new Book("Astrophysics for People in a Hurry. Neil deGrasse Tyson", 2));
            books.set(2, new Book("Spin Dictators. Sergei Guriev and Daniel Treisman", 3));
            books.set(3, new Book("The fifth essence: the search for dark matter in the universe. Lawrence Krauss", 4));
            books.set(4, new Book("The God Delusion. Richard Dawkins", 5));
            books.set(5, new Book("I, Robot. Isaac Asimov", 6));
            books.set(6, new Book("Code. Charles Petzold", 7));
            books.set(7, new Book("Effective Java. Joshua Bloch", 8));
        }
        return books.get(new Random().nextInt(books.size()));
    }
}