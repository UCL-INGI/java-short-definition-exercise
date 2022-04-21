package src;

import org.junit.Test;
import static org.junit.Assert.*;
import java.text.MessageFormat;

import student.Translations.Translator;

import StudentCode.*;
import student.*;

import java.util.Arrays;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Tests {

    @Test
    public void tests(){
        PrintStream old = System.out;
		String student_answer = "";
		
        Etudiant etudiant = new Etudiant();
        

        try{
		    ByteArrayOutputStream baos0 = new ByteArrayOutputStream();
		    PrintStream ps0 = new PrintStream(baos0);
		    System.setOut(ps0);
            etudiant.main_1(new String[]{"Un"});
            System.out.flush();
            System.setOut(old);

            student_answer = baos0.toString();
		    
		    assertTrue(
                "main_1() should give \"Un\n\"" + " | Your code returned : "  + student_answer,
                "Un\n".equals(student_answer)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
		    PrintStream ps1 = new PrintStream(baos1);
		    System.setOut(ps1);
            etudiant.main_1(new String[]{"Un","Deux"});
            System.out.flush();
            System.setOut(old);

            student_answer = baos1.toString();
		    
		    assertTrue(
                "main_1() should give 1",
                "Un\nDeux\n".equals(student_answer)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
		    PrintStream ps2 = new PrintStream(baos2);
		    System.setOut(ps2);
            etudiant.main_2(new String[]{"1","2"});
            System.out.flush();
            System.setOut(old);

            student_answer = baos2.toString();
		    
		    assertTrue(
                "main_2() should give 3",
                "3".equals(student_answer)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}