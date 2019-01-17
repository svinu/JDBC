package com.cg.mob.dao;

import java.util.regex.Pattern;

public class query {
	public static void main(String[] args) {
		String name = "vinu.igs@gmail.com";
		String nameRegEx = "[A-Za-z0-9_.-]*@[A-Za-z]*\\.[A-Za-z]*$";
		boolean result = Pattern.matches(nameRegEx, name);
		System.out.println(result);
	}

}
