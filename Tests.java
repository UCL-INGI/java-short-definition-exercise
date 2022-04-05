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
        Pair pairStudent = new Pair(12, 3);
		assertTrue(Translator.translate("opposite of Pair(12, 3) should return Pair(-12,-3)"), new Pair(-12,-3).equals(pair.opposite()));
		
    }

}