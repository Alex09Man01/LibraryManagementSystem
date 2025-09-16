import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return isBorrowed; }

    public void borrowBook() {
        if(!isBorrowed) {
            isBorrowed = true;
            System.out.println("The book \"" + title + "\" has been borrowed.");
        } else {
            System.out.println("The book \"" + title + "\" is already borrowed.");
        }
    }

    public void returnBook() {
        if(isBorrowed) {
            isBorrowed = false;
            System.out.println("The book \"" + title + "\" has been returned.");
        } else {
            System.out.println("The book \"" + title + "\" was not borrowed.");
        }
    }

    @Override
    public String toString() {
        return title + " by " + author + (isBorrowed ? " (borrowed)" : " (available)");
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("The book \"" + title + "\" has been added.");
    }

    public void showBooks() {
        if(books.isEmpty()) {
            System.out.println("There are no books in the library!");
            return;
        }
        System.out.println("\n--- List of books ---");
        for(int i = 0; i < books.size(); i++) {
            System.out.println((i+1) + ". " + books.get(i));
        }
    }

    public void borrowBook(int index) {
        if(index >= 0 && index < books.size()) {
            books.get(index).borrowBook();
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void returnBook(int index) {
        if(index >= 0 && index < books.size()) {
            books.get(index).returnBook();
        } else {
            System.out.println("Invalid index!");
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        int choice;

        do {
            System.out.println("\n=== LIBRARY MENU ===");
            System.out.println("1. Add a book");
            System.out.println("2. Show all books");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Book title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    lib.addBook(title, author);
                    break;

                case 2:
                    lib.showBooks();
                    break;

                case 3:
                    lib.showBooks();
                    System.out.print("Enter the number of the book to borrow: ");
                    int idxBorrow = sc.nextInt() - 1;
                    lib.borrowBook(idxBorrow);
                    break;
                
                case 4:
                    lib.showBooks();
                    System.out.print("Enter the number of the book to return: ");
                    int idxReturn = sc.nextInt() - 1;
                    lib.returnBook(idxReturn);
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        } while(choice != 0);

        sc.close();
    } 
}
