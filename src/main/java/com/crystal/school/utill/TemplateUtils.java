package com.crystal.school.utill;

import java.util.Map;

public class TemplateUtils {
    private static String temp = null;

    private TemplateUtils() {
    }

    public static String injectVariables(String template, Map<String, String> placeholder) {
        temp = template;
        placeholder.forEach((key, value) -> temp = temp.replaceAll("\\{\\{( *" + key + " *)\\}\\}", value));
        return temp;
    }
}
