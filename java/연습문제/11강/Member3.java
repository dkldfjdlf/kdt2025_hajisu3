package hajisu;

// Member3.java
public class Member3 {
    private String id;
    private String name;

    public Member3(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ": " + name;
    }
}