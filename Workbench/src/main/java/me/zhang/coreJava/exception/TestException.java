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
        try {
            String response = requestUrl(URL_BINGO);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String requestUrl(String targetUrl) throws IOException {
        HttpURLConnection conn = null;
        InputStream in = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(targetUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);

            in = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } catch (MalformedURLException e) {
            // rethrow wrapped exception
            throw new IOException("URL Error", e);
        } catch (IOException e) {
            // log then rethrow exception
            System.err.println(e.getClass().getName());
            throw e;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("Close InputStream Failed: " + e.getMessage());
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Close InputStream Failed: " + e.getMessage());
                }
            }
        }
    }

}
