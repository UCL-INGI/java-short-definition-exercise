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
                "fizzbuzz(1) should give non : " + etudiant.fizzbuzz(1),
                "non".equals(etudiant.fizzbuzz(1))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "fizzbuzz(3) should give fizz",
                "fizz".equals(etudiant.fizzbuzz(3))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "fizzbuzz(5) should give buzz",
                "buzz".equals(etudiant.fizzbuzz(5))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "fizzbuzz(15) should give fizzbuzz",
                "fizzbuzz".equals(etudiant.fizzbuzz(15))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "fizzbuzz(16) should give non",
                "non".equals(etudiant.fizzbuzz(16))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "fizzbuzz(18) should give fizz",
                "fizz".equals(etudiant.fizzbuzz(18))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "fizzbuzz(20) should give buzz",
                "buzz".equals(etudiant.fizzbuzz(20))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "fizzbuzz(30) should give fizzbuzz",
                "fizzbuzz".equals(etudiant.fizzbuzz(30))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}