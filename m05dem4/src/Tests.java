/**
 *  Copyright (c)  2017 Olivier Martin
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

import java.util.Arrays;


public class Tests {

    @Test
    public void tests(){
        
        Etudiant etudiant = new Etudiant();
        

        try{
		    assertTrue(
                "[[1, 2, 3]], [[3, 2, 1]] should give [[4,4,4]]" + " | Your code returned : "  + Arrays.deepToString(etudiant.add(new int[][]{{1, 2, 3}}, new int[][]{{3, 2, 1}})),
                Arrays.deepEquals(new int[][]{{4, 4, 4}}, etudiant.add(new int[][]{{1, 2, 3}}, new int[][]{{3, 2, 1}}))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}