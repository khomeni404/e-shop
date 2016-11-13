package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.CashAccount;
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
@Repository @Transactional
public class CashAccountDaoImpl implements CashAccountDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(CashAccount account) {
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
    public boolean update(CashAccount account) {
        hibernateTemplate.merge(account);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(CashAccount account) {
        hibernateTemplate.delete(account);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<CashAccount> findAllCashAccount() {
        return (List<CashAccount>) hibernateTemplate.find("from CashAccount");
    }

    @Override
    public CashAccount getCashAccount(Long id) {
        return hibernateTemplate.get(CashAccount.class, id);
    }


}
