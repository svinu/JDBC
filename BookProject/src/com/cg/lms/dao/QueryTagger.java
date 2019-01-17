package com.cg.lms.dao;

public interface QueryTagger {

	public static final String query = "CREATE TABLE book_details(id NUMBER PRIMARY KEY, bookName varchar2(30), authorName varchar2(30), price DECIMAL(8,3))";
	public static final String insertQuery="insert into book_details values(book_id_sequence.nextval,?,?,?)";
	public static final String updateQuery = "update book_details set price=? where id=?";
	public static final String selectAll = "select * from book_details ";
}
