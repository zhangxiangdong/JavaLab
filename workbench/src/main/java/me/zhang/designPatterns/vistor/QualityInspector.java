package me.zhang.designPatterns.vistor;

/**
 * Created by zhangxiangdong on 2017/2/23.
 */
public class QualityInspector implements PhoneVisitor {
    @Override
    public void visit(Phone phone) {
        System.out.println(phone.getModel() + ", " + phone.getManufacturingDate());
    }

    @Override
    public void visit(Battery battery) {
        System.out.println(battery.getBatteryModel() + ", " + battery.getCapacities() + "mah");
    }

    @Override
    public void visit(SimCard simCard) {
        System.out.println(simCard.getPhoneNumberCapacities() + " + " + simCard.getSmsCapacities());
    }
}
