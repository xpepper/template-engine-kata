package it.pierodibello.kata;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Matcher matcher = matches(".*(\\{\\$.+\\}).*");
        if (matcher.matches()) {
            throw new MissingValueException("No value for " + matcher.group(1));
        }
        return templateString;
    }

    private Matcher matches(String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(templateString);
    }

    public void set(String key, String value) {
        variables.put(key, value);
    }
}
