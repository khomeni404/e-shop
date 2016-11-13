package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.BillHead;
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
public class BillHeadDaoImpl implements BillHeadDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(BillHead head) {
        try {
            hibernateTemplate.persist(head);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(BillHead head) {
        hibernateTemplate.merge(head);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(BillHead head) {
        hibernateTemplate.delete(head);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<BillHead> findAllBillHead() {
        return (List<BillHead>) hibernateTemplate.find("from BillHead");
    }

    @Override
    public BillHead getBillHead(Long id) {
        return hibernateTemplate.get(BillHead.class, id);
    }
    @Override
    public BillHead getBillHead(String name) {
        Object[] param = new Object[1];
        param[0] = name;
        try {
            return (BillHead) hibernateTemplate.find("from BillHead where name=?", param).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }


}
