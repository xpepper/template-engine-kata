package it.pierodibello.kata;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TemplateEngineTest {

    private TemplateEngine templateEngine;
    private HashMap<String, String> variables;

    @Before
    public void setUp() throws Exception {
        templateEngine = new TemplateEngine();
        variables = new HashMap<>();
    }

    @Test
    public void string_with_no_template_variables_transforms_to_the_very_same_string() throws Exception {
        String result = templateEngine.evaluate("Hi There!", new HashMap<>());

        assertEquals("Hi There!", result);
    }

    @Test
    public void replaces_a_single_variable_expression_in_the_template_with_its_value() throws Exception {
        variables.put("name", "Pietro");

        String result = templateEngine.evaluate("Hi {$name}!", variables);

        assertEquals("Hi Pietro!", result);
    }

    @Test
    public void replaces_multiple_variable_expressions_in_the_template_with_their_values() throws Exception {
        variables.put("name", "Pietro");
        variables.put("surname", "Di Bello");

        String result = templateEngine.evaluate("Hi {$name} {$surname}!", variables);

        assertEquals("Hi Pietro Di Bello!", result);
    }
}
