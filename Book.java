
public class Book {

    private String name;
    private String author;
    private Boolean available;

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
}