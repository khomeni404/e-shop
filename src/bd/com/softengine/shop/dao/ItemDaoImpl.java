package bd.com.softengine.shop.dao;


import bd.com.softengine.shop.model.Item;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class ItemDaoImpl implements ItemDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Item item) {
        hibernateTemplate.persist(item);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Item item) {
        hibernateTemplate.merge(item);
        return true;
    }

    @Override
    public boolean delete(Item item) {
        hibernateTemplate.delete(item);
        return true;
    }

    @Override
    public List<Item> findAllItem() {
        return (List<Item>) hibernateTemplate.find("from Item");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Item> findAllItem(Double stock, boolean less) {
        Object[] param = new Object[1];
        param[0] = stock;
        if (less) {
           return  (List<Item>) hibernateTemplate.find("from Item where stock < ?", param);
        }else {
            return  (List<Item>) hibernateTemplate.find("from Item where stock > ?", param);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> findAllItemWithDetails() {
        Query query = null;
        try {
            query = hibernateTemplate.getSessionFactory().getCurrentSession()
                        .createQuery("select sum(bill.amount), count(bill.id), bill from Bill bill " +
                                "where  cashAccount = :cashAccount and drCr = :drCr and voucherDate between :fromDate and :toDate");      // WHERE DATE_FORMAT(txnlog.txnDatetime, '%Y-%m-%d') = CURDATE() group by txnlog.transactionId

            //query.setParameter("cashAccount", account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (query != null)
            return (List<Object[]>) query.list();
        else return null;
    }

    @Override
    public Item getItem(Integer id) {
        return hibernateTemplate.get(Item.class, id);
    }

    @Override
    public Item getItem(String name) {
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(name);
        try {
            return (Item) hibernateTemplate.find("from Item where name=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }



}
