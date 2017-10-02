package me.zhang.coreJava;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Zhang on 10/2/2017 12:01 PM.
 */
public class FileIO {

    public static void main(String[] args) {
        // Read from file
        String filePath = System.getProperty("user.dir") + "/Workbench/src/main/java/me/zhang/coreJava";
        Scanner scanner = null;
        try {
            scanner = new Scanner(Paths.get(filePath + "/inFile.txt"));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        // Write to file
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filePath + "/outFile.txt");
            scanner = new Scanner(System.in);
            do {
                System.out.println("Write something to outFile.txt?");
                String nextLine = scanner.nextLine();
                if ("exit".equalsIgnoreCase(nextLine)) {
                    System.out.println("EXIT!");
                    break;
                }
                writer.println(nextLine);
            } while (true);
            // Flushes all lines
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
