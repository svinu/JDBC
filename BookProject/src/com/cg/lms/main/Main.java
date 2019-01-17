package com.cg.lms.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.cg.lms.dao.QueryTagger;
import com.cg.lms.exceptions.LMSException;
import com.cg.lms.model.BookDetails;
import com.cg.lms.service.BookService;
import com.cg.lms.service.BookServiceImpl;

public class Main {
	public static void main(String[] args) throws LMSException {
		System.out.println("=====book======");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Your Choice");
		System.out.println("1. Create Table");
		System.out.println("2. Insert");
		System.out.println("3. Update Cost by ID ");
		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1:
			break;
		case 2:
			System.out.println("Enter Book Name:");
			String bookName = scanner.nextLine();
			System.out.println("Enter Author Name:");
			String authorName = scanner.nextLine();
			System.out.println("Enter Book Price:");
			Double price = scanner.nextDouble();

			BookDetails bookObject = new BookDetails();
			bookObject.setBookName(bookName);
			bookObject.setAuthorName(authorName);
			bookObject.setPrice(price);

			BookService service = new BookServiceImpl();

			try {
				int result = service.insertBooks(bookObject);
				System.out.println(result + "Book Details Inserted");
			} catch (LMSException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}

			break;
		case 3:
			System.out.println("Enter Book id:");
			Integer bookId = scanner.nextInt();
			System.out.println("Enter Price");
			Double price2 = scanner.nextDouble();

			BookDetails bookObject2 = new BookDetails();
			bookObject2.setBookId(bookId);
			bookObject2.setPrice(price2);
			BookService service2 = new BookServiceImpl();
			try {
				int result = service2.updateBooks(bookObject2);

			} catch (LMSException e) {
				System.err.println(e.getMessage());
			}

			System.out.println("Book updated");
			break;
		case 4:
			BookDetails bookObject3 = new BookDetails();
			
			
			
			break;

		default:
			break;
		}

	}

}
