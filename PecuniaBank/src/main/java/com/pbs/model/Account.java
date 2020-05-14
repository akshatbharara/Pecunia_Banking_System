package com.pbs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author Akshat Bharara
 * Description: It is a bean class for Account.
 * version: 1.0
 * Last Modified Date: 07-May-2020
 *
 */
@Entity
@Table(name = "Account")
public class Account {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long account_id;

	private String customer_name;

	private double amount;

	private String contact_number;

	public long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", customer_name=" + customer_name + ", amount=" + amount
				+ ", contact_number=" + contact_number + "]";
	}

	

}