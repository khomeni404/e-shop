package bd.com.softengine.shop.dao;


import bd.com.softengine.shop.model.StockLedger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository @Transactional
public class StockLedgerDaoImpl implements StockLedgerDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(StockLedger ledger) {
        hibernateTemplate.persist(ledger);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(StockLedger ledger) {
        hibernateTemplate.merge(ledger);
        return true;
    }

    @Override
    public boolean delete(StockLedger ledger) {
        hibernateTemplate.delete(ledger);
        return true;
    }

    @Override
    public List<StockLedger> findAllStockLedger() {
        return (List<StockLedger>) hibernateTemplate.find("from StockLedger");
    }

    @Override
    public StockLedger getStockLedger(Integer id) {
        return hibernateTemplate.get(StockLedger.class, id);
    }

    @Override
    public StockLedger getStockLedger(String name) {
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(name);
        try {
            return (StockLedger) hibernateTemplate.find("from StockLedger where name=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }



}
