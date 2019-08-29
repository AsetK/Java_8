package epam.optional;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class NewMain {

    public static void main(String[] args) {

        //      Rule #1: Never, ever, use null for Optional variable or return value
        //      Rule #2: Never use Optional.get() unless you can prove that the Optional is present
        //      Rule #3: Prefer alternatives to Optional.isPresent() and Optional.get()

        //      Note: Optional is immutable. We can't set the value on optional after it's creation



        //      orElse(default)
        System.out.println("orElse(default):");
        Optional<User> optionalUser = Optional.ofNullable(new User("A", 30));   //put null
        User user = optionalUser.orElse(new User("DEFAULT", 31));
        System.out.println(user);
        System.out.println("================================================");


        //      orElseGet(supplier)
        System.out.println("orElseGet(supplier):");
        Optional<User> optionalUser_2 = Optional.ofNullable(new User("A", 30));  //put null
        User user_2 = optionalUser_2.orElseGet(User::new);
        System.out.println(user_2);
        System.out.println("================================================");


        //      orElseThrow(excsupplier)
        System.out.println("orElseThrow(excsupplier):");
        Optional<User> optionalUser_3 = Optional.ofNullable(new User("A", 30)); //put null
        User user_3 = optionalUser_3.orElseThrow(IllegalStateException::new);
        System.out.println(user_3);
        System.out.println("================================================");


        //      map()
        System.out.println("map():");
        Optional<User> optionalUser_4 = Optional.ofNullable(new User("A", 30)); //put null
        System.out.println(optionalUser_4.map(User::getName));
        String userName = optionalUser_4.map(User::getName).orElse("UNKNOWN"); //тут orElse не только выполняет альтернативный вариант, но и преобразует Optional в неOptional
        System.out.println(userName);
        System.out.println("================================================");


        //      filter()
        System.out.println("filter():");
        Optional<String> stringOptional = Optional.of("text");
        Optional<String> emptyOptional = Optional.empty();

        System.out.println(stringOptional.filter(g -> g.equals("text")));
        System.out.println(stringOptional.filter(g -> g.equals("TEXT")));
        System.out.println(emptyOptional.filter(g -> g.equals("text")));

        stringOptional.filter(g -> g.equals("text")).ifPresent(g -> System.out.println(g));
        System.out.println("================================================");


        //      map() $ stream()
        System.out.println("map() & stream():");
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("ab");
        list.add("ac");
        list.add("d");

        Optional<List<String>> optionalList = Optional.of(list);
        System.out.println(optionalList.map(l->l.subList(0,2)));
        System.out.println("-------");

        Optional<Stream<String>> optionalStream = optionalList.map(l->l.stream().filter(i->i.contains("a")));
        List<String> stringList = optionalStream.get().collect(Collectors.toList());
        stringList.forEach(System.out::println);
        System.out.println("-------");

        Optional<List<String>> strings = optionalList.map(l->l.stream().filter(i->i.contains("a")).collect(Collectors.toList())); // То же самое только в одну строку
        strings.get().forEach(System.out::println);
        System.out.println("================================================");

        //      flatMap()
        System.out.println("flatMap():");
        Optional<User> optionalUser_5 = Optional.of(new User("A", 30));
        Optional<Optional<User>> optionalOptionalUser = Optional.of(optionalUser_5);

        Optional<User> optionalUser1 = optionalOptionalUser.map(u -> u.get());

        Optional<Optional<String>> optionalOptionalString =     optionalOptionalUser.map(ou -> ou.map(User::getName));
        Optional<String> optionalString_1 =                     optionalOptionalUser.map((ou -> ou.get().getName()));
        Optional<String> optionalString_2 =                     optionalOptionalUser.flatMap(ou -> ou.map(User::getName)); //the same as previous approach
        System.out.println(optionalOptionalUser.flatMap(u -> u));

















    }
}
