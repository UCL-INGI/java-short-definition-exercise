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
                "The sec_min result with 20:03:14 should be 72194",
                72194 == etudiant.sec_min(20,3,14)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}




        try{
		    assertTrue(
                "The sec_min result with 00:01:17 should be 77",
                77 == etudiant.sec_min(0,1,17)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}




        try{
		    assertTrue(
                "The sec_min result with 01:01:17 should be 3677",
                3677 == etudiant.sec_min(1,1,17)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}




        try{
		    assertTrue(
                "The sec_min result with 15:56:57 should be 57417",
                57417 == etudiant.sec_min(15,56,57)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "The toSeconds result with 00:00:00 should be 0",
                0 == etudiant.sec_min(0,0,0)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}