package com.pbs.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author Akshat Bharara
 * Description: It is a bean class for Transactions.
 * version: 1.0
 * Last Modified Date: 07-May-2020
 *
 */
@Entity
@Table(name = "Transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int trans_id;

	private String operation;
	
	private long acc_id;

	private double amount;
	LocalDate transaction_date;

	@Column(nullable = true)
	private String chequeNo;

	@Column(nullable = true)
	private String slipNo;

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getSlipNo() {
		return slipNo;
	}

	public void setSlipNo(String slipNo) {
		this.slipNo = slipNo;
	}

	public LocalDate getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(LocalDate transaction_date) {
		this.transaction_date = transaction_date;
	}

	public int getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public long getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(long acc_id) {
		this.acc_id = acc_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Transaction(String operation, long acc_id, double amount, LocalDate transaction_date) {
		super();

		this.operation = operation;
		this.acc_id = acc_id;
		this.amount = amount;
		this.transaction_date = transaction_date;
	}

	public Transaction() {
		super();
	}

	public Transaction(String operation, long acc_id, double amount, LocalDate transaction_date, String slipno,
			String chequeno) {
		super();

		this.operation = operation;
		this.acc_id = acc_id;
		this.amount = amount;
		this.transaction_date = transaction_date;
		this.slipNo = slipno;
		this.chequeNo = chequeno;
	}

	@Override
	public String toString() {
		return "Transaction [trans_id=" + trans_id + ", operation=" + operation + ", acc_id=" + acc_id + ", amount="
				+ amount + ", transaction_date=" + transaction_date + "]";
	}

}