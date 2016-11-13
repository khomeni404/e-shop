package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.ProfitLossLedger;
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
public class ProfitLossLedgerDAOImpl implements ProfitLossLedgerDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(ProfitLossLedger ledger) {
        try {
            hibernateTemplate.persist(ledger);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(ProfitLossLedger ledger) {
        hibernateTemplate.merge(ledger);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(ProfitLossLedger ledger) {
        hibernateTemplate.delete(ledger);
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProfitLossLedger> findAllProfitLossLedger() {
        return (List<ProfitLossLedger>) hibernateTemplate.find("from ProfitLossLedger");
    }

    @Override
    public ProfitLossLedger getProfitLossLedger(Integer id) {
        return hibernateTemplate.get(ProfitLossLedger.class, id);
    }
}
