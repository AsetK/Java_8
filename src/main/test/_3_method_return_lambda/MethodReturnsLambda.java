package _3_method_return_lambda;

import org.junit.Test;

public class MethodReturnsLambda {

    @Test
    public void test() {
        System.out.println(getOperations('+').getResult(10,5));
        System.out.println(getOperations('-').getResult(10,5));
        System.out.println(getOperations('*').getResult(10,5));
        System.out.println(getOperations('/').getResult(10,5));
    }

    public static Operations getOperations(char symbol) {
        switch (symbol) {
            case '+':
                return (value1, value2) -> value1 + value2;
            case '-':
                return (value1, value2) -> value1 - value2;
            case '*':
                return (value1, value2) -> value1 * value2;
            case '/':
                return (value1, value2) -> value1 / value2;
            default:
                return (value1, value2) -> 0;

        }
    }
}
