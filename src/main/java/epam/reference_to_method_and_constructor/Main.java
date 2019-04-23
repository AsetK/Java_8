package epam.reference_to_method_and_constructor;

public class Main {

    public static void main(String[] args) {

        FunctionalInterface<String> functionalInterface1 = SomeClass::print1;
        functionalInterface1.method1("Reference to static method");
        System.out.println("================================================");

        SomeClass someClass = new SomeClass();
        FunctionalInterface<String> functionalInterface2 = someClass::print2;
        functionalInterface2.method1("Reference to object method");
        System.out.println("================================================");

        FunctionalInterface2 interface2 = SomeClass2::new;
        SomeClass2 someClass2 = interface2.create("Asset", "qwerty");
        System.out.println(someClass2);

    }
}
