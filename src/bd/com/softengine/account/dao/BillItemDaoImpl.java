package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.Bill;
import bd.com.softengine.account.model.BillItem;
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
public class BillItemDaoImpl implements BillItemDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(BillItem item) {
        try {
            hibernateTemplate.persist(item);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(BillItem item) {
        hibernateTemplate.merge(item);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(BillItem item) {
        hibernateTemplate.delete(item);
        hibernateTemplate.flush();
        return true;
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean deleteAllBillItem(Bill bill) {
        Object[] param = new Object[1];
        param[0] = bill;
        List<BillItem> list =  (List<BillItem>) hibernateTemplate.find("from BillItem where bill=?", param);
        hibernateTemplate.deleteAll(list);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<BillItem> findAllBillItem() {
        return (List<BillItem>) hibernateTemplate.find("from BillItem");
    }

    @Override
    public BillItem getBillItem(Long id) {
        return hibernateTemplate.get(BillItem.class, id);
    }


}
