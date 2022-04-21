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

import java.util.Arrays;


public class Tests {

    @Test
    public void tests(){
        
        Etudiant etudiant = new Etudiant();
        

        try{
		    assertTrue(
                "[0.1, 0.2] and [0.4, 0.5] are not equals" + " | Your code returned : "  + etudiant.egal(new double[]{0.1, 0.2}, new double[]{0.4, 0.5}),
                false == etudiant.egal(new double[]{0.1, 0.2}, new double[]{0.4, 0.5})
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "[0.1, 0.2] and [0.1, 0.2] are equals",
                true == etudiant.egal(new double[]{0.1, 0.2}, new double[]{0.1, 0.2})
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "[0.4, 0.2] and [0.4, 0.5] are equals",
                false == etudiant.egal(new double[]{0.4, 0.2}, new double[]{0.4, 0.5})
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "[0.2, 0.5] and [0.4, 0.5] are not equals",
                false == etudiant.egal(new double[]{0.2, 0.5}, new double[]{0.4, 0.5})
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}