import java.util.ArrayList;
import java.util.Scanner;

public class Search implements BookOperation{
    Scanner scan = new Scanner(System.in);

    @Override public void perfom(ArrayList<Book> library) {

        ArrayList<Book> filtredBooks = new ArrayList<>();
        
        if(library.isEmpty()) {
            System.out.println("No book stored");
            return;
        }
        //get the keyword
        System.out.println("Enter search keyword");
        String keyword = scan.nextLine();

        // handle search 
       
        //handle ibn
        //handle name
        //handle author
        for(Book book : library) { 
           if(book.getAuthor().contains(keyword) || book.getName().contains(keyword)) {
                filtredBooks.add(book);
           }
        }

        //list 

        //no book found
        if(filtredBooks.isEmpty()) {
            System.out.println("No book found");
            return;
        }

        //list found book
        int index = 0;
        System.out.println("Result: ");
        for(Book book : filtredBooks) {
            System.out.println(index+1 + "- " + book.getName().toUpperCase() + " by " + book.getAuthor());
            index++;
        }

        while (true) { 
            System.out.println("Enter a book number to check details (0: back home)");
            int num = scan.nextInt();
            scan.nextLine();

            if(num == 0) {
                return;
            }
            if(num < 0 && num > filtredBooks.size()) {
                System.out.println("Invalid Input! try again");
                continue;
            }
            System.out.println(filtredBooks.get(num-1));
            break;

        }
    }
}
