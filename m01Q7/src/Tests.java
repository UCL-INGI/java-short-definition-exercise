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
                "sumFirstEvenIntegers(1) should give 0" + " | Your code returned : "  + etudiant.sumFirstEvenIntegers(1),
                0 == etudiant.sumFirstEvenIntegers(1)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "sumFirstEvenIntegers(3) should give 2",
                2 == etudiant.sumFirstEvenIntegers(3)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "sumFirstEvenIntegers(5) should give 6",
                6 == etudiant.sumFirstEvenIntegers(5)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "sumFirstEvenIntegers(10) should give 30",
                30 == etudiant.sumFirstEvenIntegers(10)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}