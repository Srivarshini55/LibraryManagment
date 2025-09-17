package library;

import java.awt.Desktop;
import java.io.*;
import java.util.*;

public class Main {

    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        users.put("admin", "1234");
        users.put("Sri", "Sri@123");
        users.put("23bcs075", "Sri@123");
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("===== Library Login =====");
            System.out.print("Username: ");
            String user = sc.nextLine().trim();
            System.out.print("Password: ");
            String pass = sc.nextLine().trim();
            if (users.containsKey(user) && users.get(user).equals(pass)) {
                loggedIn = true;
                System.out.println("Login successful!\n");
            } else {
                System.out.println("Invalid credentials. Try again.\n");
            }
        }
        preloadBooks();
        WebPageGenerator.generate(Library.getAllBooks());
        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Show All Books");
            System.out.println("7. Open Dashboard");
            System.out.println("8. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter Regulation: ");
                    String regulation = sc.nextLine();
                    Book newBook = new Book(id, title, author, category, regulation, false);
                    Library.addBook(newBook);
                    WebPageGenerator.generate(Library.getAllBooks());
                    break;
                    
                case 2:
                    System.out.print("Enter Book ID: ");
                    Library.searchBook(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    Library.deleteBook(sc.nextInt());
                    WebPageGenerator.generate(Library.getAllBooks());
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    Library.borrowBook(sc.nextInt());
                    WebPageGenerator.generate(Library.getAllBooks());
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    Library.returnBook(sc.nextInt());
                    WebPageGenerator.generate(Library.getAllBooks());
                    break;

                case 6:
                    Library.showAllBooks();
                    break;

                case 7:
                    openDashboard();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void preloadBooks() {
        String[] titles = {
            "Java Basics","Python Guide","HTML & CSS","Data Structures","Algorithms",
            "C Programming","DBMS Concepts","Operating Systems","Networking","Software Testing",
            "Machine Learning","AI Fundamentals","Web Dev","Data Science","Java Advanced",
            "Spring Boot","Hibernate","Microservices","React JS","Node JS",
            "Angular","Docker","Kubernetes","Git & GitHub","Cloud Computing",
            "Cyber Security","Big Data","Blockchain","IoT","Flutter Development"
        };

        String[] authors = {
            "James Gosling","Guido van Rossum","Jon Duckett","Robert Lafore","Thomas H. Cormen",
            "Dennis Ritchie","Raghu Ramakrishnan","Silberschatz","Andrew S. Tanenbaum","Glenford Myers",
            "Tom Mitchell","Stuart Russell","Colt Steele","Joel Grus","Herbert Schildt",
            "Craig Walls","Gavin King","Sam Newman","Alex Banks","Brad Dayley",
            "Misko Hevery","Nigel Poulton","Brendan Burns","Scott Chacon","Thomas Erl",
            "William Stallings","Viktor Mayer-Schönberger","Daniel Drescher","Arshdeep Bahga","Marco L. Napoli"
        };

        String[] categories = {
            "Programming","Programming","Web","CS","CS",
            "Programming","DB","OS","Networking","Testing",
            "AI","AI","Web","Data","Programming",
            "Framework","Framework","Web","Web","Web",
            "Web","DevOps","DevOps","VCS","Cloud",
            "Security","Data","Blockchain","IoT","Mobile"
        };

        String[] regulations = {
            "R2021","R2021","R2017","R2021","R2017",
            "R2021","R2021","R2017","R2017","R2021",
            "R2021","R2017","R2021","R2017","R2021",
            "R2021","R2021","R2017","R2021","R2017",
            "R2021","R2021","R2017","R2021","R2017",
            "R2021","R2017","R2021","R2021","R2017"
        };

        List<Book> existing = Library.getAllBooks();
        int nextId = existing.size() + 1;

        for (int i = existing.size(); i < 30; i++) {
            Library.addBook(new Book(nextId++, titles[i], authors[i], categories[i], regulations[i], false), true);
        }
    }

    public static void openDashboard() {
        try {
            File htmlFile = new File("web/index.html");
            if (htmlFile.exists())
                Desktop.getDesktop().browse(htmlFile.toURI());
            else
                System.out.println("Dashboard not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
