package epam.buid_in_functional_interfaces;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        System.out.println("Predicate:");
        Predicate<String> predicate = (s) -> s.length() > 5;   //defining what it do. Предикаты — это функции, принимающие один аргумент, и возвращающие
                                                               // значение типа boolean.
        System.out.println(predicate.test("foo"));          //doing it
        System.out.println(predicate.test("qweqweqwqwe"));
        System.out.println(predicate.negate().test("qweqweqwqwe"));
        System.out.println("================================================");

        Predicate<String> nonNul = Objects::nonNull;
        System.out.println(nonNul.test(null));
        System.out.println(nonNul.test("qwe"));
        System.out.println("================================================");

        System.out.println("Function:");
        Function<String, Integer> function = Integer::valueOf;  //Функции принимают один аргумент и возвращают некоторый результат. Методы по умолчанию
                                                                // могут использоваться для построения цепочек вызовов
        Integer number = function.apply("123");
        System.out.println(number);

        Function<String,String> backToString = function.andThen(String::valueOf); //Сначало переводит строку в число, затем число в строку. Цепочка вызовов
        String st = backToString.apply("123");
        System.out.println(st);
        System.out.println("================================================");

        System.out.println("Supplier:"); //Поставщики (suppliers) предоставляют результат заданного типа. В отличии от функций, поставщики не принимают аргументов.
        Supplier<User> supplier = User::new;
        System.out.println(supplier.get());
        System.out.println("================================================");

        System.out.println("Consumer:"); //Потребители (consumers) представляют собой операции, которые производятся над одним входным аргументом.
        User user = new User();
        Consumer<User> consumer = u -> u.setName("Aset");
        consumer.accept(user);
        System.out.println(user);
        System.out.println("================================================");

        System.out.println("Comparator"); //Компараторы хорошо известны по предыдущим версиям Java. Java 8 добавляет в интерфейс различные методы по умолчанию.
        User user2 = new User();
        user2.setName("Aset2");
        Comparator<User> comparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        System.out.println(comparator.compare(user, user2));






    }
}
