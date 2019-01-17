package com.cg.mini.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.mini.dao.UniversityDao;
import com.cg.mini.dao.UniversityDaoImpl;
import com.cg.mini.exception.MINIException;
import com.cg.mini.model.University;

public class UniversityServiceImpl implements UniversityService {
	UniversityDao universityDao = new UniversityDaoImpl();
	List<String> list = new ArrayList<String>();

	@Override
	public List<University> getAllPrograms() throws MINIException {
		// TODO Auto-generated method stub
		return universityDao.getAllPrograms();
	}

	
	

}
