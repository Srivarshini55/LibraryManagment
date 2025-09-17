package library;

import java.util.*;

public class Library {
    private static List<Book> books = new ArrayList<>();
    public static void addBook(Book book, boolean silent) {
        for (Book b : books) {
            if (b.id == book.id) {
                if (!silent) System.out.println(" Book ID already exists!");
                return;
            }
        }
        if (book.title.isEmpty() || book.author.isEmpty() || book.category.isEmpty() || book.regulation.isEmpty()) {
            if (!silent) System.out.println("All fields are required!");
            return;
        }
        books.add(book);
        if (!silent) System.out.println(" Book added successfully!");
    }
    public static void addBook(Book book) {
        addBook(book, false);
    }
    public static void searchBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                System.out.println("Book Found: " + b);
                return;
            }
        }
        System.out.println(" Book not found!");
    }
    public static void deleteBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                books.remove(b);
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }
    public static void borrowBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                if (!b.isBorrowed) {
                    b.isBorrowed = true;
                    System.out.println("Book borrowed successfully!");
                } else {
                    System.out.println("Book already borrowed!");
                }
                return;
            }
        }
        System.out.println(" Book not found!");
    }
    public static void returnBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                if (b.isBorrowed) {
                    b.isBorrowed = false;
                    System.out.println(" Book returned successfully!");
                } else {
                    System.out.println(" Book was not borrowed!");
                }
                return;
            }
        }
        System.out.println(" Book not found!");
    }
    public static void showAllBooks() {
        System.out.println("\n===== All Books =====");
        for (Book b : books) {
            System.out.println(b);
        }
    }
    public static List<Book> getAllBooks() {
        return books;
    }
}
