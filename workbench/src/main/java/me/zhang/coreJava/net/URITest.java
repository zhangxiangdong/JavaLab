package me.zhang.coreJava.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhangxiangdong on 2018/2/2.
 */
public class URITest {

    public static void main(String[] args) {
        testMethodsInURLConnection();
        printBaiduResponse();
    }

    private static void printBaiduResponse() {
        try {
            URL url = new URL("https://www.baidu.com/");
            try (InputStream is = url.openStream();
                 InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader br = new BufferedReader(isr)) {
                String l;
                while ((l = br.readLine()) != null) {
                    System.out.println(l);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testMethodsInURLConnection() {
        try {
            URL url = new URL("https://www.baidu.com/");
            URLConnection connection = url.openConnection();
            connection.connect();

            Map<String, List<String>> headerFields = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();
                for (String value : values) {
                    System.out.println(key + ": " + value);
                }
            }

            System.out.println("****************");

            SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            System.out.println("Last-Modified: " + sdf.format(new Date(connection.getLastModified())));

            System.out.println("Content-Type: " + connection.getContentType());
            System.out.println("Content-Length: " + connection.getContentLength());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
