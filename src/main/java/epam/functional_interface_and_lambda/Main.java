package epam.functional_interface_and_lambda;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        new SomeClass().method2();
        System.out.println("================================================");

        InterfaceWithDefaulMethod interfaceWithDefaulMethod = new InterfaceWithDefaulMethod() { //anonymous object
            @Override
            public void method1() {
                System.out.println("Anonymous object method");
            }
        };
        interfaceWithDefaulMethod.method1();
        interfaceWithDefaulMethod.method2();
        System.out.println("================================================");

        InterfaceWithDefaulMethod interfaceWithDefaulMethod2 = () -> System.out.println("Lambda object method");
        interfaceWithDefaulMethod2.method1();
        interfaceWithDefaulMethod2.method2();
        System.out.println("================================================");

        MyFunctionalInterface<String> myFunctionalInterface = s -> s.length() > 5; //defining what it do
        System.out.println(myFunctionalInterface.test("qwe"));                  //doing it
        System.out.println(myFunctionalInterface.test("qweqwe"));


        System.out.println("================================================");
        MyInterface anonymousWtihTwoMethods = new MyInterface() {
            @Override
            public void method_1() {
                System.out.println("Method_1");
            }

            @Override
            public void method_2() {
                System.out.println("Method_2");
            }
        };

        anonymousWtihTwoMethods.method_1();
        anonymousWtihTwoMethods.method_2();







    }
}
