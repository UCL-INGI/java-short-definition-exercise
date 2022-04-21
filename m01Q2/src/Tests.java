/**
 *  Copyright (c)  2016 Ludovic Taffin, 2017 Olivier Martin
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



public class Tests {

    @Test
    public void tests(){
        
        Etudiant etudiant = new Etudiant();
        

        try{
		    assertTrue(
                "amende(50, 55) should give 25",
                25 == etudiant.amende(50, 55)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "amende(50, 62) should give 120",
                120 == etudiant.amende(50, 62)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "amende(50, 50) should give 0",
                0 == etudiant.amende(50, 50)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "amende(50, 40) should give 0",
                0 == etudiant.amende(50, 40)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}