package it.pierodibello.kata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TemplateEngineTest {

    private TemplateEngine templateEngine;

    @Before
    public void setUp() throws Exception {
        templateEngine = new TemplateEngine();
    }

    @Test
    public void string_with_no_template_variables_transforms_to_the_very_same_string() throws Exception {
        String result = templateEngine.evaluate("Hi There!");

        assertEquals("Hi There!", result);
    }
}
