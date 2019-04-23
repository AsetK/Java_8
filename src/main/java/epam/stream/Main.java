package epam.stream;

import java.util.ArrayList;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // Операции над потоками бывают или промежуточными (intermediate) или конечными (terminal).
        // Конечные операции возвращают результат определенного типа, а промежуточные операции возвращают тот же поток.
        // Таким образом вы можете строить цепочки из несколько операций над одним и тем же потоком.
        // Поток создаются на основе источников, например типов, реализующих java.util.Collection,
        // такие как списки или множества (ассоциативные массивы не поддерживаются). Операции над потоками могут выполняться как последовательно,
        // так и параллельно.

        //Сначала давайте посмотрим, как работать с потоком последовательно. Сперва создадим источник в виде списка строк:

        ArrayList<String> list = new ArrayList<>();
        list.add("qqq");
        list.add("bbb");
        list.add("aa1");
        list.add("aa2");
        list.add("ddd");
        list.add("www");
        list.add("eee");

        System.out.println("Filter:");
        list.stream().filter(s -> s.startsWith("a")).forEach(s -> System.out.println(s));
        System.out.println("==========================================================");

        // Операция Sorted является промежуточной операцией, которая возвращает отсортированное представление потока.
        // Элементы сортируются в обычном порядке, если вы не предоставили свой компаратор.
        // Помните, что sorted создает всего лишь отсортированное представление и не влияет на порядок элементов в исходной коллекции.
        System.out.println("Sorted:");
        list.stream().sorted().forEach(s -> System.out.println(s));
        System.out.println("==========================================================");

        // Промежуточная операция map преобразовывает каждый элемент в другой объект при помощи переданной функции.
        // Следующий пример преобразовывает каждую строку в строку в верхнем регистре.
        // Однако вы так же можете использовать map для преобразования каждого объекта в объект другого типа.
        // Тип результирующего потока зависит от типа функции, которую вы передаете при вызове map.
        System.out.println("Map:");
        list.stream().map(String::toUpperCase).forEach(s -> System.out.println(s));
        System.out.println("==========================================================");

        // Для проверки, удовлетворяет ли поток заданному предикату, используются различные операции сопоставления (match).
        // Все операции сопоставления являются конечными и возвращают результат типа boolean.
        System.out.println("Match:");
        boolean anyStartWith_a = list.stream().anyMatch(s -> s.startsWith("a"));
        boolean allStartWith_a = list.stream().allMatch(s -> s.startsWith("a"));
        boolean noneStartWith_a = list.stream().noneMatch(s -> s.startsWith("a"));
        System.out.println(anyStartWith_a + ", " + allStartWith_a + ", " + noneStartWith_a);
        System.out.println("==========================================================");

        // Операция Count является конечной операцией и возвращает количество элементов в потоке. Типом возвращаемого значения является long.
        System.out.println("Count:");
        long size = list.stream().count();
        System.out.println(size);
        System.out.println("==========================================================");

        System.out.println("Reduce:");
        Optional<String> reduced = list.stream().reduce((s1, s2) -> s1 + " - " + s2);
        reduced.ifPresent(s -> System.out.println(s));
        System.out.println("==========================================================");



    }
}
