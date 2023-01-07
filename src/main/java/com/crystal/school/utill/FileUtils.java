package com.crystal.school.utill;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class FileUtils {
    private FileUtils() {
    }

    public static String readResource(String resource) {
        var name = extractFileName(resource);
        var resourcesStream = getResourcesPath() + name;
        try {
            return Files.readString(Path.of(resourcesStream));
        } catch (IOException e) {
            RuntimeException runtimeException = new RuntimeException();
            runtimeException.setStackTrace(e.getStackTrace());
            throw runtimeException;
        }
    }


    public static Properties loadProperties(String fileName) {
        var properties = new Properties();
        var name = extractFileName(fileName);
        var url = getResourcesPath() + name;
        try (var inputStream = new FileInputStream(url)) {
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            RuntimeException runtimeException = new RuntimeException();
            runtimeException.setStackTrace(e.getStackTrace());
            throw runtimeException;
        }
    }

    private static String extractFileName(String fileName) {
        var startsWithSlash = fileName.startsWith("/") || fileName.startsWith("\\");
        if (startsWithSlash)
            return fileName.substring(1);
        return fileName;
    }

    public static String getResourcesPath() {
        var path = FileUtils.class.getResource("/").getPath();
        return normalizePath(path) + "\\";
    }

    private static String normalizePath(String path) {
        return new File(path).getPath();
    }

}
