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
        
        BioInfo bioinfo = new BioInfo();
        
        
        
        try {
            BioInfo.class.getDeclaredMethod("isADN", String.class);
        } catch (NoSuchMethodException e){
            fail("You should have a method isADN");
        }

        try{
		    assertTrue(
                "isADN(\"AT\") should give true",
                true == bioinfo.isADN("AT")
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            BioInfo.class.getDeclaredMethod("testIsADN");
        } catch (NoSuchMethodException e){
            fail("You should have a method testIsADN");
        }

        try {
			bioinfo.testIsADN();
		} catch (AssertionError e){
			fail("vos tests pour testIsADN ne passent pas");
		}
		
        
        try {
            BioInfo.class.getDeclaredMethod("count", String.class, char.class);
        } catch (NoSuchMethodException e){
            fail("You should have a method count");
        }

        try{
		    assertTrue(
                "isADN(\"AT\", 'A') should give 1",
                1 == bioinfo.count("AT", 'A')
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            BioInfo.class.getDeclaredMethod("count", String.class, char.class);
        } catch (NoSuchMethodException e){
            fail("You should have a method count");
        }

        try{
		    assertTrue(
                "isADN(\"TCT\", 'A) should give 0",
                0 == bioinfo.count("TCT", 'A')
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            BioInfo.class.getDeclaredMethod("testCount");
        } catch (NoSuchMethodException e){
            fail("You should have a method testCount");
        }

        try {
			bioinfo.testCount();
		} catch (AssertionError e){
			fail("vos tests pour testIsADN ne passent pas");
		}
		
        
        try {
            BioInfo.class.getDeclaredMethod("distanceH", String.class, String.class);
        } catch (NoSuchMethodException e){
            fail("You should have a method distanceH");
        }

        try{
		    assertTrue(
                "isADN(\"AT\", \"AT\") should give 0",
                0 == bioinfo.distanceH("AT", "AT")
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            BioInfo.class.getDeclaredMethod("distanceH", String.class, String.class);
        } catch (NoSuchMethodException e){
            fail("You should have a method distanceH");
        }

        try{
		    assertTrue(
                "distanceH(\"TCT\", \"TGA\") should give 2",
                2 == bioinfo.distanceH("TCT", "TGA")
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            BioInfo.class.getDeclaredMethod("testDistanceH");
        } catch (NoSuchMethodException e){
            fail("You should have a method testDistanceH");
        }

        try {
			bioinfo.testDistanceH();
		} catch (AssertionError e){
			fail("vos tests pour testIsADN ne passent pas");
		}
		
    }

}