package com.cg.hms.model;

import java.util.Date;

public class Patient {

		private Integer id;
		private String name;
		private String gender;
		private Long phoneNumber;
		private Date appointmentDate;
		private String problems;
		public Patient(Integer id, String name, String gender,
				Long phoneNumber, Date appointmentDate, String problems) {
			super();
			this.id = id;
			this.name = name;
			this.gender = gender;
			this.phoneNumber = phoneNumber;
			this.appointmentDate = appointmentDate;
			this.problems = problems;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public Long getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(Long phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public Date getAppointmentDate() {
			return appointmentDate;
		}
		public void setAppointmentDate(Date appointmentDate) {
			this.appointmentDate = appointmentDate;
		}
		public String getProblems() {
			return problems;
		}
		public void setProblems(String problems) {
			this.problems = problems;
		}
		public Patient() {
			super();

		}
		
		

	

}
