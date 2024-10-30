/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

/**
 *
 * @author kal bugrara
 */
public class Person {

    String id;
    String name;

    public Person(String id) {

        this.id = id;
    }

    // Assuming there's a name field
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getPersonId() {
        return id;
    }

    public String getName() {
        return name; // or any other meaningful default value
    }

    public boolean isMatch(String id) {
        return getPersonId().equals(id);
    }

}
