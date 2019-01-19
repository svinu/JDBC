package com.cg.mini.service;

import java.util.List;

import com.cg.mini.exception.MINIException;
import com.cg.mini.model.University;

public interface UniversityService {

	List<University> getAllPrograms() throws MINIException;

	int applyProgram(University university) throws MINIException;

	boolean validateFields(University university) throws MINIException;

	List<University> getEmployeesOnId(int applicationId) throws MINIException;;

}
