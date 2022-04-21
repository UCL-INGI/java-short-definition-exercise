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
                "The average with 1.0, 2.0 and 3.0 should be 2.0",
                2.0 == etudiant.moye(1.0,2.0,3.0)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "The average with 0.0, 0.0 and 0.0 should be 0.0",
                0.0 == etudiant.moye(0.0,0.0,0.0)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}