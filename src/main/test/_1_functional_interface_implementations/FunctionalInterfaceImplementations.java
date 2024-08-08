package _1_functional_interface_implementations;

import org.junit.Test;

public class FunctionalInterfaceImplementations {

    @Test
    public void functionalInterfaceAndClass() {
        new SomeClass().method1();
    }

    @Test
    public void functionalInterfaceAndAnonymousClass() {
        MyFunctionalInterface myFunctionalInterface = new MyFunctionalInterface() {
            @Override
            public void method1() {
                System.out.println("Anonymous object method");
            }
        };

        myFunctionalInterface.method1();
    }

    @Test
    public void functionalInterfaceAndLambda() {
        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("Lambda object method");

        myFunctionalInterface.method1();
    }

    @Test
    public void genericFunctionalInterfaceAndLambda() {
        MyGenericFunctionalInterface<String> myGenericFunctionalInterface = s -> s.length() > 5;

        System.out.println(myGenericFunctionalInterface.test("supercar"));
    }

    @Test
    public void functionalInterfaceAndReferenceToStaticMethod() {
        MyFunctionalInterface myFunctionalInterface = SomeClass2::print1;
        myFunctionalInterface.method1();
    }

    @Test
    public void functionalInterfaceAndReferenceToInstanceMethod() {
        MyFunctionalInterface myFunctionalInterface = new SomeClass2()::print2;
        myFunctionalInterface.method1();
    }

    @Test
    public void functionalInterfaceAndConstructor() {
        MyFunctionInterfaceForConstructor myFunctionInterfaceForConstructor = SomeClass2::new;
        SomeClass2 asset = myFunctionInterfaceForConstructor.create("Asset");
        System.out.println(asset);
    }
}
