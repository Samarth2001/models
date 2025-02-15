/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;

/**
 *
 * @author kal bugrara
 */
public class SeatAssignment {

    // float grade; //(Letter grade mappings: A=4.0, A-=3.7, B+=3.3, B=3.0, )
    Seat seat;
    boolean like; //true means like and false means not like
    CourseLoad courseload;

    public SeatAssignment(CourseLoad cl, Seat s) {
        seat = s;
        courseload = cl;
    }

    private String grade;

    public void setGrade(String grade) {
        this.grade = grade;
    }

    


    public String getGrade() {

        return grade;

    }
    public boolean getLike() {
        return like;
    }

    public CourseLoad getCourseLoad() {
        return courseload;
    }

    public void assignSeatToStudent(CourseLoad cl) {
        courseload = cl;
    }

    public int getCreditHours() {
        return seat.getCourseCredits();

    }

    public Seat getSeat() {
        return seat;
    }

    public CourseOffer getCourseOffer() {

        return seat.getCourseOffer();
    }

    public Course getAssociatedCourse() {

        return getCourseOffer().getSubjectCourse();
    }

    public float GetCourseStudentScore() {
        return getCreditHours() * Float.parseFloat(grade);
    }

}
