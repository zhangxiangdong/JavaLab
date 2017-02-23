package me.zhang.designPatterns.vistor;

/**
 * Created by zhangxiangdong on 2017/2/23.
 */
public interface PhoneVisitor {

    void visit(Phone phone);

    void visit(Battery battery);

    void visit(SimCard simCard);

}
