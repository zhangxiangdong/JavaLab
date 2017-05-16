package me.zhang.recursion;

import java.io.File;

/**
 * Created by zhangxiangdong on 2017/5/16.
 */
public class FileSystem {

    public long diskUsage(File root) {
        long totalSize = root.length();
        if (root.isDirectory()) {
            String[] list = root.list();
            if (list != null) {
                for (String childName : list) {
                    File child = new File(root, childName);
                    totalSize += diskUsage(child);
                }
            }
        }
        return totalSize;
    }

    public static void main(String[] args) {
        FileSystem system = new FileSystem();
        long diskUsage = system.diskUsage(new File(args[0]));
        System.out.println(diskUsage / 1e6 + " MB");
    }

}
