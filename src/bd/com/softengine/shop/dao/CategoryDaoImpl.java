package bd.com.softengine.shop.dao;


import bd.com.softengine.shop.model.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository @Transactional
public class CategoryDaoImpl implements CategoryDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private SessionFactory sessionFactory;

 /*   @Autowired
    private HibernateTransactionManager transactionManager;
*/
   // @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Category category) {
        hibernateTemplate.persist(category);
        return true;
    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Category category) {
        hibernateTemplate.merge(category);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public boolean delete(Category category) {
        hibernateTemplate.delete(category);
        return true;
    }

    @Override
    public List<Category> findAllCategory() {
        /*Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT a FROM Category a");
        return query.list();*/
        return (List<Category>) hibernateTemplate.find("from Category");
    }

    @Override
    public Category getCategory(Integer id) {
        return hibernateTemplate.get(Category.class, id);
    }

    @Override
    public Category getCategory(String name) {
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(name);
        try {
            return (Category) hibernateTemplate.find("from Category where name=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }



}
