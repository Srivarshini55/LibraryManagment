package library;

public class Book {
    int id;
    String title;
    String author;
    String category;
    String regulation; 
    boolean isBorrowed;

    public Book(int id, String title, String author, String category, String regulation, boolean isBorrowed) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.regulation = regulation;
        this.isBorrowed = isBorrowed;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | " + category + " | " + regulation + " | " + (isBorrowed ? "Borrowed" : "Available");
    }
}
