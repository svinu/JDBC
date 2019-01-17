package com.cg.mini.main;

import java.util.List;
import java.util.Scanner;

import com.cg.mini.exception.MINIException;
import com.cg.mini.model.University;
import com.cg.mini.service.UniversityService;
import com.cg.mini.service.UniversityServiceImpl;

public class UIClass {

	public static void main(String[] args) {
		Scanner scanner = null;
		int choice = 0;
		boolean choiceFlag = false;
		UniversityService service = null;
		University university = new University();
		do {
			System.out.println("UNIVERSITY ADMISSION ");
			System.out.println("1. VIEW");
			System.out.println("2. APPLY");
			System.out.println("3. APPLICATION STATUS");
			choice = scanner.nextInt();
			choiceFlag = true;
			switch (choice) {
			case 1:
				scanner.nextLine();
				
				service = new UniversityServiceImpl();
				university = new University();
				
				try {
					List<University> list = service.getAllPrograms();
				} catch (MINIException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				break;
			case 2:

				break;

			case 3:

				break;

			default:
				choiceFlag = false;
				System.out.println("Select Mentioned Options From 1 to 3");
				System.out.println("Enter Again");
				
				break;
			}
		} while (!choiceFlag);
		scanner.close();

	}

}
