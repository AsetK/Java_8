package epam.optional;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        User user = new User();
        user.setName("First");
        user.setAge(30);

        Optional<User> optionalUser = Optional.ofNullable(user); // here null or user
        System.out.println(optionalUser.orElse(new User()));
        System.out.println(optionalUser.isPresent());

        optionalUser.ifPresent(u -> u.setName("Aset")); // Consumer - functional interface
        System.out.println(user);

        if(optionalUser.isPresent())
            System.out.println(optionalUser.get());
        System.out.println("================================================");


        System.out.println(optionalUser.map((p)->p.getName()));
        String name = optionalUser.map((p)->p.getName()).get();

        Integer age = optionalUser.map((p)->p.getAge()).get();

        //How works .map()
        System.out.println("================================================");

        User user1 = new User(); user1.setName("A"); user1.setAge(1);
        User user2 = new User(); user2.setName("K"); user2.setAge(2);
        User user3 = new User(); user3.setName("L"); user3.setAge(3);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        Optional<List<User>> optionalUserList = Optional.of(userList);
        Optional<Integer> optionalSize = optionalUserList.map(l -> l.size());
        System.out.println(optionalSize);
        System.out.println(optionalUserList.map(l -> l.get(1)));
        System.out.println(optionalUserList.map(List::size));



    }
}
