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
                "02/02/2016 should give hiver",
                "hiver".equals(etudiant.sais(2, 2))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "16/05/2016 should give printemps",
                "printemps".equals(etudiant.sais(16, 5))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "15/07/2016 should give été",
                "été".equals(etudiant.sais(15, 7))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "01/10/2016 should give automne",
                "automne".equals(etudiant.sais(1, 10))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "20/03/2016 should give printemps",
                "printemps".equals(etudiant.sais(20, 3))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "20/06/2016 should give été",
                "été".equals(etudiant.sais(20, 6))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "22/09/2016 should give automne",
                "automne".equals(etudiant.sais(22, 9))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "21/12/2016 should give hiver",
                "hiver".equals(etudiant.sais(21, 12))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "19/03/2016 should give hiver",
                "hiver".equals(etudiant.sais(19, 3))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "19/06/2016 should give printemps",
                "printemps".equals(etudiant.sais(19, 6))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "21/09/2016 should give été",
                "été".equals(etudiant.sais(21, 9))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        

        try{
		    assertTrue(
                "20/12/2016 should give automne",
                "automne".equals(etudiant.sais(20, 12))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
    }

}