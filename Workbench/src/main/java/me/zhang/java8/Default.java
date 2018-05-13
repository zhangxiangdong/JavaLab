package me.zhang.java8;

public class Default {

    interface Alpha {

        default void print() {
            System.out.println("Alpha");
        }

        default void helloFromAlpha() {
            System.out.println("Hello from alpha");
        }

    }

    interface Beta {

        default void print() {
            System.out.println("Beta");
        }

    }

    interface Gamma {
        default String test() {
            return "default value";
        }
    }

    static class Tim implements Alpha, Beta, Gamma {

        // 实现的两个接口中的默认方法签名一直，子类必须重写该方法
        @Override
        public void print() {
            System.out.println("Tim");
        }

    }

    public static void main(String[] args) {
        Tim tim = new Tim();
        tim.print();
        System.out.println(tim.test());

        Alpha alpha = new Tim();
        alpha.print();
        alpha.helloFromAlpha();

        Beta beta = new Tim();
        beta.print();
    }

}
