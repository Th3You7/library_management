
public class Book {

    String name;
    String author;
    Boolean available;

    public Book(String name, String author, Boolean available) {
        this.name = name;
        this.author = author;
        this.available = available;
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
}