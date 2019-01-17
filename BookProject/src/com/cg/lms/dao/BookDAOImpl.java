package com.cg.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.lms.utility.JdbcUtility;
import com.cg.lms.exceptions.LMSException;
import com.cg.lms.model.BookDetails;

public class BookDAOImpl implements BookDAO {
	PreparedStatement statement = null;
	Connection connection = null;

	@Override
	public int insertBooks(BookDetails bookObject) throws LMSException {
		connection = JdbcUtility.getConnection();
		int result = 0;
		try {
			statement = connection.prepareStatement(QueryTagger.insertQuery);

			statement.setString(1, bookObject.getBookName());

			statement.setString(2, bookObject.getAuthorName());

			statement.setDouble(3, bookObject.getPrice());

			result = statement.executeUpdate();
		} catch (SQLException e) {
			throw new LMSException("Statement is not created");

		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new LMSException("Problem in closing statement");
			}
			try {
				connection.close();
			} catch (SQLException e) {
				throw new LMSException("Connection is not closed");
			}
		}
		return result;
	}

	@Override
	public int updateBooks(BookDetails bookObject2) throws LMSException {
		connection = JdbcUtility.getConnection();
		int result = 0;
		try {
			statement = connection.prepareStatement(QueryTagger.updateQuery);
			statement.setDouble(1, bookObject2.getPrice());
			statement.setInt(2, bookObject2.getBookId());
			result = statement.executeUpdate();
		} catch (SQLException e) {
			throw new LMSException("Statement is not created");

		} finally {
			try {

				statement.close();
			} catch (SQLException e) {
				throw new LMSException("Problem in closing statement");
			}
			try {
				connection.close();
			} catch (SQLException e) {
				throw new LMSException("Connection is not closed");
			}
		}

		return result;
	}

	@Override
	public List<BookDetails> getAllBooks() throws LMSException {
		List< BookDetails> list = new ArrayList<>();
		ResultSet resultSet=null;
		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryTagger.selectAll);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("bookName");
				String author = resultSet.getString("auhtorName");
				double cost = resultSet.getDouble("cost");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
			
	}
	



