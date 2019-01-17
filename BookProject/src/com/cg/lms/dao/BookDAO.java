package com.cg.lms.dao;

import java.util.List;

import com.cg.lms.exceptions.LMSException;
import com.cg.lms.model.BookDetails;

public interface BookDAO {
	int updateBooks(BookDetails bookObject2) throws LMSException;
	int insertBooks(BookDetails bookObject) throws LMSException;
	List<BookDetails> getAllBooks() throws LMSException;
	
	

}
