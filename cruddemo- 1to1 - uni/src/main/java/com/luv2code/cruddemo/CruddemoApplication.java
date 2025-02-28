package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO){
		int theId=1;
		System.out.println("Deleting instructor id: "+theId);
		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
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
