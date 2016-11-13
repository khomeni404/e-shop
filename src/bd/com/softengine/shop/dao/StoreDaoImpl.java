package bd.com.softengine.shop.dao;


//import com.bd.bd.com.softengine.shop.model.Store;
import bd.com.softengine.shop.model.Store;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class StoreDaoImpl implements StoreDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(propagation =  Propagation.REQUIRED, readOnly = false)
    public boolean save(Store store) {
        hibernateTemplate.persist(store);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Store store) {
        hibernateTemplate.merge(store);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public boolean delete(Store store) {
        hibernateTemplate.delete(store);
        return true;
    }

    @Override
    public List<Store> findAllStore() {
        return (List<Store>) hibernateTemplate.find("from Store");
    }

    @Override
    public List<Object[]> findAllStoreComboData() {
        Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(Store.class);
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("id"));
        projectionList.add(Projections.property("name"));
        criteria.setProjection(projectionList);
        List results = criteria.list();
        return results;
    }

    @Override
    public Store getStore(Integer id) {
        return hibernateTemplate.get(Store.class, id);
    }

    @Override
    public Store getStore(String name) {
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(name);
        try {
            return (Store) hibernateTemplate.find("from Store where name=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }



}
