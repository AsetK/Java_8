package epam.reference_to_method_and_constructor;

public class SomeClass2 {

    private String name;
    private String password;

    public SomeClass2(String name, String password)
    {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SomeClass2{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
