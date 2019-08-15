package epam.buid_in_functional_interfaces;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        System.out.println("Predicate:"); //Предикаты — это функции, принимающие один аргумент, и возвращающие значение типа boolean.

        Predicate<String> predicate = (s) -> s.length() > 5;   //defining what it do.
                                                                //predicate as lambda
        System.out.println(predicate.test("foo"));          //doing it
        System.out.println(predicate.test("qweqweqwqwe"));
        System.out.println(predicate.negate().test("qweqweqwqwe"));

        Predicate<String> predicate2 = String::isEmpty;         //predicate as reference to method

        System.out.println(predicate2.test(""));

        System.out.println("================================================");

        Predicate<String> nonNul = Objects::nonNull;

        System.out.println(nonNul.test(null));
        System.out.println(nonNul.test("qwe"));
        System.out.println("================================================");

        System.out.println("Function:"); //Функции принимают один аргумент и возвращают некоторый результат. Методы по умолчанию могут использоваться для построения цепочек вызовов

        Function<String, Integer> function = Integer::valueOf;  //predicate as reference to method

        Integer number = function.apply("123");
        System.out.println(number);

        Function<String,String> backToString = function.andThen(String::valueOf); //Сначало переводит строку в число, затем число в строку. Цепочка вызовов

        String st = backToString.apply("123");
        System.out.println(st);

        Function<String, Integer> function2 = x -> Integer.valueOf(x); //predicate as lambda
        Integer number2 = function2.apply("456");
        System.out.println(number2);

        System.out.println("================================================");

        System.out.println("Supplier:"); //Поставщики (suppliers) предоставляют результат заданного типа. В отличии от функций, поставщики не принимают аргументов.
        Supplier<User> supplier = User::new; //suplier as reference to method
        System.out.println(supplier.get());

        Supplier<User> supplier2 = () -> new User(); //suplier as lambda
        System.out.println(supplier2.get());
        System.out.println("================================================");

        System.out.println("Consumer:"); //Потребители (consumers) представляют собой операции, которые производятся над одним входным аргументом.
        User user = new User();
        Consumer<User> consumer = u -> u.setName("Aset"); //consumer as lambda
        consumer.accept(user);
        System.out.println(user);

        Consumer<User> consumer2 = User::setDefaultName; //consumer as reference to method
        consumer2.accept(user);
        System.out.println(user);
        System.out.println("================================================");

        System.out.println("Comparator"); //Компараторы хорошо известны по предыдущим версиям Java. Java 8 добавляет в интерфейс различные методы по умолчанию.
        User user2 = new User();
        user2.setName("Aset2");
        Comparator<User> comparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        System.out.println(comparator.compare(user, user2));






    }
}
