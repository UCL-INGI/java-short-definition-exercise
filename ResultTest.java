package src;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import java.util.Random;
import java.text.MessageFormat;

import student.Translations.Translator;

import StudentCode.*;
import student.*;



public class Tests {

    @Test
    public void testLauncher(){
        // tests() pour l'instant
        tests();
    }

    // CONFIG_TEST_PARAMETERS
    // tests() pour l'instant  = tests
    public void tests(){
        PileInt pileint = new PileInt();
		pileint.push(1);
		assertTrue(Translator.translate("depth() should give 1"), 1 == pileint.depth());
		
		pileint.push(3);
		assertTrue(Translator.translate("depth() should give 2"), 2 == pileint.depth());
		
		assertTrue(Translator.translate("pop() should give 3"), 3 == pileint.pop());
		
		assertTrue(Translator.translate("pop() should give 1"), 1 == pileint.pop());
		
		try {
			pileint.pop();
			fail("pop on empty");
		} catch(IllegalStateException e){
		} catch(Exception e){
			fail("pop on empty");
		}
    }

}