package _1_functional_interface_implementations;

public class SomeClass2 {

    public String text;

    public SomeClass2() {

    }

    public SomeClass2(String text) {
        this.text = text;
    }

    public static void print1() {
        System.out.println("Static method");
    }

    public void print2() {
        System.out.println("Instance method");
    }

    @Override
    public String toString() {
        return "SomeClass2{" +
                "text='" + text + '\'' +
                '}';
    }
}
