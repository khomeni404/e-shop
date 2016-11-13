package bd.com.softengine.shop.dao;


import bd.com.softengine.shop.model.ItemOutLog;
import bd.com.softengine.shop.model.SalesLedger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class SalesLedgerDaoImpl implements SalesLedgerDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(SalesLedger ledger) {
        hibernateTemplate.persist(ledger);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(SalesLedger ledger) {
        hibernateTemplate.merge(ledger);
        //hibernateTemplate.flush();
        return true;
    }

    @Override
    public boolean delete(SalesLedger ledger) {
        List<ItemOutLog> itemOutLogsList = ledger.getOutLogList();
        hibernateTemplate.deleteAll(itemOutLogsList);
        hibernateTemplate.delete(ledger);
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SalesLedger> findAllSalesLedger() {
        return (List<SalesLedger>) hibernateTemplate.find("from SalesLedger");
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<SalesLedger> findAllSalesLedger(String searchText) {
        Object[] param = new Object[]{
                "%"+searchText+"%"
        };
        return (List<SalesLedger>) hibernateTemplate.find("from SalesLedger where orderNo like ?", param);
    }

    @Override
    public List<SalesLedger> findAllSalesLedger(int start, int limit) {
        return null;
    }

    @Override
    public SalesLedger getSalesLedger(Integer id) {
        return hibernateTemplate.get(SalesLedger.class, id);
    }

    @Override
    public SalesLedger getSalesLedger(String name) {
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(name);
        try {
            return (SalesLedger) hibernateTemplate.find("from SalesLedger where name=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }



}
