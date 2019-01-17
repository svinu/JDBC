package com.cg.mob.dao;

public interface QueryMapper {

	public final static String insertPurchaseDetails = "insert into purchasedetails values(purchaseid_sequence.nextval,?,?,?,sysdate,?)";
	public static final String getPurchaseId = "SELECT purchaseid_sequence.CURRVAL FROM DUAL";
	public static final String insertMobile = "insert into mobile values(mobileid_sequence.nextval,?,?,?)";
	public static final String selectAllMobiles = "Select * from mobile ";
	public static final String selectOnPrice = "Select * from mobile where price between ? and ?";
	public static final String update="update mobile set quantity=quantity-1 where mobileId=?";

	
}
