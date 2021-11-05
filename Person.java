package People;
public class Person {
    private int id;
    private String userName;
    private int age;

    public Person(int id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

};