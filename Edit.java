
import java.util.ArrayList;
import java.util.Scanner;

public class Edit implements BookOperation{
    Scanner scan = new Scanner(System.in);

    @Override public void perfom(ArrayList<Book> library) {
        // list all books
        int length = library.size();
        int number;
        int editName;
        int editAuthor;

        for(int i = 0; i < length; i++) {
            System.out.println(i+1 + "- " + library.get(i).getName());
        }

        // check user input
        while (true) { 
            System.out.println("Enter Book number: ");
            number = scan.nextInt();
            scan.nextLine();
            if(number <= 0 || number > length) {
                System.out.println("Invalid Input! try again");
                continue;
            } 
            break;
        }

        // edit properties
        Book book = library.get(number-1);


        // edit name
        System.out.println(book.name);
        while(true) {
            System.out.println("Edit name ? (1 Yes, 2 No)");
            editName = scan.nextInt();
            scan.nextLine();
            if(editName != 1 && editName != 2) {
                System.out.println("Invalid Input! try again");
                continue;
            } 
            break;
        }

        if(editName == 1) {
            System.out.println("Enter new name:");
            String newName = scan.nextLine();
            book.setName(newName);
        }

        // edit author
        System.out.println(book.author);
        while(true) {
            System.out.println("Edit Author ? (1 Yes, 2 No)");
            editAuthor = scan.nextInt();
            scan.nextLine();
            if(editName != 1 && editName != 2) {
                System.out.println("Invalid Input! try again");
                continue;
            } 
            break;
        }

        if(editAuthor == 1){
            System.out.println("Enter new author name:");
            String newName = scan.nextLine();
            book.setAuthor(newName);
        }


        // check if something changed and print a msg
        if(editAuthor == 1 || editName == 1) {
            System.out.println("Book edited successfully");

        }else {
            System.out.println("Nothing has changed");
        }
    }
}
