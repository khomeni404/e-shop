package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.BankAccount;
import bd.com.softengine.account.model.Transaction;
import bd.com.softengine.account.model.TransactionHead;
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
public class TransactionDaoImpl implements TransactionDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Transaction transaction) {
        try {
            hibernateTemplate.persist(transaction);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Transaction transaction) {
        hibernateTemplate.merge(transaction);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Transaction transaction) {
        hibernateTemplate.delete(transaction);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<Transaction> findAllTransaction() {
        return (List<Transaction>) hibernateTemplate.find("from Transaction");
    }

    @Override
    public List<Transaction> findAllTransaction(BankAccount account, TransactionHead head, Date from, Date to) {
        //List<Object[]> list = findTransactionData( account, "DR",  head,  from,  to);
        if (head == null) {
            Object[] param = new Object[3];
            param[0] = account;
            param[1] = from;
            param[2] = to;
            return (List<Transaction>) hibernateTemplate.find("from Transaction where bankAccount=? and voucherDate between ? and ?", param);

        }else{
            Object[] param = new Object[4];
            param[0] = account;
            param[1] = head;
            param[2] = from;
            param[3] = to;
            return (List<Transaction>) hibernateTemplate.find("from Transaction where bankAccount=? and transactionHead=? and voucherDate between ? and ?", param);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> findTransactionData(BankAccount account, String drCr, TransactionHead head, Date from, Date to) {
        Query query = null;
        try {
            if (head == null) {
                query = hibernateTemplate.getSessionFactory().getCurrentSession()
                        .createQuery("select sum(txn.amount), count(txn.id),txn from Transaction txn " +
                                "where  bankAccount = :bankAccount and drCr = :drCr and voucherDate between :fromDate and :toDate");      // WHERE DATE_FORMAT(txnlog.txnDatetime, '%Y-%m-%d') = CURDATE() group by txnlog.transactionId
            } else {
                query = hibernateTemplate.getSessionFactory().getCurrentSession()
                        .createQuery("select sum(txn.amount), count(txn.id),txn from Transaction txn " +
                                "where  bankAccount = :bankAccount and drCr = :drCr and transactionHead = :head and voucherDate between :fromDate and :toDate");      // WHERE DATE_FORMAT(txnlog.txnDatetime, '%Y-%m-%d') = CURDATE() group by txnlog.transactionId

                query.setParameter("head", head);
            }

            query.setParameter("bankAccount", account);
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
    public Transaction getTransaction(Long id) {
        return hibernateTemplate.get(Transaction.class, id);
    }


}
