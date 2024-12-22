
class Main implements UserInput {
    
    public static void main(String[] args) {
        
        BookService library = new Library();
       

        loop: while (true) {
            System.out.println(Colors.ANSI_BLUE + "************************************* Choose an operation *************************************" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE + "1- ADD / 2- LIST / 3- EDIT / 4- REMOVE / 5- SEARCH / 6- BORROW / 7- RETURN (EXIT: 0)" + Colors.ANSI_RESET);
            
            // cant call a non static method inside main; had to initiate a child;
            int choice = new Main().handleUserInputMismatch(); 
            System.out.println();

            switch(choice) {
                case 1:
                    library.add();
                    break;

                case 2:
                    library.list();
                    break;

                case 3:
                    library.edit();
                    break;

                case 4: 
                    library.remove();
                    break;

                case 5:
                    library.search();
                    break;

                case 6: 
                    library.borrow();
                    break;

                case 7: 
                    library.back();
                    break;
                
                case 0: 
                    break loop;
                default:
                    System.out.println(Colors.ANSI_RED + "Invalid Option" + Colors.ANSI_RESET);
            }
           
        }
    }
}