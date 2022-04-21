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
                "With 5, 10, 15 and 20, min should give 5",
                5 == etudiant.min(5, 10, 15, 20)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "With 0, 15, -10 and 5, min should give -10",
                -10 == etudiant.min(0, 15, -10, 5)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "With -5, -10, -15 and -20, min should give -20",
                -20 == etudiant.min(-5, -10, -15, -20)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "With -1, 0, 1 and -2, min should give -2",
                -2 == etudiant.min(-1, 0, 1, -2)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "With 3, 2, 1 and 0, min should give 0",
                0 == etudiant.min(3, 2, 1, 0)
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}