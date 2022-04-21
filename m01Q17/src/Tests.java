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
                "2016 is a leap year but your code returns the opposite",
                true == etudiant.bissextile(2016)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "2015 is not a leap year but your code returns the opposite",
                false == etudiant.bissextile(2015)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "1990 is not a leap year but your code returns the opposite",
                false == etudiant.bissextile(1990)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "2000 is a leap year but your code returns the opposite",
                true == etudiant.bissextile(2000)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "1990 is not a leap year but your code returns the opposite",
                false == etudiant.bissextile(1900)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "2042 is not a leap but your code returns the opposite",
                false == etudiant.bissextile(2042)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "2020 is a leap year but your code returns the opposite",
                true == etudiant.bissextile(2020)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "2024 is a leap year but your code returns the opposite",
                true == etudiant.bissextile(2024)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "2028 is a leap year but your code returns the opposite",
                true == etudiant.bissextile(2028)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "2032 is a leap year but your code returns the opposite",
                true == etudiant.bissextile(2032)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "100 is not a leap year but your code returns the opposite",
                false == etudiant.bissextile(100)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "400 is a leap year but your code returns the opposite",
                true == etudiant.bissextile(400)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "4 is a leap year but your code returns the opposite",
                true == etudiant.bissextile(4)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}