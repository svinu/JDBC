package com.cg.hms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.hms.dao.HmsDao;
import com.cg.hms.dao.HmsDaoImpl;
import com.cg.hms.exceptions.HMSException;
import com.cg.hms.model.Patient;

public class HmsServiceImpl implements HmsService {

	List<String> list = new ArrayList<String>();
	HmsDao hmsDao = new HmsDaoImpl();
	
	/**
	 * method      : addPatientDetails
	 * argument    : it's taking model object as a argument patient
	 * return type : generated Id is returned to the user
	 * Author      : Capgemini
	 * Date  	   : 14-Jan-2019
	 * 
	 * */

	@Override
	public boolean validateFields(Patient patient) {
		boolean validateFlag= false;
		
		if (!checkName(patient.getName())) {
			list.add("Name must start with Capital Letter and Max Length should be 20");
		}
		if (!checkGender(patient.getGender())) {
			list.add("Gender must either male or female");
		}
		if (!checkPhoneNumber(patient.getPhoneNumber())) {
			list.add("Phone Number must be 10 digits and it should start with either 6 or 7 or 8 or 9");
		}
		if(!list.isEmpty()){
			try {
				throw new HMSException(list + " ");
			} catch (HMSException e) {
					System.out.println("nothing");
			}
		}
		else
		{
			validateFlag= true;
		}

		return validateFlag;
	}

	public boolean checkName(String name) {
		String nameRegEx = "[A-Z]{1}[A-Za-z\\s]{4,19}$";

		return Pattern.matches(nameRegEx, name);

	}

	public boolean checkGender(String gender) {
		/* String genderRegEx = "[A-Za-z]{4,6}$"; */
		String genderRegEx = "male|MALE|female|FEMALE";
		return Pattern.matches(genderRegEx, gender);

	}

	public boolean checkPhoneNumber(Long phoneNo) {
		String phoneRegEx = "[6|7|8|9]{1}[0-9]{9}";
		return Pattern.matches(phoneRegEx, String.valueOf(phoneNo));

	}

	@Override
	public int addPatientDetails(Patient patient) throws HMSException {
		
		// TODO Auto-generated method stub
		return hmsDao.addPatientDetails(patient);
	}

}
