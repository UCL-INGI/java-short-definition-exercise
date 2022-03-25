package src;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import java.util.Random;
import java.text.MessageFormat;

import student.Translations.Translator;

import StudentCode.*;

import java.lang.reflect.*;


public class Tests {

    @Test
    public void testLauncher(){
        tests();
    }

    // CONFIG_TEST_PARAMETERS
    public void tests(){
        Temps tempsStudent = new Temps(23, 59, 59);
		Method getHeureStud = null;

		try {
			getHeureStud = Temps.class.getDeclaredMethod("getHeure");
		} catch (NoSuchMethodException e){
			fail("il vous faut une méthode getHeure");
		}

		assertTrue(Translator.translate("getHeure() with Temps(23, 59, 59) should give 23"), 23 == tempsStudent.getHeure());
		
		employeStudent = new Employe(0, 0, 0);
		assertTrue(Translator.translate("getHeure() with Temps(0, 0, 0) should give 0"), 0 == tempsStudent.getHeure());
		
    }

}