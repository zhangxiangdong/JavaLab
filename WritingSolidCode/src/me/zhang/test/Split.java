package me.zhang.test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Zhang on 2015/11/25 上午 10:24 .
 */
public class Split {

    public static void main(String[] args) {
        String path = "xxx";
        String[] paths = path.split(";");
        System.out.println(Arrays.toString(paths));
        List<String> pathList = Arrays.asList(paths);
        System.out.println(pathList);
    }

}
