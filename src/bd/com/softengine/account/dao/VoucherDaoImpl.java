package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: M Ayatullah
 * Date: 8/23/14
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository @Transactional
public class VoucherDaoImpl implements VoucherDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Voucher withdrawVoucher) {
        try {
            hibernateTemplate.persist(withdrawVoucher);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Voucher withdrawVoucher) {
        hibernateTemplate.merge(withdrawVoucher);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Voucher withdrawVoucher) {
        hibernateTemplate.delete(withdrawVoucher);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<Voucher> findAllVoucher() {
        return (List<Voucher>) hibernateTemplate.find("from Voucher");
    }

    @Override
    public Voucher getVoucher(Long id) {
        return hibernateTemplate.get(Voucher.class, id);
    }


    @Override
    public Voucher getVoucher(String vrNo) {
        try {
            return (Voucher) hibernateTemplate.find("from Voucher where voucherNo=?", vrNo).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Voucher> getVoucherList(String status) {
        return (List<Voucher>) hibernateTemplate.find("from Voucher where status=?", status);
    }

    @Override
    public List<Voucher> findAllVoucher(Boolean b) {
        /*
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(b+"");
        return (Voucher) hibernateTemplate.find("from Voucher where CID=?", paramArr).get(0);
        */
        return new ArrayList<Voucher>();
    }
    /*
    public List doInHibernate(Session session, String name, String ids) throws HibernateException, SQLException {
        Query query = session.createQuery(
                "select distinct ci.customer " +
                        "from CustomerInvoice ci " +
                        "where ci.name = :name and ci.id in (:ids) "
        );
        query.setParameter("name", name);
        query.setParameterList("ids", ids);
        return query.list();
    }
    */
}
