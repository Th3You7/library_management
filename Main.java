import java.util.Scanner;

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
        BookOperation edit = new Edit();
        BookOperation remove = new Remove();
        BookOperation search = new Search();

        loop: while (true) {
            System.out.println(ANSI_BLUE + "************************************* Choose an operation *************************************" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "1- ADD / 2- LIST / 3- EDIT / 4- REMOVE / 5- SEARCH (EXIT: 0)" + ANSI_RESET);

            choice = scan.nextInt();
            scan.nextLine();

            switch(choice) {
                case 1:
                    library.perform(library.library, addition);
                    break;

                case 2:
                    library.perform(library.library, list);
                    break;

                case 3:
                    library.perform(library.library, edit);
                    break;

                case 4: 
                    library.perform(library.library, remove);
                    break;

                case 5:
                    library.perform(library.library, search);
                    break;
                
                case 8: 
                    break loop;
                default:
                    throw new AssertionError("Invalid Option");
            }
           
        }
    }
}