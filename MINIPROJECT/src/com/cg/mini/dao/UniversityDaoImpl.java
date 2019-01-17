package com.cg.mini.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.mini.exception.MINIException;
import com.cg.mini.model.University;
import com.cg.mini.utility.JdbcUtility;

public class UniversityDaoImpl implements UniversityDao {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;


	@Override
	public List<University> getAllPrograms() throws MINIException {
		List<University> list = new ArrayList<University>();
		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.selectAllMobiles);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int generatedId = resultSet.getInt("id");
				String name = resultSet.getString("program_name");
				String location = resultSet.getString("location");
				Date startDate = resultSet.getDate("start_date");
				Date endDate = resultSet.getDate("end_date");
				int sessions = resultSet.getInt("session_per_week");
				University allUniversity = new University();
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
