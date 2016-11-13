package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: M Ayatullah
 * Date: 8/23/15
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional
public class AccountDaoImpl implements AccountDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Account account) {
        try {
            hibernateTemplate.persist(account);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Account account) {
        hibernateTemplate.merge(account);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Account account) {
        hibernateTemplate.delete(account);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<Account> findAllAccount() {
        return (List<Account>) hibernateTemplate.find("from Account");
    }

    @Override
    public Account getAccount(Long id) {
        return hibernateTemplate.get(Account.class, id);
    }


}
