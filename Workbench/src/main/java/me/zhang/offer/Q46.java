package me.zhang.offer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxiangdong on 2017/9/20.
 * <p>
 * 求1+2+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A ? B : C）。
 */
public class Q46 {

    private List<Boolean> switcher = new ArrayList<>();

    {
        switcher.add(false);
        switcher.add(true);
    }

    private Method[] methods = getClass().getMethods();

    public int sum(int n) throws InvocationTargetException, IllegalAccessException {
        int index = switcher.indexOf(n == 0);
        // n == 0为true，则调用terminator方法
        return n + (int) (methods[index].invoke(this, --n));
    }

    public int terminator(int n) {
        return 0;
    }

}
