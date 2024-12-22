import java.util.ArrayList;
import java.util.Scanner;

public class Library implements BookService, UserInput {
    private final ArrayList<Book> library =  new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    
    // getters & setters
    public ArrayList<Book> getLibrary() {
        return library;
    }

    //handle add book
    @Override
    public void add() {
        System.out.println("Enter Book name: ");
        String name = scan.nextLine();
        System.out.println("Enter Book author: ");
        String author = scan.nextLine();

        Book book = new Book(name, author);

        library.add(book);
        System.out.println(Colors.ANSI_GREEN + "Book added Succefully" + Colors.ANSI_RESET);
        System.out.println();

    }

    // handle list books
    @Override
    public void list() {
        // if no book stored
        if(library.isEmpty()) {
            System.out.println(Colors.ANSI_PURPLE + "No book stored" + Colors.ANSI_RESET);
            System.out.println();
            return;
        }

        for (Book book : library) {
            System.out.println((library.indexOf(book)+1) + "- " + book);
        }
        System.out.println();

    }

    // handle edit a book
    @Override
    public void edit() {
        int number;
        char editName; // n/N => No, y/Y => Yes
        char editAuthor; // n/N => No, y/Y => Yes


        // if no book stored
        if(library.isEmpty()) {
            System.out.println(Colors.ANSI_PURPLE + "No book stored" + Colors.ANSI_RESET);
            System.out.println();
            return;
        }

        //list all books
        list();

        //get user selection
        System.out.println("Enter Book number: ");
        number = handleUserListItemSelection(library.size());

        // get book
        Book book = library.get(number-1);

        //Edit Name
        System.out.println();
        System.out.println("=> Edit name ? (" + book.getName() + ") (y/Y: Yes, n/N: No)");
        editName = handleUserYesNoSelection();
        if(editName == 'y' || editName == 'Y') {
            System.out.println("new name:");
            String newName = scan.nextLine();
            book.setName(newName);
        }

        //Edit Author 
        System.out.println();
        System.out.println("=> Edit Author ? (" + book.getAuthor() + ") (y/Y: Yes, n/N: No)");
        editAuthor = handleUserYesNoSelection();
        if(editAuthor == 'y' || editAuthor == 'Y') {
            System.out.println("new author:");
            String newAuthor = scan.nextLine();
            book.setAuthor(newAuthor);
        }

        // check if something changed and print a msg
        if(editAuthor == 'y' || editAuthor == 'Y' || editName == 'y' || editName == 'Y') {
            System.out.println(Colors.ANSI_GREEN + "Book edited successfully" + Colors.ANSI_RESET);
        }else {
            System.out.println(Colors.ANSI_PURPLE + "Nothing has changed" + Colors.ANSI_RESET);
        }
        System.out.println();

        
    }

    // handle remove a book
    @Override
    public void remove() {
        int number;

        // if no book stored
        if(library.isEmpty()) {
            System.out.println(Colors.ANSI_PURPLE + "No book stored" + Colors.ANSI_RESET);
            System.out.println();
            return;
        }

        // list books
        list();

        //get user selection
        System.out.println("Enter Book number: ");
        number = handleUserListItemSelection(library.size());
        System.out.println();


        // remove book
        library.remove(number-1);
        System.out.println(Colors.ANSI_GREEN + "Book removed Succefully" + Colors.ANSI_RESET);
        System.out.println();

    }

    // handle search for a book
    @Override
    public void search() {
        ArrayList<Book> filtredBooks;
        // if no book stored
        if(library.isEmpty()) {
            System.out.println(Colors.ANSI_PURPLE + "No book stored" + Colors.ANSI_RESET);
            System.out.println();
            return;
        }

        System.out.println("Enter search keyword");
        String keyword = scan.nextLine();
        System.out.println();

        filtredBooks = new ArrayList<>(library.stream().filter(book -> book.getAuthor().contains(keyword) || book.getName().contains(keyword)).toList()); 

        // no book found
        if(filtredBooks.isEmpty()) {
            System.out.println(Colors.ANSI_PURPLE + "No book found" + Colors.ANSI_RESET);
            System.out.println();

            return;
        }
        //list filtred items
        filtredBooks.stream().forEach(book -> System.out.println((library.indexOf(book)+1) + "- " + book));
        // check one
        System.out.println("Enter a book number to check details:");
        int input = handleUserListItemSelection(filtredBooks.size());
        System.out.println(filtredBooks.get(input-1));
        System.out.println();

    
    }

    @Override
    public void back() {
         // no book 
        if(library.isEmpty()) {
            System.out.println(Colors.ANSI_PURPLE + "No book stored" + Colors.ANSI_RESET);
            System.out.println();
            return;
        }

        // store availble books
        ArrayList<Book> unavailaBooks;

        unavailaBooks = new ArrayList<>(library.stream().filter(book -> !book.getAvailable()).toList());

        // no unavailable books 
        if(unavailaBooks.isEmpty()) {
            System.out.println(Colors.ANSI_PURPLE + "No book is borrowed" + Colors.ANSI_RESET);
            System.out.println();
            return;
        }

        unavailaBooks.forEach(book -> System.out.println(book));
        System.out.println();

        // select a book to return
        System.out.println("select a book from the above list");
        int input = handleUserListItemSelection(unavailaBooks.size());

        Book selectedBook = unavailaBooks.get(input - 1);

        selectedBook.setAvailable(true);

        System.out.println(Colors.ANSI_GREEN + "You returned " + selectedBook.getName() + " ! Hope you enjoyed Reading it!!" + Colors.ANSI_RESET);
        System.out.println();
    }

    @Override
    public void borrow() {
        // no book 
        if(library.isEmpty()) {
            System.out.println(Colors.ANSI_PURPLE + "No book stored" + Colors.ANSI_RESET);
            System.out.println();
            return;
        }

        // store availble books
        ArrayList<Book> availaBooks;

        availaBooks = new ArrayList<>(library.stream().filter(book -> book.getAvailable()).toList());

        // no available books 
        if(availaBooks.isEmpty()) {
            System.out.println(Colors.ANSI_PURPLE + "No book available" + Colors.ANSI_RESET);
            System.out.println();
            return;
        }

        // list available books
        availaBooks.forEach(book -> System.out.println(book));
        System.out.println();

        // select a book to borrow
        System.out.println("select a book from the above list");
        int input = handleUserListItemSelection(availaBooks.size());

        Book selectedBook = availaBooks.get(input - 1);

        selectedBook.setAvailable(false);

        System.out.println(Colors.ANSI_GREEN + "You took " + selectedBook.getName() + " ! Happy Reading!!" + Colors.ANSI_RESET);
        System.out.println();

    }

    
    
}
