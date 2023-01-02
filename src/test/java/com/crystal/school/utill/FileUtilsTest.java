package com.crystal.school.utill;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileUtilsTest {
    private static final String fileContent = "key=value";
    private static final String uri = FileUtils.getResourcesPath() + "test.txt";

    @BeforeAll
    static void beforeEach() throws IOException {
        Files.write(Path.of(uri), fileContent.getBytes());
    }

    @Test
    void readResource() {
        String result = FileUtils.readResource("test.txt");
        assertEquals(fileContent, result);
    }

    @Test
    void readResourceNotFound() {
        assertThrows(RuntimeException.class, () -> FileUtils.readResource(("not-found.txt")));
    }

    @Test
    void getPropertiesFile() {
        Properties result = FileUtils.loadProperties("test.txt");
        assertEquals("value", result.getProperty("key"));
    }

}