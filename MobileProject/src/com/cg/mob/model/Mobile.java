package com.cg.mob.model;

import java.util.Date;

public class Mobile {
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	private String mobileName;
	private Double mobilePrice;
	private Integer mobileQuantity;
	private String customerName;
	private String customerMailId;
	private Long customerPhoneNumber;
	private Integer mobileId;
	private Integer Id;
	private Date purchaseDate;
	private Integer maxPrice;
	private Integer minPrice;
	
	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	public Mobile(Integer maxPrice, Integer minPrice) {
		super();
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;
	}

	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Mobile(String mobileName, Double mobilePrice,
			Integer mobileQuantity, String customerName, String customerMailId,
			Long customerPhoneNumber, Integer mobileId, Integer id,
			Date purchaseDate) {
		super();
		this.mobileName = mobileName;
		this.mobilePrice = mobilePrice;
		this.mobileQuantity = mobileQuantity;
		this.customerName = customerName;
		this.customerMailId = customerMailId;
		this.customerPhoneNumber = customerPhoneNumber;
		this.mobileId = mobileId;
		Id = id;
		this.purchaseDate = purchaseDate;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public Double getMobilePrice() {
		return mobilePrice;
	}

	public void setMobilePrice(Double mobilePrice) {
		this.mobilePrice = mobilePrice;
	}

	public Integer getMobileQuantity() {
		return mobileQuantity;
	}

	public void setMobileQuantity(Integer mobileQuantity) {
		this.mobileQuantity = mobileQuantity;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMailId() {
		return customerMailId;
	}

	public void setCustomerMailId(String customerMailId) {
		this.customerMailId = customerMailId;
	}

	public Long getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(Long customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public Integer getMobileId() {
		return mobileId;
	}

	public void setMobileId(Integer mobileId) {
		this.mobileId = mobileId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	
		
}
