package it.pierodibello.kata;

import java.util.HashMap;

public class TemplateEngine {
    public String evaluate(String templateString, HashMap<String, String> variables) {
        for (String key : variables.keySet()) {
            String expression = "{$" + key + "}";
            if (templateString.contains(expression)) {
                templateString = templateString.replace(expression, variables.get(key));
            }
        }
        return templateString;
    }
}
