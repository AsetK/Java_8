package _5_optional;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    // Optional — это контейнерный объект, который может содержать либо значение, либо быть пустым.
    // Он был введен в Java 8 и предназначен для предотвращения NullPointerException, улучшения читаемости кода и упрощения работы с отсутствующими значениями.
    //
    // Основные цели использования Optional:
    //  - Избежать прямого использования null для обозначения отсутствующих значений.
    //  - Обеспечить более чистый и выразительный код, особенно в случаях, когда необходимо проверить наличие значения.

    //      Rule #1: Never, ever, use null for Optional variable or Optional return value
    //      Rule #2: Never use Optional.get() unless you can prove that the Optional is present. Instead use one of the safe methods like orElse or ifPresent
    //      Rule #3: Prefer alternatives to Optional.isPresent() and Optional.get()
    //      Rule #4: Don't use Optional method parameter, instead just overload method
    //      Rule #5: Don't use it as field of class.
    //      Rule #6: Don't use orElse(null), instead use user.ifPresent(/* lambda expression or method reference */);
    //      Rule #7: Don't wrap collections with Optional. Don't use Optional as element of collection.

    //      Note: Optional is immutable. We can't set the value on optional after it's creation

    // Brian Goetz (Java Language Architect, Oracle Corporation):

    @Test
    public void of() {
        Optional<Object> optional = Optional.of(null); // NullPointerException if null
    }

    @Test
    public void ofNullable() {
        Optional<String> optionalString = Optional.ofNullable(null); // returns empty optional

        assert optionalString.isEmpty();
    }

    @Test
    public void orElse() {
        String asset = (String) Optional.ofNullable(null).orElse("Asset");
        System.out.println(asset);
    }

    @Test
    public void orElseGet() {
        String asset = (String) Optional.ofNullable(null).orElseGet(() -> "Asset");
        System.out.println(asset);
    }

    @Test
    public void orElseThrow() {
        String asset = (String) Optional.ofNullable(null).orElseThrow(RuntimeException::new);
    }

    @Test
    public void map() {
        Optional<Integer> length = Optional.ofNullable("Asset").map(String::length);
        length.ifPresent(System.out::println);
    }

    @Test
    public void map2() {
        String text = null;
        Optional<Integer> length = Optional.ofNullable(text).map(String::length);
        length.ifPresent(System.out::println);
    }

    @Test
    public void filter() {
        String text1 = "Asset";
        String nullText = null;

        Optional<String> stringOptional = Optional.ofNullable(text1);
        Optional<String> emptyOptional = Optional.ofNullable(nullText);

        System.out.println(stringOptional.filter(s -> s.equals("Asset")));
        System.out.println(emptyOptional.filter(s -> s.equals("Asset")));
    }

}
