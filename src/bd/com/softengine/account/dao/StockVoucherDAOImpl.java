package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.StockVoucher;
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
public class StockVoucherDAOImpl implements StockVoucherDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(StockVoucher withdrawStockVoucher) {
        try {
            hibernateTemplate.persist(withdrawStockVoucher);
            //hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(StockVoucher withdrawStockVoucher) {
        hibernateTemplate.merge(withdrawStockVoucher);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(StockVoucher withdrawStockVoucher) {
        hibernateTemplate.delete(withdrawStockVoucher);
        return true;
    }

    @Override
    public List<StockVoucher> findAllStockVoucher() {
        return (List<StockVoucher>) hibernateTemplate.find("from StockVoucher");
    }

    @Override
    public StockVoucher getStockVoucher(Long id) {
        return hibernateTemplate.get(StockVoucher.class, id);
    }


}
