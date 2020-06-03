package me.zhang.coreJava.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangxiangdong on 2018/1/31.
 */
public class SocketTest {

    public static void main(String[] args) {
        final String host = "time-A.timefreq.bldrdoc.gov";
        final int port = 13;

        try {
            System.out.println(InetAddress.getByName(host));
            System.out.println(Arrays.toString(InetAddress.getAllByName("baidu.com")));
            System.out.println(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try (Socket socket = new Socket(host, port)) {
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
