/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseLoad {

    private String semester;
    ArrayList<SeatAssignment> seatassignments; //each represent 1 course registration

    public CourseLoad(String s) {
        seatassignments = new ArrayList();
        semester = s;
    }

    public SeatAssignment registerStudentInClass(CourseOffer co) {
        Seat seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(this);
        seatassignments.add(sa);  // add to student's course load
        return sa;
    }

    public void registerStudent(SeatAssignment sa) {

        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }

    public float getSemesterScore() { //total score for a full semeter
        float sum = 0;
        for (SeatAssignment sa : seatassignments) {
            sum = sum + sa.GetCourseStudentScore();
        }
        return sum;
    }

    public String getSemester() {
        return semester;
    }

    public ArrayList<SeatAssignment> getSeatAssignments() {
        return seatassignments;
    }

}
