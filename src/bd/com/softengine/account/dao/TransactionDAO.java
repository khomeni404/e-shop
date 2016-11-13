package bd.com.softengine.account.dao;



import bd.com.softengine.account.model.BankAccount;
import bd.com.softengine.account.model.Transaction;
import bd.com.softengine.account.model.TransactionHead;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface TransactionDAO {
    public boolean save(Transaction transaction);

    public boolean update(Transaction transaction);

    public boolean delete(Transaction transaction);

    public List<Transaction> findAllTransaction();

    public List<Transaction> findAllTransaction(BankAccount account, TransactionHead transactionHead, Date from, Date to);

    public List<Object[]> findTransactionData(BankAccount account, String drCr, TransactionHead head, Date from, Date to);

    public Transaction getTransaction(Long id);

}
