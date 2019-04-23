package epam.reference_to_method_and_constructor;

public class Main {

    public static void main(String[] args) {

        MyFunctionalInterface<String> myFunctionalInterface1 = SomeClass::print1;
        myFunctionalInterface1.method1("Reference to static method");
        System.out.println("================================================");

        SomeClass someClass = new SomeClass();
        MyFunctionalInterface<String> myFunctionalInterface2 = someClass::print2;
        myFunctionalInterface2.method1("Reference to object method");
        System.out.println("================================================");

        MyFunctionalInterface2 interface2 = SomeClass2::new;
        SomeClass2 someClass2 = interface2.create("Asset", "qwerty");
        System.out.println(someClass2);

        MyFunctionalInterface3<SomeClass2> interface3 = SomeClass2::new;
        SomeClass2 someClass3 = interface3.create("Asset", "password");
        System.out.println(someClass3);


    }
}
