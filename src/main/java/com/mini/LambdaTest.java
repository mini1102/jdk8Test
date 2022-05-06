package com.mini;

public class LambdaTest {
    public static void main(String args[]) {
        LambdaTest tester = new LambdaTest();
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);
        // 用括号
        GreetingService greetService2 = (message) -> {
            System.out.println("Hello " + message);
            System.out.println("Hello2 " + message);
        } ;
        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");

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
