package src;

import org.junit.Test;
import static org.junit.Assert.*;
import java.text.MessageFormat;

import student.Translations.Translator;

import StudentCode.*;
import student.*;

import java.lang.reflect.*;


public class Tests {

    @Test
    public void tests(){
        
        Employe employe0 = new Employe("Employe1", 1000);
		Employe employe1 = new Employe("Anatole", 1500);
		Employe employe2 = new Employe("Anatole", 1500);
		Employe employe3 = new Employe("Employe1", 1000);
		Employe employe4 = new Employe("Employe1", 1000);
		
        
        
        try {
            Employe.class.getDeclaredMethod("getNom");
        } catch (NoSuchMethodException e){
            fail("You should have a method getNom");
        }

        try{
		    assertTrue(
                "getNom() with Employe(\"Employe1\", 1000) should give \"Employe1\"",
                "Employe1".equals(employe0.getNom())
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            Employe.class.getDeclaredMethod("getSalaire");
        } catch (NoSuchMethodException e){
            fail("You should have a method getSalaire");
        }

        try{
		    assertTrue(
                "getSalaire() with Employe(\"Anatole\", 1500) should give 1500" + " | Your code returned : "  + employe1.getSalaire(),
                1500 == employe1.getSalaire()
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            Employe.class.getDeclaredMethod("toString");
        } catch (NoSuchMethodException e){
            fail("You should have a method toString");
        }

        try{
		    assertTrue(
                "toString() with Employe(\"Anatole\", 1500) should give \"Anatole : 1500\"",
                "Anatole : 1500.0".equals(employe2.toString())
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            Employe.class.getDeclaredMethod("toString");
        } catch (NoSuchMethodException e){
            fail("You should have a method toString");
        }

        try{
		    assertTrue(
                "toString() with Employe(\"Employe1\", 1000) should give \"Employe1 : 1000\"",
                "Employe1 : 1000.0".equals(employe3.toString())
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        employe4.augmente(10.0);
        try {
            Employe.class.getDeclaredMethod("getSalaire");
        } catch (NoSuchMethodException e){
            fail("You should have a method getSalaire");
        }

        try{
		    assertTrue(
                "augemente(10) with Employe(\"Employe1\", 1000) should give 1100",
                1100 == employe4.getSalaire()
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}