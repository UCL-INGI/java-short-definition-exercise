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
        
        Queue queue = new Queue();
        queue.ajoute(1);

        try{
		    assertTrue(
                "ajoute(1) did not work",
                "1 | ".equals(queue.toString())
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        queue.ajoute(3);

        try{
		    assertTrue(
                "ajoute(3) did not work",
                "1 | 3 | ".equals(queue.toString())
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "retire() should give 3",
                3 == queue.retire()
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "retire() should give 1",
                1 == queue.retire()
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "retire on empty",
                -1 == queue.retire()
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}