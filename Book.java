
public class Book {

    private String name;
    private String author;
    private Boolean available;
    private long isbn;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(Boolean availbale) {
        this.available = availbale;
    }

    @Override
    public String toString() {
        String isAvailable =  getAvailable() ? Colors.ANSI_GREEN + "* Available" + Colors.ANSI_RESET : Colors.ANSI_RED + "* Not Available" + Colors.ANSI_RESET;
        return getName().toUpperCase() + " by " + getAuthor() + " | " + isAvailable;
    }

}