package me.zhang.designPatterns.vistor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangxiangdong on 2017/2/23.
 */
public class Phone implements PhoneModule {

    List<PhoneModule> phoneModules;

    public Phone() {
        phoneModules = new ArrayList<>();
        phoneModules.add(new SimCard());
        phoneModules.add(new Battery());
    }

    @Override
    public void accept(PhoneVisitor visitor) {
        visitor.visit(this);
        for (PhoneModule module : phoneModules) {
            module.accept(visitor);
        }
    }

    public String getModel() {
        return "Huawei";
    }

    public String getManufacturingDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(new Date());
    }

}
