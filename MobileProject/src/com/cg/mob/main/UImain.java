package com.cg.mob.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.cg.mob.exception.MOBException;
import com.cg.mob.model.Mobile;
import com.cg.mob.service.MobService;
import com.cg.mob.service.MobileServiceImpl;

public class UImain {

	public static void main(String[] args) {
		PropertyConfigurator.configure("resources/log4j.properties");
		Scanner scanner = null;
		boolean choiceFlag = false;
		int choice = 0;
		MobService service = null;
		Mobile mobile = new Mobile();
		do {
			System.out
					.println("====================Mobile Purchase System====================");
			scanner = new Scanner(System.in);
			System.out.println("1. Insert Mobile Details");
			System.out.println("2. View All Mobile Details");
			System.out.println("3. Delete");
			System.out.println("4. Search");
			System.out.println("5. Test Case");
			System.out.println("6. Exit");
			System.out.println("Enter Your Choice");

			try {
				choice = scanner.nextInt();
				choiceFlag = true;
				switch (choice) {
				case 1:
					scanner.nextLine();
					System.out.println("Enter Customer Name");
					String customerName = scanner.nextLine();
					System.out.println("Enter Customer MailId");
					String customerMailId = scanner.nextLine();
					System.out.println("Enter Phone Number");
					Long customerPhoneNumber = scanner.nextLong();
					System.out.println("Enter Mobile Id");
					int id = scanner.nextInt();

					mobile.setCustomerName(customerName);
					mobile.setCustomerMailId(customerMailId);
					mobile.setCustomerPhoneNumber(customerPhoneNumber);
					mobile.setId(id);
					service = new MobileServiceImpl();

					try {
						boolean validateFields = service.validateFields(mobile);
						System.out.println(validateFields);
						if (validateFields) {
							int rows = service.addMobileDetails(mobile);
							System.out.println("Done With Adding" + rows);
						}
					} catch (MOBException e) {
						/* System.out.println("Exception While Validating"); */
						e.printStackTrace();
					}

					break;
				case 2:
					service = new MobileServiceImpl();

					try {
						List<Mobile> list = service.getAllMobiles();
						if (!list.isEmpty()) {
							System.out.println("MOBILEID" + "-----"
									+ "MOBILENAME" + "-----" + "MOBILEPRICE"
									+ "-----" + "MOBILEQUANTITY");
							for (Mobile selectMobile : list) {
								System.out.println(selectMobile.getId()
										+ "    -----"
										+ selectMobile.getMobileName()
										+ "-----"
										+ selectMobile.getMobilePrice()
										+ "-----"
										+ selectMobile.getMobileQuantity());
							}

						}

					} catch (MOBException e) {
						// TODO Auto-generated catch blocks
						e.printStackTrace();
					}

					break;
				case 3:

					break;
				case 4:
					System.out.println("Enter Minimum Price");
					int minPrice = scanner.nextInt();
					System.out.println("Enter Maximum Price");
					int maxPrice = scanner.nextInt();
					
					mobile.setMinPrice(minPrice);
					mobile.setMaxPrice(maxPrice);
					
					service = new MobileServiceImpl();
					try {
						List<Mobile> list = service.getMobilesOnPrice(mobile);
						if (!list.isEmpty()) {
							System.out.println("MOBILEID" + "-----"
									+ "MOBILENAME" + "-----" + "MOBILEPRICE"
									+ "-----" + "MOBILEQUANTITY");
							for (Mobile priceMobile : list) {
								System.out.println(priceMobile.getId()
										+ "    -----"
										+ priceMobile.getMobileName()
										+ "-----"
										+ priceMobile.getMobilePrice()
										+ "-----"
										+ priceMobile.getMobileQuantity());
							}

						}

					} catch (MOBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					break;
				case 5:

					break;
				case 6:

					break;

				default:
					choiceFlag = false;
					System.out.println("Select Mentioned Options From 1 to 7");
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
