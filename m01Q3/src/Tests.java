package src;

import org.junit.Test;
import static org.junit.Assert.*;
import java.text.MessageFormat;

import student.Translations.Translator;

import StudentCode.*;
import student.*;



public class Tests {

    @Test
    public void tests(){
        
        Etudiant etudiant = new Etudiant();
        

        try{
		    assertTrue(
                "2m and 80kg should give normal",
                "normal".equals(etudiant.quetelet(2, 80))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "2m and 100kg should give normal",
                "normal".equals(etudiant.quetelet(2, 100))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "2m and 120kg should give embonpoint",
                "embonpoint".equals(etudiant.quetelet(2, 120))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "2m and 200kg should give obèse",
                "obèse".equals(etudiant.quetelet(2, 200))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}