package epam.functional_interface_and_lambda;

@FunctionalInterface // says that interface should have only ONE abstract method
public interface InterfaceWithDefaulMethod {

    public void method1();

    public default void method2()
    {
        System.out.println("Interface default method");
    }
}
