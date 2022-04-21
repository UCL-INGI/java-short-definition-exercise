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
                "mediane(5, 7, 9) should give 7",
                7 == etudiant.mediane(5, 7, 9)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "mediane(12, 5, 7) should give 7",
                7 == etudiant.mediane(12, 5, 7)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "mediane(5, 3, 4) should give 4",
                4 == etudiant.mediane(5, 3, 4)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "mediane(5, 3, 4) should give 4",
                4 == etudiant.mediane(4, 4, 4)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}