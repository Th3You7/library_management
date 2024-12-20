import java.util.ArrayList;

class List implements BookOperation {
    @Override public void perfom(ArrayList<Book> library) {
        int length = library.size();

        for(int i = 0; i < length; i++) {
            System.out.println(i+1 + "- " + library.get(i).getName().toUpperCase() + " by " + library.get(i).getAuthor());
        }
    }
}