package me.zhang.designPatterns.vistor;

/**
 * Created by zhangxiangdong on 2017/2/23.
 */
public class SimCard implements PhoneModule {
    @Override
    public void accept(PhoneVisitor visitor) {
        visitor.visit(this);
    }

    public int getSmsCapacities() {
        return 256;
    }

    public int getPhoneNumberCapacities() {
        return 1000;
    }

}
