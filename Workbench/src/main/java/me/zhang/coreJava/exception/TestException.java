package me.zhang.coreJava.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

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
        printStackTrace();
        printAllStackTrace();
    }

    private static void printStackTrace() {
        System.out.println("\n************Print Out Stack Trace Of Current Thread************");
        Throwable throwable = new Throwable();
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        for (StackTraceElement e : stackTrace) {
            System.out.println(e);
        }
    }

    private static void printAllStackTrace() {
        System.out.println("\n************Print Out All Stack Trace************");
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        for (Thread t : allStackTraces.keySet()) {
            StackTraceElement[] stackTraceElements = allStackTraces.get(t);
            for (StackTraceElement e : stackTraceElements) {
                System.out.println(e);
            }
        }
    }

    private static String requestUrl(String targetUrl) throws IOException {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(targetUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);

            // try auto closeable resources
            try (InputStream in = conn.getInputStream()) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    return response.toString();
                }
            }
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
        }
    }

}
