package it.pierodibello.kata;

import java.util.HashMap;

public class Template {
    private String templateString;
    private HashMap<String, String> variables;

    public Template(String templateString) {
        this.templateString = templateString;
        variables = new HashMap<>();
    }

    public String evaluate() throws Exception {
        for (String key : variables.keySet()) {
            String expression = "{$" + key + "}";
            templateString = templateString.replace(expression, variables.get(key));
        }
        if (templateString.contains("{$")) {
            throw new MissingValueException();
        }
        return templateString;
    }

    public void set(String key, String value) {
        variables.put(key, value);
    }
}
