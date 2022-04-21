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
        
        Pair pair0 = new Pair(12, 3);
		
        

        try{
		    assertTrue(
                "opposite of Pair(12, 3) should return Pair(-12,-3)",
                new Pair(-12,-3).equals(pair0.opposite())
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}