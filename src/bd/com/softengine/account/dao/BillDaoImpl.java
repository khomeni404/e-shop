package bd.com.softengine.account.dao;


import bd.com.softengine.util.DateUtil;
import bd.com.softengine.account.model.*;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: M Ayatullah
 * Date: 8/23/15
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository @Transactional
public class BillDaoImpl implements BillDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Bill bill) {
        try {
            hibernateTemplate.persist(bill);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Bill bill) {
        hibernateTemplate.merge(bill);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Bill bill) {
        hibernateTemplate.delete(bill);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Bill> findAllBill() {
        return (List<Bill>)  hibernateTemplate.find("from Bill order by voucherNo asc ");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Bill> findAllBill(CashAccount account, BillHead head, Date from, Date to) {
        if (head == null) {
            Object[] param = new Object[]{account, from, to};
            return (List<Bill>) hibernateTemplate.find("from Bill where cashAccount=? and voucherDate between ? and ? order by voucherNo asc", param );
        }   else {
            Object[] param = new Object[]{account, head, from, to};
            return (List<Bill>) hibernateTemplate.find("from Bill where cashAccount=? and billHead=? and voucherDate between ? and ? order by voucherNo asc", param );
        }
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> findBillData(CashAccount account, String drCr, BillHead head, Date from, Date to) {
        Query query = null;
        try {
            if (head == null) {
                query = hibernateTemplate.getSessionFactory().getCurrentSession()
                        .createQuery("select sum(bill.amount), count(bill.id), bill from Bill bill " +
                                "where  cashAccount = :cashAccount and drCr = :drCr and voucherDate between :fromDate and :toDate");      // WHERE DATE_FORMAT(txnlog.txnDatetime, '%Y-%m-%d') = CURDATE() group by txnlog.transactionId
            }else{
                query = hibernateTemplate.getSessionFactory().getCurrentSession()
                        .createQuery("select sum(bill.amount), count(bill.id), bill from Bill bill " +
                                "where  cashAccount = :cashAccount and drCr = :drCr and billHead = :head and voucherDate between :fromDate and :toDate");      // WHERE DATE_FORMAT(txnlog.txnDatetime, '%Y-%m-%d') = CURDATE() group by txnlog.transactionId
                query.setParameter("head", head);
            }
            query.setParameter("cashAccount", account);
            query.setParameter("drCr", drCr);
            query.setParameter("fromDate", from);
            query.setParameter("toDate", to);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (query != null)
            return (List<Object[]>) query.list();
        else return null;
    }

    @Override
    public Bill getBill(Long id) {
        return hibernateTemplate.get(Bill.class, id);
    }

    @Override
    public Bill getBill(String voucherNo, String mmYY) {
        Object[] param = new Object[3];
        param[0] = voucherNo;
        param[1] = DateUtil.getFirstLastDate(mmYY)[0];
        param[2] = DateUtil.getFirstLastDate(mmYY)[1];
        try {
            return (Bill) hibernateTemplate.find("from Bill where voucherDate between ? and ?", param).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
