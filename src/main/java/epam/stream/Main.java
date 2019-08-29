package epam.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //      Collections vs Streams
        //      Collections are in-memory data structures which hold elements within it. Each element in the collection is computed before it actually becomes a part of that collection.
        //      On the other hand Streams are fixed data structures which computes the elements on-demand basis.
        //      The Java 8 Streams can be seen as lazily constructed Collections, where the values are computed when user demands for it.
        //      Actual Collections behave absolutely opposite to it and they are set of eagerly computed values (no matter if the user demands for a particular value or not).

        //      Операции над потоками бывают или промежуточными (intermediate) или конечными (terminal).
        //      Конечные операции возвращают результат определенного типа, а промежуточные операции возвращают тот же поток.
        //      Таким образом вы можете строить цепочки из несколько операций над одним и тем же потоком.
        //      Поток создаются на основе источников, например типов, реализующих java.util.Collection,
        //      такие как списки или множества (ассоциативные массивы не поддерживаются). Операции над потоками могут выполняться как последовательно,
        //      так и параллельно.

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
        Stream<String> stream3 = list.stream(); //Just fo notion: stream() returns Stream<>
        list.stream().filter(s -> s.startsWith("a")).forEach(s -> System.out.println(s));
        Stream<String> stream = list.stream().filter(s -> s.startsWith("a")); //filter returns Stream<> object.
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

        System.out.println("Stream with multithreading:");

        list.parallelStream().sorted().sequential().forEach(s -> System.out.println(s)); //нужно обратно перейти в однопоточно чтобы нормально распечатал

        System.out.println("==========================================================");

        System.out.println("FlatMap:");
        List<Person> personList = Arrays.asList(
                new Person("A", Arrays.asList("A_1", "A_2", "A_3")),
                new Person("K", Arrays.asList("K_1", "K_2")),
                new Person("L", Arrays.asList("L_1", "L_2"))
        );

        //by forEach
        List<String> petNames = new ArrayList<>();
        for(Person p : personList){
            petNames.addAll(p.getPetList());
        }
        System.out.println(petNames);

        //by forEach() method
        List<String> stringList2 = new ArrayList<>();
        personList.forEach(person -> person.getPetList().forEach(pet-> stringList2.add(pet)));
        System.out.println(stringList2);

        //by map and flatMap.
        //flatMap() позволяет stream list-ов(Stream<List<T>>) преобразовать в Stream<T>
        //Т.е. многомерный массив преобразует в одномерный
        //Пример:  [{1 2 3},
        //          {4 5 6},    -->  {1 2 3 4 5 6 7 8 9}
        //          {7 8 9}]
        List<String> petNames_2 = personList.stream()
                .map(person -> person.getPetList())
                .flatMap(pets->pets.stream())
                .collect(Collectors.toList());
        System.out.println(petNames_2);

        //by map and flat. The same as previous example
        Stream<Person> personStream = personList.stream();
        Stream<List<String>> petList = personStream.map(person -> person.getPetList());     //List<List<String>>. Что бы было понятно что такое Stream, его удобно рассматривать как List
        Stream<String> petsStream = petList.flatMap(pets -> pets.stream());                 //List<String>.
        System.out.println(petsStream.collect(Collectors.toList()));

        //by only map. just to understand how flatMap works
        Stream<Person> personStream2 = personList.stream();
        Stream<List<String>> petList2 = personStream2.map(person -> person.getPetList());   //List<List<String>>
        Stream<Stream<String>> streamStream = petList2.map(pets -> pets.stream());
        List<Stream<String>> streamList = streamStream.collect(Collectors.toList());
        List<String> stringList = new ArrayList<>();
        streamList.forEach(stringStream -> stringStream.collect(Collectors.toList()).forEach(s -> stringList.add(s)));
        System.out.println(stringList);
















    }
}
