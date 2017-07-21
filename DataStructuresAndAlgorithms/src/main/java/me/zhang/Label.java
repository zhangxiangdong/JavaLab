package me.zhang;

public class Label {
    public static void main(String[] args) { // 打印单数
        outer:
        for (int i = 1; i < 10; i++) {
            inner:
            for (int j = 1; j < 10; j++) {
                System.out.println(i + ":" + j);
                if (0 == j % 5) break outer;
                else if (j % 3 == 0) break inner;
            }
        }
    }
}
