package com.inputoutput;

import java.io.Serializable;

public class AddressBookUC13 implements Serializable {

	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private String contactNum;

	public AddressBookUC13(String fname, String lname, String city,
			String state, String contactnum) {
		this.firstName = fname;
		this.lastName = lname;
		this.city = city;
		this.state = state;
		this.contactNum = contactnum;
	}

	@Override
	public String toString() {
		return "AddressBookUC13 [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", state="
				+ state + ", contactNum=" + contactNum + "]";
	}	
}


