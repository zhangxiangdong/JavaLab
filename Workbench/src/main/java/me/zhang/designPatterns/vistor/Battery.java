package me.zhang.designPatterns.vistor;

/**
 * Created by zhangxiangdong on 2017/2/23.
 */
public class Battery implements PhoneModule {
    @Override
    public void accept(PhoneVisitor visitor) {
        visitor.visit(this);
    }

    public String getBatteryModel() {
        return "MT002";
    }

    public int getCapacities() {
        return 2300;
    }

}
