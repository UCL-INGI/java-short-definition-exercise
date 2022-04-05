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
        tests();
    }

    public void tests(){
        Etudiant etudiant = new Etudiant();
		assertTrue(Translator.translate("The average with 1.0, 2.0 and 3.0 should be 2.0"), 2.0 == Etudiant.average(1.0,2.0,3.0));
		
		assertTrue(Translator.translate("The average with 0.0, 0.0 and 0.0 should be 0.0"), 0.0 == Etudiant.average(0.0,0.0,0.0));
		
    }

}