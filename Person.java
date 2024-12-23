import java.util.UUID;

public class Person {
    final private  String id;
    private String name;

    public Person(String name) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName().toUpperCase();
    }
}
