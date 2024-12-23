import java.util.ArrayList;
import java.util.Scanner;

public class Readers implements ReadersService {
    private final ArrayList<Person> readers =  new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    
    //getters and setters;
    @Override
    public ArrayList<Person> getReaders() {
        return readers;
    }

    @Override
    public void add() {
        System.out.println("Enter Reader name: ");
        String name = scan.nextLine();
        
        Person reader = new Person(name);

        readers.add(reader);
        System.out.println(Colors.ANSI_GREEN + "Reader added Succefully" + Colors.ANSI_RESET);
        System.out.println();
    }
   
}
