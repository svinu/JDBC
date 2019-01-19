package com.cg.mob.main;

import java.util.Scanner;

import com.cg.mob.exception.MOBException;
import com.cg.mob.model.Mobile;
import com.cg.mob.service.MobService;
import com.cg.mob.service.MobileServiceImpl;

public class MobileTableUI {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Mobile Name:");
		String mobileName = scanner.nextLine();
		
		System.out.println("Enter Price:");
		double mobilePrice = scanner.nextDouble();
		
		System.out.println("Enter Quantity:");
		int mobileQuantity = scanner.nextInt();
		
		Mobile mobile = new Mobile();
		mobile.setMobileName(mobileName);
		mobile.setMobilePrice(mobilePrice);
		mobile.setMobileQuantity(mobileQuantity);
		
		MobService service = new MobileServiceImpl();
		try {
			int result = service.insertMobile(mobile);
			System.out.println(result + " row inserted");
		} catch (MOBException e) {
			e.printStackTrace();
		}
		scanner.close();
		
		

	}

}
