package epam.functional_interface_and_lambda;

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





    }
}
