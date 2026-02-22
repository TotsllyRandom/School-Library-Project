import java.util.*;
import java.io.*;

public class Library {

    public static Scanner kgb = new Scanner(System.in);

    public static String Username = null;
    public static int UserID = -1;

    //library ArraryList - "CruiseBoat"
    //Users arraylist - "PeopleOnDaCruiseBoat"
    public static ArrayList<Book> CruiseBoat = new ArrayList<>();
    public static ArrayList<Manofbooks> PeopleOnDaCruiseBoat = new ArrayList<>();



    public static void CreateBooks() throws IOException {

        Scanner fileScanner = new Scanner(new File("library_books_v2.txt"));

        while (fileScanner.hasNext()) {
            CruiseBoat.add(new Book(fileScanner.next(), fileScanner.next(), fileScanner.next(), fileScanner.nextInt(), fileScanner.nextInt(), fileScanner.next()));
        }

        fileScanner.close();
    }




    public static boolean FindUserbyName(String name) {

        for (int i = 0; i < PeopleOnDaCruiseBoat.size(); i++) {
            if (PeopleOnDaCruiseBoat.get(i).getName().equalsIgnoreCase(name)) {
                UserID = i;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        CreateBooks();

        int input = 0;

        while (Username == null) {

            System.out.println("\nWelcome to the DLS (Digital Library System)");
            System.out.println("[1] Log in via name");
            System.out.println("[2] Search for book as guest");

            input = kgb.nextInt();

            if (input == 1) {

                System.out.print("Enter your name: ");
                Username = kgb.next();

                if (FindUserbyName(Username)) {
                    System.out.println("Signing in...");
                } else {
                    System.out.print("Enter email to register: ");
                    String email = kgb.next();
                    PeopleOnDaCruiseBoat.add(new Manofbooks(Username, email));
                    UserID = PeopleOnDaCruiseBoat.size() - 1;
                }

            } else if (input == 2) {
                Username = "Guest";
                System.out.println("Browsing as Guest.\n\n hi mr l this doesnt work i didnt wanna add this i got lazy sorry\n\n");
            }
        }

        if (!Username.equals("Guest")) {

            Manofbooks currentUser = PeopleOnDaCruiseBoat.get(UserID);

            CruiseBoat.get(0).printBookInfo();
            currentUser.checkoutBook(0);
            currentUser.reserveBook(1);
            currentUser.returnBook(0);
        }

        System.out.println("Total Books: " + Book.totalNumOfBooks);
    }
}
