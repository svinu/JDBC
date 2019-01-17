package com.cg.hms.dao;

import com.cg.hms.exceptions.HMSException;
import com.cg.hms.model.Patient;

public interface HmsDao {

	int addPatientDetails(Patient patient) throws HMSException;

}
