package me.zhang.coreJava.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by zhangxiangdong on 2018/1/31.
 */
public class SocketTest {

    public static void main(String[] args) {
        try (Socket socket = new Socket("time-A.timefreq.bldrdoc.gov", 13)) {
            InputStream in = socket.getInputStream();
            Scanner scanner = new Scanner(in);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
