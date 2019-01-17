package com.cg.hms.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.cg.hms.model.Patient;
import com.cg.hms.service.HmsService;
import com.cg.hms.service.HmsServiceImpl;

public class UIClass {
	

	public static void main(String[] args) {
		PropertyConfigurator.configure("resources/log4j.properties");
		Scanner scanner = null;
		boolean choiceFlag = false;
		int choice = 0;
		HmsService service = null;
		
		do {
			System.out
					.println("=======================HMS======================");
			scanner = new Scanner(System.in);
			System.out.println("1. Book Appointment");
			System.out.println("2. Get Appointment Details");
			System.out.println("3. View All booked Appointments");
			System.out.println("4. Exit");
			System.out.println("Enter Your Choice");
			try {
				choice = scanner.nextInt();
				choiceFlag = true;
				switch (choice) {
				case 1:
					scanner.nextLine();
					System.out.println("Enter Patient Name");
					String name = scanner.nextLine();
					System.out.println("Enter Gender");
					String gender = scanner.nextLine();
					System.out.println("Enter Phone Number");
					long phoneNo = scanner.nextLong();
					/*System.out.println("Enter Appointment Date");*/
					scanner.nextLine();
					System.out.println("Enter Your Problems");
					String problem = scanner.nextLine();

					Patient patient = new Patient();
					patient.setName(name);
					patient.setGender(gender);
					patient.setPhoneNumber(phoneNo);
					patient.setProblems(problem);
					service= new HmsServiceImpl();
					
					try {
						boolean validateFlag = service.validateFields(patient);
						if (validateFlag) {
							int id = service.addPatientDetails(patient);
							System.out.println("Your Appointment is fixed");
							
						}
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					

					break;

				case 2:

					break;
				case 3:

					break;
				case 4:

					break;

				default:
					choiceFlag = false;
					System.out
							.println("Kindly Select Mentioned Options From 1 to 4");
					System.out.println("Enter Again");
					break;
				}

			} catch (InputMismatchException e) {
				System.err.println("Enter Only Digits from 1 to 4");
				System.out.println("Enter ur input again");
			}

		} while (!choiceFlag);
		scanner.close();

	}

}
