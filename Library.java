import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Library {
    ArrayList<Book> library =  new ArrayList<>();

    public void perform(ArrayList<Book> library, BookOperation bookOperation) {
        try {
            bookOperation.perfom(this.library);
        } catch (InvalidParameterException e) {
            throw new InvalidParameterException("Cannot perform operation");
        }
    }
}
