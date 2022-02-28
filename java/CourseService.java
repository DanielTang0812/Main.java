package com.generation.java;

import com.generation.model.Student;

import java.util.Map;
import java.util.HashMap;

public class CourseService {

    private Map<String, Student> students;
    private Map<String, Course> courses;

    //Constructor
    public CourseService() {
        // Information should be retrieved from the database - cover in SpringBoot

        //Create 3 course instance object
        Course courseJava = new Course("Introduction to Java", "java1", 5);
        Course courseCSS = new Course("Introduction to CSS", "css1", 3);
        Course courseHTML = new Course("Introduction to HTML", "html1", 3);

        //Key=id Value=Course object
        this.courses = new HashMap<>();
        //getter method to retrieve the course id
        this.courses.put(courseJava.getId(), courseJava);
        this.courses.put(courseCSS.getId(), courseCSS);
        this.courses.put(courseHTML.getId(), courseHTML);

        Student student1 = new Student("111", "Jean Looi");
        Student student2 = new Student("222", "Bryan Chew");

        this.students = new HashMap<>();
        //getter and setter to retrieve the course id
        this.students.put(student1.getId(), student1);
        this.students.put(student2.getId(), student2);
    }

    public void addcourse(String name, String id, int credit) {
        //TODO - To add new courses to the courses HashMap
        //1)Create a new instance object of the Course
        //2)Add the new instance object to the course HashMap

        Course newCoures = new Course(name, id, credit);
        this.courses.put(newCoures.getId(),newCoures); //key, value
    }

    public Map<String, Course> getCourses() {return this.courses;}

    public Course findcourse(String id) {
        // TODO  - To be able to return a course  with the courseId passed in on the parameter
        // Parameter
        //id = "java1" search in course hashmap?? or search in students hashmap??
        //1) Access your courses HashMap, know how to check if the id passed in as the
        //parameter is of the key in your HashMap - HashMap Methodss

       // containsKey() - return boolean (true or false)

        if (this.courses.containsKey(id))
        {
            return this.courses.get(id);
        }

        return null;
    }



//Use case is I want to know how many courses and the details of the courses that
//this student is enrolled in
    public void enrollStudent(String studentId, String courseId) {
        // TODO - To enroll student to the course with the studentId and courseId passed
        //in as the parameters
        //Your student's  enrolledCourses list will have the course object

        //call a method in the Student Class to enroll the Course to the student
        //Add the course to the Arraylistin the Student Class


            //111, java1 passed in as paramenters
            //1) find and retrieve the student object from the HashMap with id 111
            Student student = this.students.get(studentId);

            //call a method in the Student Class to enroll the course to the student (add
            //the course to the Arraylist in the Student Class
            Course course = this.courses.get(courseid);
            student.enroll(course); //pass the whole course object to enroll method
    }

    public void unenrollStudent(String studentId, String courseId) {
        // TODO - To unenroll student to the course with the studentId and courseId passed
        //in as the parameters
        //Student HashMap
        Student student = this.students.get(studentId);
        Course course = this.courses.get(courseId);
        student.unEnroll(course);

    }


    public Student displayStudentInformation(String studentId) {
        //TODO - Return the student information (object) with the studentID passed
        //in as the paramenters
        //students HashMap
        return this.students.get(studentId);
    }

    public int totalenrolledCourses(String studentId) {
        //TODO - return the number of enrolled Courses of the student from the studentId
        Student student = this.students.get(studentId);
        return student.totalEnrollmentCourses();
    }

    public int totalCredit(String studentId) {
        //TODO - return the total number of credit(s) of the student from the studentId
        // If student enrolled in java1 and css1 --- 5 + 3 = return 8
        int totalCredit = 0;
        Student student = this.students.get(studentId);
        for (int i =0; i < student.totalEnrollmentCourses(); i++)  {
            totalCredit += student.getEnrolledCourses().get(i).getCredits();
        }

        return totalCredit;
    }
        @Override
        public String tostring() {

        String courseTitle = "Courses off from Jean's learning center: \n";
        String studentTitle = "Students registered to Jean's learning center: \n";

        String printCourses = "";
        String printStudents = "";

        for (Course c: this.courses.values())
        {
            printCourses *= c + "\n";
        }
        for (Student s: this.students.values())
        {
            printStudents += s + "\n";
        }
        return courseTitle + printCourses + studentTitle + printStudents;

    }
}//End of CourseService Class



