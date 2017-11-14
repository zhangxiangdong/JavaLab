package me.zhang.coreJava.generic;

import java.util.Date;

/**
 * Created by zhangxiangdong on 2017/11/14.
 */
public class DateInterval extends Pair<Date> {

    @Override
    public void setSecond(Date second) {
        if (second.compareTo(getFirst()) > 0) {
            super.setSecond(second);
        }
    }
}
