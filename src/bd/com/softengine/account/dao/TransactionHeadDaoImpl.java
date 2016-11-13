package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.TransactionHead;
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
public class TransactionHeadDaoImpl implements TransactionHeadDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(TransactionHead withdrawTransactionHead) {
        try {
            hibernateTemplate.persist(withdrawTransactionHead);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(TransactionHead withdrawTransactionHead) {
        hibernateTemplate.merge(withdrawTransactionHead);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(TransactionHead withdrawTransactionHead) {
        hibernateTemplate.delete(withdrawTransactionHead);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<TransactionHead> findAllTransactionHead() {
        return (List<TransactionHead>) hibernateTemplate.find("from TransactionHead");
    }

    @Override
    public TransactionHead getTransactionHead(Long id) {
        return hibernateTemplate.get(TransactionHead.class, id);
    }


}
