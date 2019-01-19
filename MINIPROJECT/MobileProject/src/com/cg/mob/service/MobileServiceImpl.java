package com.cg.mob.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.mob.dao.MobDao;
import com.cg.mob.dao.MobDaoImpl;
import com.cg.mob.exception.MOBException;
import com.cg.mob.model.Mobile;

public class MobileServiceImpl implements MobService {
	MobDao mobDao = new MobDaoImpl();
	List<String> list = new ArrayList<String>();
	/**
	 * 
	 * method      : addMobileDetails
	 * argument    : it's taking model object as a argument mobile
	 * return type : generated Id is returned to the user
	 * Author      : Capgemini
	 * Date  	   : 18-Jan-2019
	 *
	 */

	@Override
	public boolean validateFields(Mobile mobile)  {
		boolean validateFlag= false;
		if (!checkName(mobile.getCustomerName())){
			list.add("Name must start with Capital Letter and Max Length should be 20");
		}
		if (!checkMailId(mobile.getCustomerMailId())){
			list.add("Enter Valid Mail Id");
		}
		if (!checkPhoneNumber(mobile.getCustomerPhoneNumber())) {
			list.add("Enter Valid 10 Digit Phone Number");
		}
		if(!checkMobileId(mobile.getId())){
			list.add("Enter Valid Mobile Id");
		}
		if(!list.isEmpty()){
				System.out.println("In List " +list);
			
		}
		else
		{
			validateFlag= true;
		}
			

		return validateFlag;
	}
	
	public boolean checkName(String name){
		String nameRegEx = "[A-Z]{1}[A-Za-z\\s]{4,19}$";
		return Pattern.matches(nameRegEx, name);
	}

	public boolean checkMailId(String mailId){
		String nameRegEx = "[A-Za-z0-9_.-]*@[A-Za-z]*\\.[A-Za-z]*$";
		return Pattern.matches(nameRegEx, mailId);
	}
	public boolean checkPhoneNumber(Long phoneNumber){
		String nameRegEx = "[6|7|8|9]{1}[0-9]{9}";
		return Pattern.matches(nameRegEx, String.valueOf(phoneNumber));
	}
	public boolean checkMobileId(int id){
		String nameRegEx = "[0-9]{4}$";
		return Pattern.matches(nameRegEx, String.valueOf(id));
	}

	@Override
	public int addMobileDetails(Mobile mobile) throws MOBException {
		// TODO Auto-generated method stub
		return mobDao.addMobileDetails(mobile);
	}

	@Override
	public int insertMobile(Mobile mobile) throws MOBException {

		return mobDao.insertMobile(mobile);
	}

	@Override
	public List<Mobile> getAllMobiles() throws MOBException {
		// TODO Auto-generated method stub
		return mobDao.getAllMobiles();
	}

	@Override
	public List<Mobile> getMobilesOnPrice(Mobile mobile) throws MOBException {
		// TODO Auto-generated method stub
		return mobDao.getMobilesOnPrice(mobile);
	}

	@Override
	public int deleteDetails(int idForDelete) throws MOBException {
		// TODO Auto-generated method stub
		return mobDao.deleteDetails(idForDelete);
	}


	
}
