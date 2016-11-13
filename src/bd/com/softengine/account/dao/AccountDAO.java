package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.Account;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface AccountDAO {
    public boolean save(Account account);

    public boolean update(Account account);

    public boolean delete(Account account);

    public List<Account> findAllAccount();

    public Account getAccount(Long id);

}
