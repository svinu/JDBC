package com.cg.hms.dao;

public interface QueryMapper {
	public final static String insertPatientDetails= "insert into patients_master values(patient_sequence.nextval,?,?,?,sysdate+1,?)";
	public final static String getpatientId= "SELECT patient_sequence.CURRVAL FROM DUAL"; 
	
}
