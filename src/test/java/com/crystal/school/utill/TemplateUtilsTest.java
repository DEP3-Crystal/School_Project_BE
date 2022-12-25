package com.crystal.school.utill;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

class TemplateUtilsTest {
    private static final String fileContent = "SELECT * FROM session WHERE id = {{sessionId}}";
    private static final String uri = FileUtils.getResourcesPath() + "test.txt";

    @BeforeAll
    static void beforeEach() throws IOException {
        Files.write(Path.of(uri), fileContent.getBytes());
    }

    @AfterAll
    static void cleanUp() {
        new File(uri).deleteOnExit();
    }

    @Test
    void injectVariables() {
        Map<String, String> templateMap = new HashMap<String, String>();
        templateMap.put("sessionId", "1");
        String result = TemplateUtils.injectVariables(fileContent,templateMap);
        Assertions.assertEquals("SELECT * FROM session WHERE id = 1", result);

    }
}