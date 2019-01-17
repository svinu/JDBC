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

	@Override
	public int addMobileDetails(Mobile mobile) throws MOBException {
		logger.info("in add mobiles method");
		connection = Jdbcutility.getConnection();
		boolean flagMobile = false;
		boolean flagQuantity = false;
		int generatedId = 0;
		Integer idMobile, quantityMobile;
		try {
			statement = connection
					.prepareStatement(QueryMapper.selectAllMobiles);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				idMobile = resultSet.getInt("mobileid");
				quantityMobile = resultSet.getInt("quantity");
								

				if (idMobile.equals(mobile.getId())) {
					flagMobile = true;
					if (quantityMobile > 0) {
						flagQuantity = true;
						System.out.println(idMobile);

						statement = connection
								.prepareStatement(QueryMapper.update);
						statement.setInt(1, idMobile);
						statement.executeQuery();

						statement = connection
								.prepareStatement(QueryMapper.insertPurchaseDetails);
			
						logger.info("statement object created");
						statement.setString(1, mobile.getCustomerName());
						statement.setString(2, mobile.getCustomerMailId());
						statement.setLong(3, mobile.getCustomerPhoneNumber());
						statement.setInt(4, mobile.getId());
			

						generatedId = statement.executeUpdate();
									logger.info("execute update called");

						/*
						 * statement =
						 * connection.prepareStatement(QueryMapper.getPurchaseId
						 * ); logger.info("statement created to get id");
						 * resultSet = statement.executeQuery();
						 * logger.info("result set object created");
						 * resultSet.next(); generatedId = resultSet.getInt(1);
						 * logger.info("generated id" + generatedId);
						 */

					}
				}

			}
			if (!flagMobile) {
				System.out.println("Id not present");
			}
			if (!flagQuantity) {
				System.out.println("No Mobile Left");
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			/*
			 * throw new MOBException(
			 * "Problem occurred while creating statement object");
			 */
		} finally {
			logger.info("IN Finally BLOCK");
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MOBException("Problem in closing statement");
			}
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MOBException("Problem in closing statement");
			}
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MOBException("Connection is not closed");
			}
		}

		return generatedId;
	}

	@Override
	public int insertMobile(Mobile mobile) throws MOBException {
		connection = Jdbcutility.getConnection();
		int result = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.insertMobile);
			statement.setString(1, mobile.getMobileName());
			statement.setDouble(2, mobile.getMobilePrice());
			statement.setInt(3, mobile.getMobileQuantity());

			result = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Statement not created");

		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new MOBException("Problem in closing statement");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new MOBException("Connection is not closed");
			}
		}
		return result;

	}

	@Override
	public List<Mobile> getAllMobiles() throws MOBException {
		List<Mobile> list = new ArrayList<Mobile>();
		connection = Jdbcutility.getConnection();
		try {
			statement = connection
					.prepareStatement(QueryMapper.selectAllMobiles);
			resultSet = statement.executeQuery();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Mobile> getMobilesOnPrice(Mobile mobile) throws MOBException {
		List<Mobile> list = new ArrayList<Mobile>();
		connection = Jdbcutility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.selectOnPrice);
			statement.setInt(1, mobile.getMinPrice());
			statement.setInt(2, mobile.getMaxPrice());
			resultSet = statement.executeQuery();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
