package src;

import org.junit.Test;
import static org.junit.Assert.*;
import java.text.MessageFormat;

import student.Translations.Translator;

import StudentCode.*;
import student.*;

import java.io.*;


public class Tests {

    @Test
    public void tests(){
        BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(new File("./StudentCode/Etudiant.class")));
		} catch (Exception e){
			fail("Unexpected Exception");
		}

		if (!br.lines().anyMatch(s -> s.trim().contains("BufferedReader"))) { fail("BufferedReader expected"); }
		if (!br.lines().anyMatch(s -> s.trim().contains("close"))) { fail("close() expected"); }

		
        Etudiant etudiant = new Etudiant();
        

        try{
		    assertTrue(
                "Il y avait 79 lignes dans le fichier test.txt",
                79 == etudiant.countLines("./file1")
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "Il faut return -1 en cas d'exception",
                -1 == etudiant.countLines("./fakeFile")
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}