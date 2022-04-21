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
                "2016 is in the 21th century",
                21 == etudiant.century(2016)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "2020 is in the 20th century",
                20 == etudiant.century(2000)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "1900 is in the 19 century",
                19 == etudiant.century(1900)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "1001 is in the 11th century",
                11 == etudiant.century(1001)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "1099 is in the 11th century",
                11 == etudiant.century(1099)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "0 is in the century 0",
                0 == etudiant.century(0)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "1 is in the 1st century",
                1 == etudiant.century(1)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}