package com.cg.mob.dao;

public interface QueryMapper {

	public final static String insertPurchaseDetails = "insert into purchasedetails values(purchase_sequence.nextval,?,?,?,sysdate,?)";
	public static final String update = "update mobile set quantity=quantity-1 where mobileId=?";
	/*public static final String getPurchaseId = "SELECT purchase_sequence.CURRVAL FROM DUAL";*/
	public static final String selectAllMobiles = "Select * from mobile ";
	public static final String deleteQuery = "delete from mobile where mobileid=?";
	public static final String selectOnPrice = "Select * from mobile where price between ? and ?";
	/*public static final String getQuantity = "select quantity from mobile where mobileid = ?";*/
	public static final String insertMobile = "insert into mobile values(mobile_sequence.nextval,?,?,?)";

}
