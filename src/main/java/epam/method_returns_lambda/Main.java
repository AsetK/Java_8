package epam.method_returns_lambda;

public class Main {
    public static void main(String[] args) {
        System.out.println(getOperations('+').getResult(10,5));
        System.out.println(getOperations('-').getResult(10,5));
        System.out.println(getOperations('*').getResult(10,5));
        System.out.println(getOperations('/').getResult(10,5));

    }

    public static Operations getOperations(char symbol)
    {
        switch (symbol)
        {
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
