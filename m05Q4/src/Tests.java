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
                "mauvais resultat",
                true == etudiant.croissant(new int[]{1, 2, 3})
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "mauvais resultat",
                false == etudiant.croissant(new int[]{-3, -4, -5})
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}