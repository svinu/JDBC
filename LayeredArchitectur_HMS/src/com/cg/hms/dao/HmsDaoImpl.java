package com.cg.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cg.hms.exceptions.HMSException;
import com.cg.hms.model.Patient;
import com.cg.hms.utility.Jdbcutility;

public class HmsDaoImpl implements HmsDao {

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	static Logger logger = Logger.getLogger(HmsDaoImpl.class);

	/**
	 * method : addPatientDetails; argument : it's taking model object as a
	 * argument patient return type : generated Id is returned to the user
	 * Author : Capgemini Date : 14-Jan-2019
	 * 
	 * */
	@Override
	public int addPatientDetails(Patient patient) throws HMSException {
		logger.info("in add patients method");
		connection = Jdbcutility.getConnection();
		int generatedId = 0;
		try {
			statement = connection
					.prepareStatement(QueryMapper.insertPatientDetails);
			logger.info("statement object created");
			statement.setString(1, patient.getName());
			statement.setString(2, patient.getGender());
			statement.setLong(3, patient.getPhoneNumber());
			statement.setString(4, patient.getProblems());
			statement.executeUpdate();
			logger.info("execute update called");

			statement = connection.prepareStatement(QueryMapper.getpatientId);
			logger.info("statement created to get id");
			resultSet = statement.executeQuery();
			logger.info("resultset object created");
			resultSet.next();
			generatedId = resultSet.getInt(1);
			logger.info("generated id" + generatedId);
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new HMSException(
					"Problem occured while creating statement object");
		} finally {
			logger.info("IN Finally BLOCK");
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new HMSException("Problem in closing statement");
			}
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new HMSException("Problem in closing statement");
			}
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new HMSException("Connection is not closed");
			}
		}

		return generatedId;
	}

}
