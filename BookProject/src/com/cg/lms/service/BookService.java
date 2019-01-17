package com.cg.lms.service;

import java.util.List;

import com.cg.lms.exceptions.LMSException;

import com.cg.lms.model.BookDetails;

public interface BookService {

	int insertBooks(BookDetails bookObject) throws LMSException;

	int updateBooks(BookDetails bookObject2) throws LMSException;

	List<BookDetails> getAllbooks() throws LMSException;

	

}
