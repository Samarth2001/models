/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseOffer {

    Course course;
    ArrayList<Seat> seatlist;
    FacultyAssignment facultyassignment; //the professor teaching the class

    public CourseOffer(Course course) {
        this.course = course;
        seatlist = new ArrayList<Seat>();
    }

    public void AssignAsTeacher(FacultyProfile fp) {

        facultyassignment = fp.AssignAsTeacher(this); //assign the teacher for the course offer
    }

    public FacultyProfile getFacultyProfile() {
        return facultyassignment.getFacultyProfile();
    }

    public Course getCourse() {
        return course;
    }

    public String getCourseNumber() {
        return course.getCourseNumber();
    }

    public void generatSeats(int n) {

        for (int i = 0; i < n; i++) {
            Seat seat = new Seat(this, i);
            seatlist.add(seat);

        }

    }

    public Seat getEmptySeat() {

        for (Seat s : seatlist) {

            if (!s.isOccupied()) {
                return s;
            }
        }
        return null; // can't find an empty seat
    }

    public SeatAssignment assignEmptySeat(CourseLoad cl) {

        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(cl); //seat is already linked to course offer
        cl.registerStudent(sa); //coures offer seat is now linked to student
        return sa;
    }

    public int getTotalCourseRevenues() {

        int sum = 0;

        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }

        }
        return sum;
    }

    public Course getSubjectCourse() {
        return course;
    }

    public int getCreditHours() {
        return course.getCredits();
    }

}
