package me.zhang.java8;

/**
 * Created by zhangxiangdong on 2017/4/25.
 */
public class LambdaExpressionsTester {

    public static void main(String[] args) {
        LambdaExpressionsTester tester = new LambdaExpressionsTester();

        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 2 = " + tester.operate(10, 2, addition));
        System.out.println("10 - 2 = " + tester.operate(10, 2, subtraction));
        System.out.println("10 * 2 = " + tester.operate(10, 2, multiplication));
        System.out.println("10 / 2 = " + tester.operate(10, 2, division));

        GreetingService helloService = message -> System.out.println("Hello, " + message);
        GreetingService hiService = message -> System.out.println("Hi, " + message);
        helloService.sayMessage("Lucia!");
        hiService.sayMessage("Brad.");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

}
