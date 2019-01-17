package com.cg.lms.main;

import java.util.List;
import java.util.Scanner;

import com.cg.lms.model.BookDetails;
import com.cg.lms.service.BookService;
import com.cg.lms.service.BookServiceImpl;

public class SelectMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter ID");
		int id = scanner.nextInt();
		BookService service = new BookServiceImpl();
	
	}
	
}
