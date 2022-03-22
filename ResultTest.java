package src;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import java.util.Random;
import java.text.MessageFormat;

import student.Translations.Translator;

import StudentCode.*;



public class Tests {

    @Test
    public void testLauncher(){
        tests();
    }

    // CONFIG_TEST_PARAMETERS
    public void tests(){
        assertTrue(Translator.translate("isADN(\"\") should give false"), false == Etudiant.egal(new double[] {0.1, 0.2}, new double[] {0.4, 0.5}));
		assertTrue(Translator.translate("isADN(\"\") should give false"), true == Etudiant.egal(new double[] {0.1, 0.2}, new double[] {0.1, 0.2}));
		assertTrue(Translator.translate("isADN(\"\") should give false"), false == Etudiant.egal(new double[] {0.4, 0.2}, new double[] {0.4, 0.5}));
		assertTrue(Translator.translate("isADN(\"\") should give false"), false == Etudiant.egal(new double[] {0.2, 0.5}, new double[] {0.4, 0.5}));
    }

}