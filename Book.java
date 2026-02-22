import java.util.*;

public class Book {

    private String title;
    private String author;
    private String genre;
    private String lang;
    private int year;
    private int sold;

    private boolean isCheckedOut;
    private int dueDate; 

    private ArrayList<String> reserveList;     // max 3
    private ArrayList<String> checkoutHistory; 

    public static int totalNumOfBooks = 0;

    Book(String t, String a, String l, int y, int s, String g) {
        title = t;
        author = a;
        lang = l;
        year = y;
        sold = s;
        genre = g;

        isCheckedOut = false;
        dueDate = -1;

        reserveList = new ArrayList<>();
        checkoutHistory = new ArrayList<>();

        totalNumOfBooks++;
    }

    
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getLanguage() { return lang; }
    public int getYear() { return year; }
    public int getSales() { return sold; }
    public boolean isAvailable() { return !isCheckedOut; }
    public int getDueDate() { return dueDate; }

    public void printBookInfo() {
        System.out.println("\nTitle: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genre);
        System.out.println("Language: " + lang);
        System.out.println("Year: " + year);
        System.out.println("Sales (millions): " + sold);
        System.out.println("Available: " + !isCheckedOut);
    }

    public void printCheckoutHistory() {
        System.out.println("Previous Borrowers:");
        for (String name : checkoutHistory) {
            System.out.println(name);
        }
    }

    
    public void checkOutBook(String userName) {

        if (isCheckedOut) {
            System.out.println("Book is already checked out.");
            return;
        }

        isCheckedOut = true;
        dueDate = (int)(Math.random() * 7) + 7; // fake due date
        checkoutHistory.add(userName);

        System.out.println(title + " checked out. Due in " + dueDate + " days.");
    }
    public void returnBook() {

        isCheckedOut = false;
        dueDate = -1;

        System.out.println(title + " has been returned.");

        if (!reserveList.isEmpty()) {
            String nextUser = reserveList.remove(0);
            System.out.println("Text message sent to " + nextUser +
                    ". " + title + " is now available to be borrowed.");
        }
    }
    public void reserveBook(String userName) {

        if (reserveList.size() >= 3) {
            System.out.println("Reserve list full.");
            return;
        }

        reserveList.add(userName);
        System.out.println(userName + " added to reserve list for " + title);
    }

    public static void printBooksByAuthor(ArrayList<Book> books, String author) {
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author) && b.isAvailable()) {
                b.printBookInfo();
            }
        }
    }

    public static void printBooksByGenre(ArrayList<Book> books, String genre) {
        for (Book b : books) {
            if (b.getGenre().equalsIgnoreCase(genre) && b.isAvailable()) {
                b.printBookInfo();
            }
        }
    }
}
