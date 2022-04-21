package src;

import org.junit.Test;
import static org.junit.Assert.*;
import java.text.MessageFormat;

import student.Translations.Translator;

import StudentCode.*;
import student.*;

import java.util.Arrays;


public class Tests {

    @Test
    public void tests(){
        
        Etudiant etudiant = new Etudiant();
        

        try{
		    assertTrue(
                "You should have a 3x3 grid with 1 in the diagonal and 0 in others spot" + " | Your code returned : "  + etudiant.unite(3),
                Arrays.deepEquals(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, etudiant.unite(3))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}