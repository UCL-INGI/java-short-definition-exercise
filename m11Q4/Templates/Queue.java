/**
 *  Copyright (c)  2016 O. Bonaventure, 2017 Olivier Martin
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
package StudentCode;

import java.util.ArrayList;
import java.text.MessageFormat;
import student.Translations.Translator;

public class Queue{
    
    //  ATTENTION Ici, certains modifiers sont public afin de pouvoir y accéder facilement dans le tests.
    //  Pour les étudiants, l'énoncé indiquera qu'ils sont private !
    
    public class Noeud {
        public int element;
        public Noeud suivant;
        public Noeud precedent;
        
        public Noeud(int o, Noeud n, Noeud p) {
            element = o;
            suivant = n;
            precedent = p;
        }
    }
    
    public Noeud entree; // correspond à tout moment à l'entrée de la queue
    public Noeud sortie; // correspond à tout moment à la sortie de la queue

    /*
     * @pre -
     * @post initialise une queue vide
     */
    public Queue() {
        entree = null;
        sortie = null;
    }
    
    
    /**
     * @pre o!= null
     * @post ajoute l'objet à la queue
     */
    public void ajouteCorrect(int o) {
        Noeud ajout;
        ajout = new Noeud(o, entree, null);
        if(entree!=null) {
            entree.precedent=ajout;
        }
        entree = ajout;
        if(sortie == null) {
            sortie = ajout;
        }
    }
    
    /**
     * @pre -
     * @post retourne le plus ancien objet de la queue et null si la queue est vide
     */
    public Object retireCorrect () {
        if ( sortie == null ) {
            return null;
        }
        int o=sortie.element;
        sortie=sortie.precedent;
        if(sortie!=null) {
            sortie.suivant=null;
        } else {
            entree=null;
        }
        return o;
    }
    
    /**
     * @pre o != null
     * @post ajoute l'objet à la queue
     */
    public void ajoute(int o) {
        @@q1@@
    }
    
    /**
     * @pre -
     * @post retourne le plus ancien objet de la queue via le noeud sortie et
     *       le retire de la queue
     *       null si la queue est vide
     */
    public int retire() {
        @@q2@@
    }
    
    /*
     * @pre -
     * @post utilisé par les tests, présente la pile sous la forme d'un String
     */
    public String toString(){
        String msg = "";
        Noeud n = entree;
        while(n != null) {
            msg += n.element + " | ";
            n = n.suivant;
        }
        System.err.println(msg);
        return msg;
    }
}
