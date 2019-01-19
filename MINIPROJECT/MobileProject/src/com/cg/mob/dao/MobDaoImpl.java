package com.cg.mob.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cg.mob.utility.Jdbcutility;
import com.cg.mob.exception.MOBException;
import com.cg.mob.model.Mobile;

public class MobDaoImpl implements MobDao {

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	static Logger logger = Logger.getLogger(MobDaoImpl.class);

	/**
	 * 
	 * method : addMobileDetails argument : it's taking model object as a
	 * argument mobile return type : result is returned to the user Author :
	 * Capgemini Date : 18-Jan-2019
	 *
	 */

	@Override
	public int addMobileDetails(Mobile mobile) throws MOBException {
		logger.info("in add Mobile Details method");
		connection = Jdbcutility.getConnection();
		int result = 0;
		int idMobile, quantityMobile;
		boolean idFlag = false;
		boolean quantityFlag = false;
		try {
			statement = connection
					.prepareStatement(QueryMapper.selectAllMobiles);
			logger.info("statement object created for select all details");
			resultSet = statement.executeQuery();
			logger.info("execute Query created");
			while (resultSet.next()) {
				idMobile = resultSet.getInt("mobileId");
				quantityMobile = resultSet.getInt("quantity");

				if (idMobile == mobile.getId()) {
					idFlag = true;
					if (quantityMobile > 0) {
						quantityFlag = true;
						statement = connection
								.prepareStatement(QueryMapper.insertPurchaseDetails);
						logger.info("statement object created for inserting ");

						statement.setString(1, mobile.getCustomerName());
						statement.setString(2, mobile.getCustomerName());
						statement.setLong(3, mobile.getCustomerPhoneNumber());
						statement.setInt(4, mobile.getId());

						result = statement.executeUpdate();
						logger.info("execute update called");

						statement = connection
								.prepareStatement(QueryMapper.update);
						logger.info("statement object created for updating quantity");
						statement.setInt(1, mobile.getId());
						statement.executeUpdate();
						logger.info("execute update called");

					}
				}
			}
			if (idFlag == false) {
				System.out.println("Id not present");
				quantityFlag = true;
				
			}
			if (quantityFlag == false) {
				System.out.println("Quantity not present");

			}



		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new MOBException("Statement not created");
		} finally {
			logger.info("IN Finally BLOCK");
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MOBException("Statement not closed");
			}
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MOBException("Connection not closed");
			}
		}
		return result;
	}

	/**
	 * 
	 * method : InsertMobile argument : it's taking model object as a argument
	 * mobile return type : result is returned to the user Author : Capgemini
	 * Date : 18-Jan-2019
	 *
	 */

	@Override
	public int insertMobile(Mobile mobile) throws MOBException {
		connection = Jdbcutility.getConnection();
		int result = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.insertMobile);
			logger.info("statement object created for inserting ");
			statement.setString(1, mobile.getMobileName());
			statement.setDouble(2, mobile.getMobilePrice());
			statement.setInt(3, mobile.getMobileQuantity());

			result = statement.executeUpdate();
			logger.info("execute update called");

		} catch (SQLException e) {
			logger.error(e.getMessage());
			System.out.println("Statement not created");

		} finally {
			logger.info("IN Finally BLOCK");
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MOBException("Problem in closing statement");
			}
			try {
				connection.close();
			} catch (Exception e) {
				logger.error(e.getMessage());
				throw new MOBException("Connection is not closed");
			}
		}
		return result;

	}

	/**
	 * 
	 * method : Get All Mobiles argument : it's taking model object as a
	 * argument mobile return type : list is returned to the user Author :
	 * Capgemini Date : 18-Jan-2019
	 *
	 */

	@Override
	public List<Mobile> getAllMobiles() throws MOBException {
		List<Mobile> list = new ArrayList<Mobile>();
		connection = Jdbcutility.getConnection();
		try {
			statement = connection
					.prepareStatement(QueryMapper.selectAllMobiles);
			logger.info("statement object created for selecting ");
			resultSet = statement.executeQuery();
			logger.info("execute query created");

			while (resultSet.next()) {
				int generatedMobileId = resultSet.getInt("mobileId");
				String name = resultSet.getString("name");
				double price = resultSet.getDouble("price");
				int quantity = resultSet.getInt("quantity");
				Mobile selectMobile = new Mobile();
				selectMobile.setMobileName(name);
				selectMobile.setMobilePrice(price);
				selectMobile.setMobileQuantity(quantity);
				selectMobile.setId(generatedMobileId);
				list.add(selectMobile);

			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			System.out.println("Statement not created");

		} finally {
			logger.info("IN Finally BLOCK");
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MOBException("Problem in closing statement");
			}
			try {
				connection.close();
			} catch (Exception e) {
				logger.error(e.getMessage());
				throw new MOBException("Connection is not closed");
			}
		}

		return list;
	}

	/**
	 * 
	 * method : Get All Mobiles On Price argument : it's taking model object as
	 * a argument mobile return type : list is returned to the user Author :
	 * Capgemini Date : 18-Jan-2019
	 *
	 */

	@Override
	public List<Mobile> getMobilesOnPrice(Mobile mobile) throws MOBException {
		List<Mobile> list = new ArrayList<Mobile>();
		connection = Jdbcutility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.selectOnPrice);
			logger.info("statement object created for selecting on price ");
			statement.setInt(1, mobile.getMinPrice());
			statement.setInt(2, mobile.getMaxPrice());
			resultSet = statement.executeQuery();
			logger.info("execute query created");
			while (resultSet.next()) {
				int generatedMobileId = resultSet.getInt("mobileId");
				String name = resultSet.getString("name");
				double price = resultSet.getDouble("price");
				int quantity = resultSet.getInt("quantity");
				Mobile priceMobile = new Mobile();
				priceMobile.setMobileName(name);
				priceMobile.setMobilePrice(price);
				priceMobile.setMobileQuantity(quantity);
				priceMobile.setId(generatedMobileId);
				list.add(priceMobile);

			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			System.out.println("Statement not created");

		} finally {
			logger.info("IN Finally BLOCK");
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MOBException("Problem in closing statement");
			}
			try {
				connection.close();
			} catch (Exception e) {
				logger.error(e.getMessage());
				throw new MOBException("Connection is not closed");
			}
		}

		return list;
	}

	/**
	 * 
	 * method : Delete Details argument : it's taking model object as a argument
	 * mobile return type : result is returned to the user Author : Capgemini
	 * Date : 18-Jan-2019
	 *
	 */

	@Override
	public int deleteDetails(int idForDelete) throws MOBException {
		connection = Jdbcutility.getConnection();
		int result = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.deleteQuery);
			logger.info("statement object created for deleting");
			statement.setInt(1, idForDelete);
			result = statement.executeUpdate();
			logger.info("execute Update created");
		} catch (SQLException e) {
			logger.error(e.getMessage());
			System.out.println("Statement not created");

		} finally {
			logger.info("IN Finally BLOCK");
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MOBException("Problem in closing statement");
			}
			try {
				connection.close();
			} catch (Exception e) {
				logger.error(e.getMessage());
				throw new MOBException("Connection is not closed");
			}
		}
		return result;
	}

}
