package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.DrCrVoucher;
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
public class DrCrVoucherDAOImpl implements DrCrVoucherDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(DrCrVoucher withdrawDrCrVoucher) {
        try {
            hibernateTemplate.persist(withdrawDrCrVoucher);
            //hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(DrCrVoucher withdrawDrCrVoucher) {
        hibernateTemplate.merge(withdrawDrCrVoucher);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(DrCrVoucher withdrawDrCrVoucher) {
        hibernateTemplate.delete(withdrawDrCrVoucher);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<DrCrVoucher> findAllDrCrVoucher() {
        return (List<DrCrVoucher>) hibernateTemplate.find("from DrCrVoucher");
    }

    @Override
    public DrCrVoucher getDrCrVoucher(Long id) {
        return hibernateTemplate.get(DrCrVoucher.class, id);
    }


}
