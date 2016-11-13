package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.BankAccount;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface BankAccountDAO {
    public boolean save(BankAccount account);

    public boolean update(BankAccount account);

    public boolean delete(BankAccount account);

    public List<BankAccount> findAllBankAccount();

    public BankAccount getBankAccount(Long id);

}
