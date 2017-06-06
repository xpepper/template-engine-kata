package it.pierodibello.kata;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TemplateEngineTest {

    private TemplateEngine templateEngine;

    @Before
    public void setUp() throws Exception {
        templateEngine = new TemplateEngine();
    }

    @Test
    public void string_with_no_template_variables_transforms_to_the_very_same_string() throws Exception {
        String result = templateEngine.evaluate("Hi There!", new HashMap<>());

        assertEquals("Hi There!", result);
    }

    @Test
    public void replaces_a_single_variable_in_the_template_with_its_value() throws Exception {
        HashMap<String, String> variables = new HashMap<>();
        variables.put("name", "Pietro");

        String result = templateEngine.evaluate("Hi {$name}!", variables);

        assertEquals("Hi Pietro!", result);
    }
}
