package com.codemind.MappingsDemo;

import com.codemind.MappingsDemo.dao.AppDAO;
import com.codemind.MappingsDemo.entity.Instructor;
import com.codemind.MappingsDemo.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Scanner;

@SpringBootApplication
public class MappingsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingsDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{

//			createInstructor(appDAO);
//			findInstructorById(appDAO);
//			deleteInstructorById(appDAO);
			findInstructorDetaisById(appDAO);

		};
	}

	private void findInstructorDetaisById(AppDAO appDAO) {
		int id=1;
		System.out.println("InstructorDetails which is Id : "+id);

		InstructorDetails instructorDetails=appDAO.findInstructorDetailsById(id);
		System.out.println("InstructorDetails is : "+instructorDetails.getInstructor().getFirstName()+" "+instructorDetails.getInstructor().getLastName());
		System.out.println("InstructorDetails is : "+instructorDetails.getInstructor().getEmail()+" "+instructorDetails.getYoutubrChannel()+" "+instructorDetails.getHobby());

	}

	private void deleteInstructorById(AppDAO appDAO) {

		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Instructor Id to delete Details : ");
		int id=sc.nextInt();
		appDAO.deleteInstructorById(id);

	}

	private void findInstructorById(AppDAO appDAO) {

		int id=1;
		System.out.println("Instructor which is Id : "+id);

		Instructor instructor=appDAO.findInstructorById(id);

		System.out.println("Instructor Name is : "+instructor.getFirstName()+" "+instructor.getLastName());
		System.out.println("Instructor Email is : "+instructor.getEmail());
		System.out.println("Associated Instructor Details is : "+instructor.getInstructorDetails().getYoutubrChannel()+" "+instructor.getInstructorDetails().getHobby());

	}

	private void createInstructor(AppDAO appDAO) {

		System.out.println("Start Creating an Instructor : ");

		Instructor instructor=new Instructor("ABC","DEF","abc@codemind");
		InstructorDetails instructorDetails=new InstructorDetails("Faizan_Codemind","Falana-Conference");

		instructor.setInstructorDetails(instructorDetails);

		System.out.println("Instructor Details is : "+instructorDetails);

		appDAO.save(instructor);

		System.out.println("Id of Instructor : "+instructor.getId());

		System.out.println("Information of Instructor : "+appDAO.findInstructorById(instructor.getId()));

		System.out.println("Saved");

	}

}
