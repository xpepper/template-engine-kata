package it.pierodibello.kata;

import java.util.HashMap;

public class TemplateEngine {
    public String evaluate(String templateString, HashMap<String, String> variables) {
        for (String key : variables.keySet()) {
            if (templateString.contains("{$" + key + "}")) {
                templateString = templateString.replace("{$name}", variables.get(key));
            }
        }
        return templateString;
    }
}
