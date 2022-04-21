
/**
 *  Copyright (c)  2016 Ludovic Taffin
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
        
        Temps temps0 = new Temps(23, 59, 59);
		Temps temps1 = new Temps(23, 59, 59);
		Temps temps2 = new Temps(23, 59, 59);
		Chanson chanson3 = new Chanson("Titre1", "Anonyme", new Temps(0,3,20));
		
        
        try {
            Temps.class.getDeclaredMethod("getH");
        } catch (NoSuchMethodException e){
            fail("You should have a method getH");
        }

        try{
		    assertTrue(
                "getH() with Temps(23, 59, 59) should give 23" + " | Your code returned : "  + temps0.getH(),
                23 == temps0.getH()
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        temps1.ajouter(new Temps(10, 20, 12));
        try {
            Temps.class.getDeclaredMethod("toString");
        } catch (NoSuchMethodException e){
            fail("You should have a method toString");
        }

        try{
		    assertTrue(
                "ajouter(Temps(10, 20, 12)) with Temps(23, 59, 59) should give \"10:20:11\"",
                "10:20:11".equals(temps1.toString())
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            Temps.class.getDeclaredMethod("apres", Temps.class);
        } catch (NoSuchMethodException e){
            fail("You should have a method apres");
        }

        try{
		    assertTrue(
                "apres(new Temps(10, 2, 0)) with Temps(23, 59, 59) should give true",
                true == temps2.apres(new Temps(10, 2, 0))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            Chanson.class.getDeclaredMethod("getTitre");
        } catch (NoSuchMethodException e){
            fail("You should have a method getTitre");
        }

        try{
		    assertTrue(
                "getTitre() with Chanson(\"Titre1\", \"Anonyme\", \"new Temps(0,3, 20)\") should give Titre1",
                "Titre1".equals(chanson3.getTitre())
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}