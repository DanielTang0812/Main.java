package com.generation.java;

import com.generation.model.Course;
import com.generation.service.CourseService;

import java.util.ArrayList;
import java.util.List;


public class Student {

    private String name;
    private String id;

    private List<CourseService> enrolledCourese;

    //Student sign up for a learning academy - Codeacademy, Udemy
    // There is a record of the student in the system　- id, name, email etc.
    // First thing is to show a list of courses available, or searh for course(s)
    // Initially student enrolled course(s) list will be empty

    public Student(String name, String id)
    {
        this.name = name;
        this.id = id;

        //create an empty enrolledCourses List
        this.enrolledCourese = new ArrayList<>();
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public void enroll(Course course) {
        //TODO - Be able to enroll the student to the course - Add to the course to the
        // enrolledCourses List
        //Have received to Course object with ID java1, I need to add the Course to
        // the enrolledCourse arraylist
       // Student student = this.students.get(studentId);
        //call a method t the Student Class to enroll the course to the student
        //add the course to the ArrayList of the student class

        //Course course = this.courses.get(courseId);
       // student.enroll(course); //pass the whole course object to enroll method
        this.enrolledCourese.add(course);
    }
    public void unEnrollStudent(String studentId, String courseId) {
        //TODO - Be able to perform unenrollment of the course. - Remove the course
        //from the enrolledCourses List
        /*
        Student student = this.students.get(studentId);
        Course course = this.courses.get(courseId);
        student.unEnroll(course);
         */
        this.enrolledCourese.remove(course);
    }
    public int totalEnrolledCourses()  {
        //TODO - To return the total number of enrolledCourses of the student
        //Student student = this.students.get( studentId );
        //return student.totalEnrollmentCourses();
        return this.enrolledCourese.size();
    }

    public List<CourseService> getEnrolledCourese()
    {
        //TODO - To return the list of enrolledCourses of the student
        return this.enrolledCourese;
    }
    public int totalCredit(String studentId)
    {
        //TODO - return the total number of credit(s) of the student from the studentId
        int totalCredit = 0;
        Student student = this.students.get(studentId);

        for (int i = 0; i < student.totalEnrollmentCourses(); i++) {
            totalCredit += student.getEnrolledCourses().get(i).getCredit();
        }
        return totalCredit;
    }
    @Override
    public String toString() {
        return String.format("Student Id: %s, Name: %s, Enrolled Courses: ",
                this.id, this.name) + this.enrolledCourese;
    }
}
