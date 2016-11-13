package bd.com.softengine.admin.dao;


import bd.com.softengine.admin.model.Customer;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Customer user) {
        hibernateTemplate.persist(user);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Customer user) {
        hibernateTemplate.merge(user);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public boolean delete(Customer user) {
        hibernateTemplate.delete(user);
        return true;
    }

    @Override
    public List<Customer> findAllCustomer() {
        return (List<Customer>) hibernateTemplate.find("from Customer");
    }

    @Override
    public Customer getCustomer(Long id) {
        return hibernateTemplate.get(Customer.class, id);
    }

    @Override
    public Customer getCustomer(String name) {
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(name);
        try {
            return (Customer) hibernateTemplate.find("from Customer where name=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public Integer count() {
        Session session = hibernateTemplate.getSessionFactory().openSession();
        return  ((Long) session.createQuery("select count(*) from Customer").uniqueResult()).intValue();
    }
}
