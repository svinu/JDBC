package com.cg.mini.dao;

import java.util.List;

import com.cg.mini.exception.MINIException;
import com.cg.mini.model.University;

public interface UniversityDao {

	List<University> getAllPrograms() throws MINIException;

}
