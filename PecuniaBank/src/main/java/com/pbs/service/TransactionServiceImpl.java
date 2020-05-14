package com.pbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbs.dao.ITransactionDao;
import com.pbs.model.Account;
/**
 * @author Akshat Bharara
 * Description: It is a Rest full service class that provides the services for Transaction.
 * version: 1.0
 * Last Modified Date: 07-May-2020
 *
 */
@Service
public class TransactionServiceImpl implements ITransactionService {

	
	/**
	 * @author : Akshat Bharara
	 * Method Name: addAccount
	 * Method Description: Add Account in bank database in order to show transaction details.
	 * Method Last Modified: 07-May-2020
	 */
	@Autowired
	ITransactionDao transactionDao;
	@Override
	public Account addAccount(Account account) {
		return transactionDao.addAccount(account);
	}
	/**
	 * @author : Akshat Bharara
	 * Method Name: debitUsingSlip
	 * Method Description: Debit balance from customer's account using slip
	 * Method Last Modified: 07-May-2020
	 */
	@Override
	public Account debitUsingSlip(long id, double amount, String slipNo) {
		// TODO Auto-generated method stub
		
		return transactionDao.debitUsingSlip(id, amount, slipNo);
	}
	
	/**
	 * @author : Akshat Bharara
	 * Method Name: creditUsingCheque
	 * Method Description: Credits balance in customer's account using cheque
	 * Method Last Modified: 07-May-2020
	 */

	@Override
	public Account creditUsingCheque(long id, double amount, String chequeNo) {
		// TODO Auto-generated method stub
		return transactionDao.creditUsingCheque(id, amount, chequeNo);
	}
	/**
	 * @author : Akshat Bharara
	 * Method Name: creditUsingSlip
	 * Method Description: Credits balance in customer's account using slip
	 * Method Last Modified: 07-May-2020
	 */
	@Override
	public Account creditUsingSlip(long id, double amount, String slipNo) {
		// TODO Auto-generated method stub
		return transactionDao.creditUsingSlip(id, amount, slipNo);
	}
	/**
	 * @author : Akshat Bharara
	 * Method Name: debitUsingCheque
	 * Method Description: Debit balance from customer's account using cheque
	 * Method Last Modified: 07-May-2020
	 */
	@Override
	public Account debitUsingCheque(long id, double amount, String chequeNo) {
		// TODO Auto-generated method stub
		
		return transactionDao.debitUsingCheque(id, amount, chequeNo);
	}

}