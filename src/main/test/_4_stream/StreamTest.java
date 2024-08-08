package _4_stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    // Разница между коллекциями и стримами в Java заключается в их подходе к работе с данными и их функциональными возможностями:
    // 1. Изменяемость данных:
    //    Коллекции: Изменяемые. В коллекции данные можно добавлять, удалять и изменять напрямую. Например, ты можешь добавить элемент в ArrayList или удалить его.
    //    Стримы: Неизменяемые. Стримы не изменяют исходные данные. Они создают новые данные, применяя операции, такие как фильтрация или преобразование,
    //    без изменения исходной коллекции.
    // 2. Хранение данных:
    //    Коллекции: Хранят данные в памяти и предоставляют доступ к ним в любой момент. Данные существуют до тех пор,
    //    пока ты явно не удалишь их или не освободишь память.
    //    Стримы: Не хранят данные, а работают с потоками данных. Стримы генерируют данные "на лету" и выполняют операции лениво, т.е. только тогда,
    //    когда это необходимо (например, при вызове терминальной операции, такой как collect или forEach).
    // 3. Операции с данными:
    //    Коллекции: Операции с коллекциями обычно выполняются в императивном стиле, с использованием циклов и условных операторов.
    //    Ты напрямую управляешь процессом обработки данных.
    //    Стримы: Поддерживают функциональный стиль программирования, позволяя описывать операции с данными декларативно, используя лямбды и методы,
    //    такие как map, filter, reduce.
    // 4. Производительность и оптимизация:
    //    Коллекции: Могут быть менее эффективными, особенно при выполнении нескольких последовательных операций,
    //    поскольку каждая операция может требовать итерации по коллекции.
    //    Стримы: Могут быть более эффективными за счет ленивого выполнения операций. Операции с потоками данных выполняются только тогда,
    //    когда это необходимо, и могут быть оптимизированы за счет конвейерного выполнения.
    // 5. Параллелизм:
    //    Коллекции: Не поддерживают параллелизм по умолчанию.
    //    Если нужно выполнять операции параллельно, тебе нужно вручную управлять потоками или использовать другие механизмы синхронизации.
    //    Стримы: Поддерживают параллелизм через метод parallelStream(), который позволяет автоматически распределять обработку данных на несколько потоков.

    //      Операции над потоками бывают или промежуточными (intermediate) или конечными (terminal).
    //      Конечные операции возвращают результат определенного типа, а промежуточные операции возвращают тот же поток.
    //      Таким образом вы можете строить цепочки из несколько операций над одним и тем же потоком.
    //      Поток создаются на основе источников, например типов, реализующих java.util.Collection,
    //      такие как списки или множества (ассоциативные массивы не поддерживаются). Операции над потоками могут выполняться как последовательно,

    // Некторые промежуточные операции
    // list.stream().filter(s -> s.startsWith("a"))
    // list.stream().sorted()
    // list.stream().map(String::toUpperCase)
    // numbers.stream().distinct() удаляет дубликаты
    // numbers.stream().peek(n -> System.out.println("Элемент: " + n)) Выполняет действие над каждым элементом стрима, не изменяя его.
    // numbers.stream().limit(3) Ограничивает количество элементов в стриме до указанного числа.
    // numbers.stream().skip(2) Пропускает первые n элементов стрима и возвращает оставшиеся.


    // Некоторые терминальные операции
    // numbers.stream().forEach(System.out::println);
    // numbers.stream().collect(Collectors.toList());
    // numbers.stream().min(Integer::compareTo); numbers.stream().max(Integer::compareTo);
    // numbers.stream().count();
    // numbers.stream().anyMatch(n -> n % 2 == 0); numbers.stream().allMatch(n -> n % 2 == 0); numbers.stream().noneMatch(n -> n % 2 != 0);
    // numbers.stream().findFirst(); numbers.stream().findAny();

    private ArrayList<String> list = new ArrayList<>();

    {
        list.add("qqq");
        list.add("bbb");
        list.add("aa1");
        list.add("aa2");
        list.add("ddd");
        list.add("www");
        list.add("eee");
    }

    @Test
    public void filter() {
        List<String> filtered = list.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
        System.out.println(filtered);
    }

    @Test
    public void sort() {
        List<String> sorted = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);
    }

    @Test
    public void map() {
        List<String> mapped = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(mapped);
    }

    @Test
    public void flatMap() {
        //by map and flatMap.
        //flatMap() позволяет stream list-ов(Stream<List<T>>) преобразовать в Stream<T>. "распаковывает" вложенные стримы в единый поток.
        //Т.е. многомерный массив преобразует в одномерный
        //Пример:  [{1 2 3},
        //          {4 5 6},    -->  {1 2 3 4 5 6 7 8 9}
        //          {7 8 9}]
        List<Person> persons = Arrays.asList(
                new Person("A", Arrays.asList("Cat", "Dog")),
                new Person("A", Arrays.asList("Wolf")),
                new Person("A", Arrays.asList("Lion"))
        );

        List<List<String>> petsMapped = persons.stream().map(Person::getPets).collect(Collectors.toList());
        List<String> petsFlatMapped = persons.stream().map(Person::getPets).flatMap(p -> p.stream()).collect(Collectors.toList());
        List<String> petsFlatMapped2 = persons.stream().flatMap(person -> person.getPets().stream()).collect(Collectors.toList());

        System.out.println(petsMapped);
        System.out.println(petsFlatMapped);
        System.out.println(petsFlatMapped2);
    }

    @Test
    public void understand() {
        List<Person> persons = Arrays.asList(
                new Person("A", Arrays.asList("Cat", "Dog")),
                new Person("A", Arrays.asList("Wolf")),
                new Person("A", Arrays.asList("Lion"))
        );

        Stream<Person> personStream = persons.stream();
        Stream<List<String>> petsStream = personStream.map(Person::getPets);
        Stream<Stream<String>> streamStream = petsStream.map(pets -> pets.stream());
    }

    @Test
    public void match() {
        boolean anyMatch = list.stream().anyMatch(s -> s.startsWith("a"));
        boolean allMatch = list.stream().allMatch(s -> s.startsWith("a"));
        boolean noneMatch = list.stream().noneMatch(s -> s.startsWith("a"));

        System.out.println(anyMatch);
        System.out.println(allMatch);
        System.out.println(noneMatch);
    }

    @Test
    public void count() {
        long count = list.stream().count();
        System.out.println(count);
    }

    @Test
    public void reduce() { //выполняет агрегирование (сведение) элементов стрима в одно значение.
        String reduced = list.stream().reduce((s1, s2) -> s1 + " - " + s2).get();
        System.out.println(reduced);
    }

    @Test
    public void parallelStream() {
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            strings.add("a");
            strings.add("b");
            strings.add("c");
        }

        // Последовательная обработка
        long l1 = System.currentTimeMillis();
        List<String> sequential = strings.stream()
                .filter(s -> {
                    try {
                        Thread.sleep(100); // имитация сложной работы
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return s.startsWith("a");})
                .collect(Collectors.toList());
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);

        // Параллельная обработка
        long l3 = System.currentTimeMillis();
        List<String> Parallel = strings.parallelStream()
                .filter(s -> {
                    try {
                        Thread.sleep(100); // имитация сложной работы
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return s.startsWith("a");})
                .collect(Collectors.toList());
        long l4 = System.currentTimeMillis();
        System.out.println(l4-l3);

        // Параллельная обработка
        long l5 = System.currentTimeMillis();
        List<String> Parallel2 = strings.stream().parallel()
                .filter(s -> {
                    try {
                        Thread.sleep(100); // имитация сложной работы
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return s.startsWith("a");})
                .collect(Collectors.toList());
        long l6 = System.currentTimeMillis();
        System.out.println(l6-l5);
    }

    public class Person {
        private String name;
        private List<String> pets;

        Person(String name, List<String> pets) {
            this.name = name;
            this.pets = pets;
        }

        public String getName() {
            return name;
        }

        public List<String> getPets() {
            return pets;
        }
    }


}
