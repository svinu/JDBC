package com.cg.mob.dao;

import java.util.List;

import com.cg.mob.exception.MOBException;
import com.cg.mob.model.Mobile;

public interface MobDao {

	int addMobileDetails(Mobile mobile) throws MOBException;

	int insertMobile(Mobile mobile) throws MOBException;

	List<Mobile> getAllMobiles() throws MOBException;

	List<Mobile> getMobilesOnPrice(Mobile mobile) throws MOBException	;

	int deleteDetails(int idForDelete)throws MOBException	;

	
	

}
