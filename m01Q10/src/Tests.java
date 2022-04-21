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
                "With 1, 2, 3 is ordonne but your code returns the opposite",
                true == etudiant.ordre(1, 2, 3)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "With 1, 2, 3 is not ordonne but your code returns the opposite",
                false == etudiant.ordre(3, 2, 1)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "With 1, 2, 3 is not ordonne but your code returns the opposite",
                false == etudiant.ordre(1, 3, 2)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "With 2, 1, 3 is not ordonne but your code returns the opposite",
                false == etudiant.ordre(2, 1, 3)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "With 1, -1, 3 is not ordonne but your code returns the opposite",
                false == etudiant.ordre(1, -1, 3)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "With 3, 3, 3 is not ordonne but your code returns the opposite",
                false == etudiant.ordre(3, 3, 3)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "With 1, 3, 3 is not ordonne but your code returns the opposite",
                false == etudiant.ordre(1, 3, 3)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "With 1, 1, 3 is not ordonne but your code returns the opposite",
                false == etudiant.ordre(1, 1, 3)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "With -1, 0, 3 is ordonne but your code returns the opposite",
                true == etudiant.ordre(-1, 0, 3)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "With 3, 3, 3 is not ordonne but your code returns the opposite",
                false == etudiant.ordre(3, 3, 3)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}