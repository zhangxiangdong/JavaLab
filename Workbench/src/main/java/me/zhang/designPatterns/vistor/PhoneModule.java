package me.zhang.designPatterns.vistor;

/**
 * Created by zhangxiangdong on 2017/2/23.
 */
public interface PhoneModule {

    void accept(PhoneVisitor visitor);

}
