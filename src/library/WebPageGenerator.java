package library;

import java.io.*;
import java.util.List;

public class WebPageGenerator {

    public static void generate(List<Book> books) {
        try {
            File dir = new File("web");
            if (!dir.exists()) dir.mkdirs();

            FileWriter fw = new FileWriter("web/index.html");
            PrintWriter out = new PrintWriter(fw);

            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("    <meta charset='UTF-8'>");
            out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("    <title>Library Dashboard</title>");
            out.println("    <link rel='stylesheet' href='style.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <h1>📚 Library Dashboard</h1>");
            out.println("    <table>");
            out.println("        <tr><th>ID</th><th>Title</th><th>Author</th><th>Category</th><th>Status</th></tr>");

            for (Book b : books) {
                out.println("        <tr>");
                out.println("            <td>" + b.id + "</td>");
                out.println("            <td>" + b.title + "</td>");
                out.println("            <td>" + b.author + "</td>");
                out.println("            <td>" + b.category + "</td>");
                out.println("            <td>" + (b.isBorrowed ? "Borrowed" : "Available") + "</td>");
                out.println("        </tr>");
            }

            out.println("    </table>");
            out.println("</body>");
            out.println("</html>");

            out.close();
            fw.close();

            System.out.println(" Dashboard updated (web/index.html).");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
