package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//createCourseAndStudents(appDAO);
			//findCourseAndStudents(appDAO);
			//findStudentAndCourses(appDAO);
			//addMoreCoursesForStudent(appDAO);
			//deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO){
		int theId=1;
		System.out.println("Deleting student id: "+theId);
		appDAO.deleteStudentById(theId);
		System.out.println("Done!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO){
		int theId=2;
		Student tempStudent=appDAO.findStudentAndCoursesByStudentId(theId);

		Course tempCourse1=new Course("Rubik Cube");
		Course tempCourse2=new Course("RGame Development");

		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Updating student: "+tempStudent);
		System.out.println("associated courses: "+tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Done!");
	}
	private void findStudentAndCourses(AppDAO appDAO){
		int theId=2;
		Student tempStudent= appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println("Loaded student: "+tempStudent);
		System.out.println("Courses: "+tempStudent.getCourses());
		System.out.println("Done!");
	}

	private void findCourseAndStudents(AppDAO appDAO){
		int theId=10;
		Course tempCourse=appDAO.findCourseAndStudentsBuCourseId(theId);

		System.out.println("Loaded courses: "+ tempCourse);
		System.out.println("Students: "+ tempCourse.getStudents());

		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO){

		Course tempCourse=new Course("Pacman - AI");
		Student tempStudent1=new Student("Andreea", "Maria", "andreea@gmail.com");
		Student tempStudent2=new Student("StudentNume", "StudentNume2", "student@gmail.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		System.out.println("Saving the course: "+tempCourse);
		System.out.println("asscociated students: "+tempCourse.getStudents());

		appDAO.save(tempCourse);
		System.out.println("Done!");

	}

	private void deleteCourseAndReviews(AppDAO appDAO){
		int theId=10;

		System.out.println("Deleting course id: "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO){
		int theId=10;
		Course tempCourse=appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO){
		Course tempCourse=new Course("Pacman - How to score one million points!");

		tempCourse.addReview(new Review("Great Course!"));
		tempCourse.addReview(new Review("Cool Course!"));
		tempCourse.addReview(new Review("What a dumb course!"));

		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO){
		int theId=10;
		System.out.println("Deleting course id: "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO){
		int theId=10;
		System.out.println("Finding course id: "+ theId);
		Course tempCourse=appDAO.findCourseById(theId);

		System.out.println("Updating course id: "+theId);
		tempCourse.setTitle("Enjoy the Simple Things!");

		appDAO.update(tempCourse);

		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO){
		int theId=1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("Updating instructor id: "+theId);

		tempInstructor.setLastName("TESTER");

		appDAO.update(tempInstructor);
		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO){
		int theId=1;

		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesByInstrucuctor(AppDAO appDAO){
		int theId=1;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("Finding courses for instructor id:  "+theId);
		List<Course> courses=appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO){
		int theId=1;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO){
		Instructor tempInstructor=new Instructor("Andreea","Petren","deea@gmail.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.youtube.com",
				"Piano");
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1=new Course("Guitar Course");
		Course tempCourse2=new Course("Tha Pianball Masterclass");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving instructor: "+tempInstructor);
		System.out.println("The courses: "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO){
		int theId=2;
		InstructorDetail tempInstructorDetail=appDAO.findInstructorDetailById(theId);
		System.out.println("tempInstructorDetail: "+tempInstructorDetail);
		System.out.println("the associated instructor: "+ tempInstructorDetail.getInstructor());
		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO){
		int theId=1;
		System.out.println("Deleting instructor id: "+theId);
		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO){
			int theId=2;
			System.out.println("Deleting instructor detail id: "+theId);
			appDAO.deleteInstructorDetailById(theId);
	}

	private void findInstructor(AppDAO appDAO){
		int theId=1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associate instructor only: "+ tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO){
//		Instructor tempInstructor=new Instructor("Chad","Darby","chad@gmail.com");
//		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.handball.com/youtube",
//				"Handball");
//		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Instructor tempInstructor=new Instructor("Amelia","Petre","amelia@gmail.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.happy.com/youtube",
				"To be happy");
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: "+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}
}
