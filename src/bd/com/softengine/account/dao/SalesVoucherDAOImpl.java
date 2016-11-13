package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.SalesVoucher;
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
public class SalesVoucherDAOImpl implements SalesVoucherDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(SalesVoucher withdrawSalesVoucher) {
        try {
            hibernateTemplate.persist(withdrawSalesVoucher);
            //hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(SalesVoucher withdrawSalesVoucher) {
        hibernateTemplate.merge(withdrawSalesVoucher);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(SalesVoucher withdrawSalesVoucher) {
        hibernateTemplate.delete(withdrawSalesVoucher);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<SalesVoucher> findAllSalesVoucher() {
        return (List<SalesVoucher>) hibernateTemplate.find("from SalesVoucher");
    }

    @Override
    public SalesVoucher getSalesVoucher(Long id) {
        return hibernateTemplate.get(SalesVoucher.class, id);
    }


}
