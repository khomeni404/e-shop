package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.ProfitLossLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: M Ayatullah
 * Date: 8/23/14
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository @Transactional
public class ProfitLossLogDAOImpl implements ProfitLossLogDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(ProfitLossLog log) {
        try {
            hibernateTemplate.persist(log);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(ProfitLossLog log) {
        hibernateTemplate.merge(log);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(ProfitLossLog log) {
        hibernateTemplate.delete(log);
        return true;
    }

    @Override
    public List<ProfitLossLog> findAllProfitLossLog() {
        return (List<ProfitLossLog>) hibernateTemplate.find("from ProfitLossLog");
    }

    @Override
    public ProfitLossLog getProfitLossLog(Long id) {
        return hibernateTemplate.get(ProfitLossLog.class, id);
    }


}
