package epam.optional;

import java.sql.SQLOutput;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        User user = new User();
        user.setName("First");

        Optional<User> optionalUser = Optional.ofNullable(null); // here null or user
        System.out.println(optionalUser.isPresent());

        optionalUser.ifPresent(u -> u.setName("Aset")); // Consumer - functional interface
        System.out.println(user);

        if(optionalUser.isPresent())
            System.out.println(optionalUser.get());
        System.out.println("================================================");





    }
}
