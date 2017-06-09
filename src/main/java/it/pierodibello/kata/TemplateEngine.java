package it.pierodibello.kata;

import java.util.HashMap;

public class TemplateEngine {
    public String evaluate(String templateString, HashMap<String, String> variables) throws Exception {
        for (String key : variables.keySet()) {
            String expression = "{$" + key + "}";
            templateString = templateString.replace(expression, variables.get(key));
        }
        if (templateString.contains("{$")) {
            throw new MissingValueException();
        }
        return templateString;
    }
}
