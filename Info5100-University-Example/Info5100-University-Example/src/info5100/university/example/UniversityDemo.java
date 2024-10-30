package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.Random;

public class UniversityDemo {

    public static void main(String[] args) {
        // 1. Create Department
        Department department = new Department("Computer Science");

        // 2. Create Course Catalog
        CourseCatalog courseCatalog = new CourseCatalog(department);

        // Add courses
        courseCatalog.newCourse("AED", "INFO5100", 4);
        courseCatalog.newCourse("WebD", "INFO6150", 4);
        courseCatalog.newCourse("Database Management", "DAMG5210", 4);
        courseCatalog.newCourse("Algorithms", "INFO7200", 4);
        courseCatalog.newCourse("Software Engineering", "INFO6879", 4);
        courseCatalog.newCourse("Machine Learning", "INFO7300", 4);

        // 3. Create Course Schedule
        CourseSchedule fall2024 = new CourseSchedule("Fall2024", courseCatalog);

        // Create course offerings
        ArrayList<CourseOffer> courseOffers = new ArrayList<>();
        courseOffers.add(fall2024.newCourseOffer("CS5001"));
        courseOffers.add(fall2024.newCourseOffer("CS5002"));
        courseOffers.add(fall2024.newCourseOffer("CS5003"));
        courseOffers.add(fall2024.newCourseOffer("CS5004"));
        courseOffers.add(fall2024.newCourseOffer("CS5005"));
        courseOffers.add(fall2024.newCourseOffer("CS5006"));

        // Generate seats for each course offer
        for (CourseOffer offer : courseOffers) {
            offer.generatSeats(10); // Generate 10 seats for each course
        }

        // 4. Create faculty
        ArrayList<FacultyProfile> faculty = new ArrayList<>();
        faculty.add(new FacultyProfile(new Person("F001", "John Smith")));
        faculty.add(new FacultyProfile(new Person("F002", "Mary Johnson")));
        faculty.add(new FacultyProfile(new Person("F003", "Bob Wilson")));

        // Assign faculty to courses
        for (int i = 0; i < courseOffers.size() && i < faculty.size(); i++) {
            CourseOffer offer = courseOffers.get(i);
            faculty.get(i).AssignAsTeacher(offer);
        }

        // 5. Create students and enroll them
        ArrayList<StudentProfile> students = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            Person person = new Person("S" + String.format("%03d", i), "Student " + i);
            StudentProfile student = new StudentProfile(person);
            students.add(student);

            // Create course load for each student
            CourseLoad courseLoad = student.newCourseLoad("Fall2024");

            // Register for core course (CS5001)
            SeatAssignment seat1 = courseLoad.registerStudentInClass(courseOffers.get(0));
            if (seat1 != null) {
                seat1.setGrade(generateGrade(random));
            }

            // Register for 2 electives (different for each student)
            int electiveIndex1 = (i % (courseOffers.size() - 1)) + 1;
            int electiveIndex2 = ((i + 1) % (courseOffers.size() - 1)) + 1;

            SeatAssignment seat2 = courseLoad.registerStudentInClass(courseOffers.get(electiveIndex1));
            if (seat2 != null) {
                seat2.setGrade(generateGrade(random));
            }

            SeatAssignment seat3 = courseLoad.registerStudentInClass(courseOffers.get(electiveIndex2));
            if (seat3 != null) {
                seat3.setGrade(generateGrade(random));
            }

            if (students.indexOf(student) % 2 == 0) { // half the students take an extra course
                SeatAssignment seat4 = courseLoad.registerStudentInClass(courseOffers.get(3));
                if (seat4 != null) {
                    seat4.setGrade(generateGrade(random));
                }
            }
        }

        // 6. Print Report
        System.out.println("\n=== Fall 2024 Semester Report ===\n");
        for (StudentProfile student : students) {
            printStudentSchedule(student, "Fall2024");
        }
    }

    private static void printStudentSchedule(StudentProfile student, String semester) {
        System.out.println("Student ID: " + student.getPerson().getPersonId());
        CourseLoad courseLoad = student.getCourseLoadBySemester(semester);

        if (courseLoad != null) {
            ArrayList<SeatAssignment> seats = courseLoad.getSeatAssignments();
            int totalCredits = 0;
            int totalCost = 0;

            System.out.println("Courses:");
            for (SeatAssignment seat : seats) {
                CourseOffer offer = seat.getCourseOffer();
                Course course = offer.getCourse();
                totalCredits += course.getCredits();
                totalCost += course.getCoursePrice();

                System.out.printf("  - %s (%s)\n",
                        course.getCourseNumber(),
                        course.getCredits() + " credits");
            }

            System.out.println("Total Credits: " + totalCredits);
            System.out.println("Total Tuition: $" + totalCost);
            System.out.println("--------------------\n");
        }
    }

    private static String generateGrade(Random random) {
        String[] grades = {"4.0", "3.7", "3.3", "3.0", "2.7", "2.3", "2.0", "1.7", "1.3", "1.0", "0.7", "0.0"};
        return grades[random.nextInt(grades.length)];
    }
}