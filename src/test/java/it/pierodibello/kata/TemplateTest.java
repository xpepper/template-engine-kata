package it.pierodibello.kata;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TemplateTest {

    private Template template;

    @Test
    public void string_with_no_template_variables_transforms_to_the_very_same_string() throws Exception {
        String result = new Template("Hi There!").evaluate();

        assertEquals("Hi There!", result);
    }

    @Test
    public void replaces_a_single_variable_expression_in_the_template_with_its_value() throws Exception {
        template = new Template("Hi {$name}!");
        template.set("name", "Pietro");

        String result = template.evaluate();

        assertEquals("Hi Pietro!", result);
    }

    @Test
    public void replaces_multiple_variable_expressions_in_the_template_with_their_values() throws Exception {
        template = new Template("Hi {$name} {$surname}!");

        template.set("name", "Pietro");
        template.set("surname", "Di Bello");

        String result = template.evaluate();

        assertEquals("Hi Pietro Di Bello!", result);
    }

    @Test
    public void gives_error_if_template_variable_does_not_exist_in_the_map() throws Exception {
        try {
            new Template("No value for {$foo}").evaluate();
            fail("should throw exception since foo variable in the template is not bound to any variable set");
        } catch (Exception expected) {
            assertEquals(MissingValueException.class, expected.getClass());
            assertEquals("No value for {$foo}", expected.getMessage());
        }
    }

    @Test
    public void ignores_missing_variables() throws Exception {
        template = new Template("Hi there!");
        template.set("unbound", "anytext");

        String result = template.evaluate();

        assertEquals("Hi there!", result);
    }

    @Test
    public void replaces_all_occurrences_of_the_same_template_variable() throws Exception {
        template = new Template("Hi {$name}! How are you {$name}?");
        template.set("name", "Pietro");

        String result = template.evaluate();

        assertEquals("Hi Pietro! How are you Pietro?", result);
    }
}
