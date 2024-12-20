
import java.util.ArrayList;
import java.util.Scanner;

class Remove implements BookOperation {

    Scanner scan = new Scanner(System.in);

    @Override public void perfom(ArrayList<Book> library) {

        // think of how to use perform of list
        int length = library.size();
        int number;

        for(int i = 0; i < length; i++) {
            System.out.println(i+1 + "- " + library.get(i).getName());
        }

        
        // check user input
        while (true) { 
            System.out.println("Enter Book number: ");
            number = scan.nextInt();
            if(number <= 0 || number > length) {
                System.out.println("Invalid Input! try again");
                continue;
            } 
            break;
        }

        // remove item
        library.remove(number-1);
        System.out.println("Book removed Succefully");
        



    }
}
