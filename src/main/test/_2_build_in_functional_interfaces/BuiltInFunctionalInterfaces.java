package _2_build_in_functional_interfaces;


import org.junit.Test;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFunctionalInterfaces {

    @Test
    public void predicateAsLambda() {
        Predicate<String> predicate = (s) -> s.length() > 5;   // определяем что делаем. предикат возвращает boolean

        System.out.println(predicate.test("foo"));          // делаем это
        System.out.println(predicate.test("supercar"));
        System.out.println(predicate.negate().test("supercar")); //
    }

    @Test
    public void predicateAsReferenceToMethod() {
        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test(""));

        Predicate<String> nonNul = Objects::nonNull;
        System.out.println(nonNul.test(null));
        System.out.println(nonNul.test("foo"));
    }

    @Test
    public void functionAsLambda() {
        Function<String, Integer> function2 = (x) -> Integer.valueOf(x);
        Integer number2 = function2.apply("456");
        System.out.println(number2);
    }

    @Test
    public void functionAsReferenceToMethod() {
        Function<String, Integer> function = Integer::valueOf;

        Integer number = function.apply("123");
        System.out.println(number);
    }

    @Test
    public void functionAsReferenceToMethod2() {
        Function<String, Integer> function = Integer::valueOf;

        Integer number = function.apply("123");
        System.out.println(number);

        Function<String, String> backToString = function.andThen(String::valueOf); //Сначало переводит строку в число, затем число в строку. Цепочка вызовов

        String st = backToString.apply("123");
        System.out.println(st);
    }

    @Test
    public void supplierAsLambda() {
        Supplier<User> supplier2 = () -> new User();
        System.out.println(supplier2.get());

    }

    @Test
    public void supplierAsReferenceToMethod() {
        Supplier<User> supplier = User::new;
        System.out.println(supplier.get());
    }

    @Test
    public void consumerAsLambda() {
        User user = new User();
        Consumer<User> consumer = u -> u.setName("Aset");
        consumer.accept(user);
        System.out.println(user);
    }

    @Test
    public void consumerAsReferenceToMethod() {
        User user = new User();
        Consumer<User> consumer = User::setDefaultName;
        consumer.accept(user);
        System.out.println(user);
    }


    static class User {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static void setDefaultName(User user) {
            user.setName("Default Name");
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
