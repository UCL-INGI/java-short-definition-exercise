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
        
        PileInt pileint = new PileInt();
        pileint.push(1);

        try{
		    assertTrue(
                "depth() should give 1",
                1 == pileint.depth()
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        pileint.push(3);

        try{
		    assertTrue(
                "depth() should give 2",
                2 == pileint.depth()
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "pop() should give 3",
                3 == pileint.pop()
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "pop() should give 1",
                1 == pileint.pop()
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try {
			pileint.pop();
			fail("You did not catch IllegalStateException");
		} catch (IllegalStateException e){
		} catch (Exception e){
		    fail("Unexpected exception");
		}
		
    }

}