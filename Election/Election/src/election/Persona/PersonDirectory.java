/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election.Persona;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {
    
      ArrayList<Person> personlist ;
    
      public PersonDirectory (){
          
       personlist = new ArrayList();

    }

    public Person newPerson(String name) {

        if(findPerson(name)!=null) return null;
        Person p = new Person(name);
        personlist.add(p);
        return p;
    }

    public Person findPerson(String name) {

        for (Person p : personlist) {

            if (p.isMatch(name)) {
                return p;
            }
        }
            return null; //not found after going through the whole list
         }
    
}
