import java.util.*;

public class Manofbooks {

    private String name;
    private String email;

    private ArrayList<Book> borrowedBooks;
    private ArrayList<Book> reservedBooks;

    Manofbooks(String na, String e) {
        name = na;
        email = e;
        borrowedBooks = new ArrayList<>();
        reservedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getEmail() { return email; }

    public void updateEmail(String newEmail) {
        email = newEmail;
        System.out.println("Email updated.");
    }





    public void checkoutBook(int index) {

        if (borrowedBooks.size() >= 3) {
            System.out.println("Cannot borrow more than 3 books.");
            return;
        }

        Book b = Library.CruiseBoat.get(index);

        if (!b.isAvailable()) {
            System.out.println("Book unavailable.");
            return;
        }

        borrowedBooks.add(b);
        b.checkOutBook(name);
    }


    public void returnBook(int index) {

        Book b = borrowedBooks.get(index);
        borrowedBooks.remove(index);
        b.returnBook();
    }
    public void reserveBook(int index) {

        if (reservedBooks.size() >= 3) {
            System.out.println("Cannot reserve more than 3 books.");
            return;
        }

        Book b = Library.CruiseBoat.get(index);

        reservedBooks.add(b);
        b.reserveBook(name);
    }
}
