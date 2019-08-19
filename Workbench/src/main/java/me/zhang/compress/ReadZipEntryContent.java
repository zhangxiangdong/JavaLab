package me.zhang.compress;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.file.Files;
import java.util.Properties;

/**
 * Created by zhangxiangdong on 2019/8/19 16:53.
 */
public class ReadZipEntryContent {

    private static final String YAPATCH_MF = "YAPATCH.MF";

    public static void main(String[] args) throws IOException, ArchiveException {
        File file = new File("D:\\patch_signed.apk");
        String format = detectFormat(file);
        System.out.println("File format: " + format);
        System.out.println("**********************");

        Properties properties = new Properties();

        switch (format) {
            case ArchiveStreamFactory.ZIP:
                parseZipFile(file, properties);
                break;
            case ArchiveStreamFactory.SEVEN_Z:
                parseSevenZipFile(file, properties);
                break;
        }

        System.out.println("VersionName: " + properties.getProperty("VersionName"));
        System.out.println("VersionCode: " + properties.getProperty("VersionCode"));
        System.out.println("From: " + properties.getProperty("From"));
        System.out.println("To: " + properties.getProperty("To"));
    }

    private static void parseZipFile(File file, Properties properties) throws IOException {
        ZipFile zipFile = new ZipFile(file);
        ZipArchiveEntry zipFileEntry = zipFile.getEntry(YAPATCH_MF);
        InputStream inputStream = zipFile.getInputStream(zipFileEntry);

        ByteArrayOutputStream contentBytes = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            contentBytes.write(buffer, 0, bytesRead);
        }
        String content = contentBytes.toString("UTF-8");
//        System.out.println(content);

        properties.load(new StringReader(content));
    }

    private static void parseSevenZipFile(File file, Properties properties) throws IOException {
        try (SevenZFile archiveFile = new SevenZFile(file)) {
            SevenZArchiveEntry entry;
            while ((entry = archiveFile.getNextEntry()) != null) {
                String name = entry.getName();
                if (entry.isDirectory()) {
                    System.out.println(String.format("Found directory entry %s", name));
                } else {
                    if (YAPATCH_MF.equals(name)) {
                        ByteArrayOutputStream contentBytes = new ByteArrayOutputStream();

                        byte[] buffer = new byte[2048];
                        int bytesRead;
                        while ((bytesRead = archiveFile.read(buffer)) != -1) {
                            contentBytes.write(buffer, 0, bytesRead);
                        }
                        String content = contentBytes.toString("UTF-8");
//                        System.out.println(content);

                        properties.load(new StringReader(content));
                        break;
                    }
                }
            }
        }
    }

    private static String detectFormat(@NotNull File f) throws ArchiveException, IOException {
        try (final InputStream fis = new BufferedInputStream(Files.newInputStream(f.toPath()))) {
            return ArchiveStreamFactory.detect(fis);
        }
    }

}
