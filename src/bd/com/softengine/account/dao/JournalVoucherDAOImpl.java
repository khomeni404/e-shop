package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.JournalVoucher;
import bd.com.softengine.admin.model.Staff;
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
public class JournalVoucherDAOImpl implements JournalVoucherDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(JournalVoucher withdrawJournalVoucher) {
        try {
            hibernateTemplate.persist(withdrawJournalVoucher);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(JournalVoucher withdrawJournalVoucher) {
        hibernateTemplate.merge(withdrawJournalVoucher);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(JournalVoucher withdrawJournalVoucher) {
        hibernateTemplate.delete(withdrawJournalVoucher);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<JournalVoucher> findAllJournalVoucher() {
        return (List<JournalVoucher>) hibernateTemplate.find("from JournalVoucher");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<JournalVoucher> findAllJournalVoucher(Integer status) {
        Object[] param = new Object[]{status};
        return (List<JournalVoucher>) hibernateTemplate.find("from JournalVoucher where status = ?", param);
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<JournalVoucher> findAllJournalVoucher(Integer status, Staff staff) {
        Object[] param = new Object[]{status, staff};
        return (List<JournalVoucher>) hibernateTemplate.find("from JournalVoucher where status = ? and receiver = ?", param);
    }

    @Override
    public JournalVoucher getJournalVoucher(Integer id) {
        return hibernateTemplate.get(JournalVoucher.class, id);
    }


}
