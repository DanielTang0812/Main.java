package com.generation.java;

import com.generation.model.Course;
import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import com.generation.utils.PrinterHelper;

import java.text.ParseException;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
            throws ParseException
    {
        //Create an instance objet of CourseService
        CourseService courseService = new CourseService();

        System.out.println(courseService);   //Overriding toString() method
        /*
        System.out.println("Courses offered from Jean's Learning center:");
        courseService.getCourse() - return HashMap of the courses
        for (Course c: courseService.getCourse().values())
        {
            System.out.println(c);
            //what is c -refer to individual Course object from this.courses HashMap
            // System.out.println - print out whatever String that is return from the
            //toString() method from that Object Class (Course object class)
        }
        */


        //add 2 new course to my learning center
        /*
        new course : name=introduction to database, id=database1, credit=8
        new course : name=introduction to database,
         */
        courseService.addCourse("Introduction to database", "database1", 8);
        courseService.addCourse("Introduction to ReactJS", "react1", 5);

        System.out.println(courseService);
        /*
        System.out.println("Courses offered from Jean's Learning Center: ");

        for (Course c: courseService.getCourse().values())
        {
            System.out.println(c);
        }
        */

        //find a course
        //Main Class - entry point will only be from CourseService class
        //external Class/System cannot directly access the Course class or Student class
        Course findCourse = courseService.findCourse("css1");

        if (findCourse != null)
        {
            System.out.println("Course \n" + findCourse);
        }
        else
        {
            System.out.println("Course not found. Please try again");
        }
        //display a particuler student information with the studentId
        //return Student details with ID of 111
        Student getStudent = courseService.displayStudentInformation("111");

        if (getStudent != null) {
            System.out.println("Student Found: \n" + getStudent);
        }
        else
        {
            System.out.println("Student not found, please try again");
        }
        //enroll student to a course - student id=111, course = java1
        //Student student = new Student ( "aaa", "112");
        //student.enroll("java1");
        courseService.enrollStudent("111", "java1");
        courseService.enrollStudent("111", "css1");

        System.out.println(courseService);


        //Unenroll student from a course

        //display a particuler student with the studentId
        //return Student details with Id or 111
        Student getStudent = courseService.displayStudentInformation("112");
        if (getStudent != null) {
            System.out.println("Student found! \n" + getStudent);
        }
        else
        {
            System.out.println("Student not found, Please try again");
        }
        //display the total number of credits that the particuler student has
        int totalCredits = courseService.totalCredit("111");
        System.out.println(String.format("Total course credits: " + "course %d", totalCredits));

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        Scanner scanner = new Scanner( System.in );
        int option;
        do
        {
            PrinterHelper.showMainMenu();
            option = scanner.nextInt();
            switch ( option )
            {
                case 1:
                    registerStudent( studentService, scanner );
                    break;
                case 2:
                    findStudent( studentService, scanner );
                    break;
                case 3:
                    gradeStudent( studentService, scanner );
                    break;
                case 4:
                    enrollCourse( studentService, courseService, scanner );
                    break;
                case 5:
                    showStudentsSummary( studentService, scanner );
                    break;
                case 6:
                    showCoursesSummary( courseService, scanner );
                    break;
                case 7:
                    showPassedCourses( studentService, scanner );
                    break;
            }
        }
        while ( option != 8 );
    }

    private static void enrollCourse( StudentService studentService, CourseService courseService,
                                               Scanner scanner )
    {
        System.out.println( "Insert student ID" );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Invalid Student ID" );
            return;
        }
        System.out.println( student );
        System.out.println( "Insert course ID" );
        String courseId = scanner.next();
        Course course = courseService.getCourse( courseId );
        if ( course == null )
        {
            System.out.println( "Invalid Course ID" );
            return;
        }
        System.out.println( course );
        studentService.enrollToCourse( studentId, course );
        System.out.println( "Student with ID: " + studentId + " enrolled successfully to " + courseId );

    }

    private static void showCoursesSummary( CourseService courseService, Scanner scanner )
    {
        courseService.showSummary();
    }

    private static void showStudentsSummary( StudentService studentService, Scanner scanner )
    {
        if (!studentService.showSummary())
        {
            System.out.println("No Student Yet");
        }
    }

    private static void gradeStudent( StudentService studentService, Scanner scanner )
    {

        Student student = getStudentInformation( studentService, scanner );
        System.out.println( "Enrolled course:" );

        //TODO

    }

    private static Student getStudentInformation( StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Student not found" );
        }
        return student;
    }

    private static void findStudent( StudentService studentService, Scanner scanner )
    {
        Student student = getStudentInformation( studentService, scanner );
        if ( student != null )
        {
            System.out.println( "Student Found: " );
            System.out.println( student );
        }
    }

    private static void registerStudent( StudentService studentService, Scanner scanner ) throws ParseException {
       Student student = PrinterHelper.createStudentMenu( scanner );
       studentService.subscribeStudent( student );
    }

    private static void showPassedCourses(StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Student not found" );
        }
        else
        {
            if (student.findPassedCourses().size() == 0)
            {
                System.out.println( "No passed courses available" );
            }
           else
            {
                System.out.println(student.findPassedCourses());
            }
        }
    }
}
