package com.cg.mini.model;

import java.util.Date;

public class University {
	private static Integer id;
	private static String programName;
	private static String location;
	private static Date startDate;
	private static Date endDate;
	private static Integer sessionsPerWeek;
	
	
	public University() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Integer getId() {
		return id;
	}

	public static void setId(Integer id) {
		University.id = id;
	}

	public static String getProgramName() {
		return programName;
	}

	public static void setProgramName(String programName) {
		University.programName = programName;
	}

	public static String getLocation() {
		return location;
	}

	public static void setLocation(String location) {
		University.location = location;
	}

	public static Date getStartDate() {
		return startDate;
	}

	public static void setStartDate(Date startDate) {
		University.startDate = startDate;
	}

	public static Date getEndDate() {
		return endDate;
	}

	public static void setEndDate(Date endDate) {
		University.endDate = endDate;
	}

	public static Integer getSessionsPerWeek() {
		return sessionsPerWeek;
	}

	public static void setSessionsPerWeek(Integer sessionsPerWeek) {
		University.sessionsPerWeek = sessionsPerWeek;
	}
	
	

}
