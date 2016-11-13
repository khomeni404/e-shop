package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.CashAccount;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface CashAccountDAO {
    public boolean save(CashAccount account);

    public boolean update(CashAccount account);

    public boolean delete(CashAccount account);

    public List<CashAccount> findAllCashAccount();

    public CashAccount getCashAccount(Long id);

}
