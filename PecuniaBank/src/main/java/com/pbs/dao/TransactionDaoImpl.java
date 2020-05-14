package com.pbs.dao;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.pbs.model.Transaction;
import com.pbs.model.Account;


/**
 * @author Akshat Bharara
 * Description: It is a Rest full Repository class that helps to Store Data for Transactions.
 * version: 1.0
 * Last Modified Date: 07-May-2020
 *
 */
@Repository
@Transactional
public class TransactionDaoImpl implements ITransactionDao {

	@PersistenceContext
	EntityManager entityManager;
	/**
	 * @author : Akshat Bharara
	 * Method Name: addAccount
	 * Method Description: Add Account in bank database to show transaction details
	 * Method Last Modified: 07-May-2020
	 */
	@Override
	public Account addAccount(Account account) {

		entityManager.persist(account);

		return account;

	}
	
	/**
	 * @author : Akshat Bharara
	 * Method Name: creditUsingSlip
	 * Method Description: Credits balance in customer's account using slip
	 * Method Last Modified: 07-May-2020
	 */

	@Override
	public Account creditUsingSlip(long id, double amount, String slip) {
		Account account = entityManager.find(Account.class, id);
		try {
			account.setAmount(amount + account.getAmount());
		} catch (Exception e) {
			return null;
		}
		Transaction transaction = new Transaction("Deposited Using Slip", id, amount, LocalDate.now());
		transaction.setSlipNo(slip);

		entityManager.persist(transaction);

		return entityManager.merge(account);
	}
	
	/**
	 * @author : Akshat Bharara
	 * Method Name: debitUsingSlip
	 * Method Description: Debit balance from customer's account using slip
	 * Method Last Modified: 07-May-2020
	 */

	@Override
	public Account debitUsingSlip(long id, double amount, String slip) {
		Account account = entityManager.find(Account.class, id);

		try {
			if(account.getAmount()>amount) {
		account.setAmount(account.getAmount() - amount);
			}
		} catch (Exception e) {
			return null;
		}
		Transaction transaction = new Transaction("Withdrawn Using Slip", id, amount, LocalDate.now());
		transaction.setSlipNo(slip);

		entityManager.persist(transaction);


		return entityManager.merge(account);
	}
	/**
	 * @author : Akshat Bharara
	 * Method Name: debitUsingCheque
	 * Method Description: Debit balance from customer's account using cheque
	 * Method Last Modified: 07-May-2020
	 */
	@Override
	public Account debitUsingCheque(long id, double amount, String chequeNo) {
		Account account = entityManager.find(Account.class, id);
		account.setAmount(account.getAmount() - amount);

		Transaction transaction = new Transaction("Withdrawn Using Cheque", id, amount, LocalDate.now());
		transaction.setChequeNo(chequeNo);

		entityManager.persist(transaction);

		return entityManager.merge(account);
	}
	/**
	 * @author : Akshat Bharara
	 * Method Name: creditUsingCheque
	 * Method Description: Credits balance in customer's account using cheque
	 * Method Last Modified: 07-May-2020
	 */

	@Override
	public Account creditUsingCheque(long id, double amount, String chequeNo) {
		Account account = entityManager.find(Account.class, id);
		try {
			account.setAmount(amount + account.getAmount());
		} catch (Exception e) {
			return null;
		}
		Transaction transaction = new Transaction("Deposited Using Cheque", id, amount, LocalDate.now());
		transaction.setChequeNo(chequeNo);
		entityManager.persist(transaction);

		return entityManager.merge(account);
	}

}