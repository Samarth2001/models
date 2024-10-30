/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseCatalog;

/**
 *
 * @author kal bugrara
 */
public class Course {

    private final String courseNumber;

    // String number;
    String name;
    int credits;
    int price = 1500; //per credit hour

    public Course(String n, String numb, int ch) {
        name = n;
        courseNumber = numb;
        credits = ch;

    }

    public String getName() {
        return name;
    }

    public String getCourseNumber() {

        return courseNumber;

    }

    public int getCoursePrice() {
        return price * credits;

    }

    public int getCredits() {
        return credits;

    }

}
