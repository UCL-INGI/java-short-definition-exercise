package src;

import org.junit.Test;
import static org.junit.Assert.*;
import java.text.MessageFormat;

import student.Translations.Translator;

import StudentCode.*;
import student.*;

{{ ADDITIONAL_IMPORTS }}

public class Tests {

    @Test
    public void tests(){
        {{ PREVIOUS_CODE }}
        {{ STUDENT_INSTANCE }}
        {%- for test in tests %}
        {% if "hidden" not in test or not test["hidden"] %}
        {%- if "previousCalls" in test -%}{{ instancesToCall[loop.index0] }}.{{ test.previousCalls }};{% endif %}

        {%- if askFor == "class" %}
        try {
            {{ namesAsk[loop.index0] }}.class.getDeclaredMethod("{{ testsName[loop.index0] }}");
        } catch (NoSuchMethodException e){
            fail("You should have a method {{ testsName[loop.index0] }}");
        }
        {%- endif %}

        {% if test["test"].startswith("test") -%}
        try {
			{{ instancesToCall[loop.index0] }}.{{ test.test }};
		} catch (AssertionError e){
			fail("vos tests pour testIsADN ne passent pas");
		}
		{% elif "exceptionExpected" in test and test["exceptionExpected"] -%}
        try {
			{{ instancesToCall[loop.index0] }}.{{ test.test }};
			fail("You did not catch {{ test.exceptionExpected }}");
		} catch ({{ test.exceptionExpected }} e){
		} catch (Exception e){
		    fail("Unexpected exception");
		}
		{% else -%}
		try{
		    {%- if "checkConsole" in test and test["checkConsole"] %}
		    ByteArrayOutputStream baos{{loop.index0}} = new ByteArrayOutputStream();
		    PrintStream ps{{loop.index0}} = new PrintStream(baos{{loop.index0}});
		    System.setOut(ps{{loop.index0}});
            {{ instancesToCall[loop.index0] }}.{{ test.test }};
            System.out.flush();
            System.setOut(old);

            student_answer = baos{{loop.index0}}.toString();
		    {% endif %}
		    assertTrue(
                {{ errorsFeedbacks[loop.index0] }},
                {{ assertionsResults[loop.index0] }}
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        {% endif -%}
        {% endif -%}
        {%- endfor %}
    }

}