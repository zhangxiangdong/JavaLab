package me.zhang.designPatterns.vistor;

/**
 * Created by zhangxiangdong on 2017/2/23.
 */
public class AssemblyLine {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.accept(new QualityInspector());
    }

}
