
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

interface BookOperation {
    void perfom(ArrayList<Book> library);
}

class Book {
    String name;
    String author;
    Boolean available;

    public Book(String name, String author, Boolean available) {
        this.name = name;
        this.author = author;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(Boolean availbale) {
        this.available = availbale;
    }
}

class Addition implements BookOperation {
    
    Scanner scan = new Scanner(System.in);
    
    @Override public void perfom(ArrayList<Book> library) {
        System.out.println("Enter Book name: ");
        String name = scan.nextLine();
        System.out.println("Enter Book author: ");
        String author = scan.nextLine();
        Boolean available = true;

        Book book = new Book(name, author, available);

        library.add(book);
        
        
    }
}

class List implements BookOperation {
    @Override public void perfom(ArrayList<Book> library) {
        int length = library.size();

        for(int i = 0; i < length; i++) {
            System.out.println(i+1 + "- " + library.get(i).getName());
        }
    }
}

class Library {

    ArrayList<Book> library =  new ArrayList<>();

    public void perform(ArrayList<Book> library, BookOperation bookOperation) {
        if (bookOperation == null) {
            throw new InvalidParameterException("Cannot perform operation");
        }
        bookOperation.perfom(this.library);
    }
}

class Main {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    public static void main(String[] args) {
        int choice;
        Scanner scan = new Scanner(System.in);
        Library library = new Library();
        BookOperation addition = new Addition();
        BookOperation list = new List();


        loop: while (true) {
            System.out.println(ANSI_BLUE + "************************************* Choose an operation *************************************" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "1- ADD / 2- LIST (EXIT: 0)" + ANSI_RESET);

            choice = scan.nextInt();

            switch(choice) {
                case 1:
                library.perform(library.library, addition);
                    break;

                case 2:
                library.perform(library.library, list);
                    break;

                case 8: 
                    break loop;
                default:
                    throw new AssertionError("Invalid Option");
            }
           
        }
    }
}