package com.pbs.service;

import com.pbs.model.Account;

public interface ITransactionService {

	public Account addAccount(Account account);

	public Account debitUsingSlip(long id, double amount, String slipno);

	public Account creditUsingCheque(long id, double amount, String chequeno);

	public Account creditUsingSlip(long id, double amount, String slipno);

	public Account debitUsingCheque(long id, double amount, String chequeno);

}