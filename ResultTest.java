package src;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import java.util.Random;
import java.text.MessageFormat;

import student.Translations.Translator;

import StudentCode.*;
import student.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Tests {

    @Test
    public void testLauncher(){
        // tests() pour l'instant
        tests();
    }

    // CONFIG_TEST_PARAMETERS
    // tests() pour l'instant  = tests
    public void tests(){
        Etudiant etudiant = new Etudiant();
		ByteArrayOutputStream baos;
		PrintStream ps;
		PrintStream old = System.out;
		String rep_student;
		
		baos = new ByteArrayOutputStream();
		ps = new PrintStream(baos);
		System.setOut(ps);
		Etudiant.main_1(new String[] {"Un"});
		System.out.flush();
		rep_student = baos.toString();
		assertTrue(Translator.translate("main_1() should give 1"), "Un\n".equals(rep_student));
		
		baos = new ByteArrayOutputStream();
		ps = new PrintStream(baos);
		System.setOut(ps);
		Etudiant.main_1(new String[] {"Un","Deux"});
		System.out.flush();
		rep_student = baos.toString();
		assertTrue(Translator.translate("main_1() should give 1"), "Un\nDeux\n".equals(rep_student));
		
		baos = new ByteArrayOutputStream();
		ps = new PrintStream(baos);
		System.setOut(ps);
		Etudiant.main_2(new String[] {"1","2"});
		System.out.flush();
		rep_student = baos.toString();
		assertTrue(Translator.translate("main_1() should give 3"), "3".equals(rep_student));
		
    }

}