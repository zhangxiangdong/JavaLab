package me.zhang.coreJava.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Zhang on 2017/11/11 9:38.
 */
public class TestException {

    private static final String URL_BINGO = "http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=7&video=1";

    public static void main(String[] args) {
        String response = requestUrl(URL_BINGO);
        System.out.println(response);
    }

    private static String requestUrl(String targetUrl) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(targetUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);

            InputStream in = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } catch (MalformedURLException e) {
            System.err.println(e.getClass().getSimpleName());
        } catch (IOException e) {
            System.err.println(e.getClass().getName());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }

}
