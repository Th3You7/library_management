
import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println("Book added Succefully");

        
        // scan.close();
    }
}
