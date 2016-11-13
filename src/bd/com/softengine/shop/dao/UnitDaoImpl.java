package bd.com.softengine.shop.dao;


import bd.com.softengine.shop.model.MeasurementUnit;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository @Transactional
public class UnitDaoImpl implements UnitDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private SessionFactory sessionFactory;

    //@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(MeasurementUnit unit) {
        hibernateTemplate.persist(unit);
        return true;
    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(MeasurementUnit unit) {
        hibernateTemplate.merge(unit);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public boolean delete(MeasurementUnit unit) {
        hibernateTemplate.delete(unit);
        return true;
    }

    @Override
    public List<MeasurementUnit> findAllMeasurementUnit() {
        /*Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT a FROM MeasurementUnit a");
        return query.list();*/
        return (List<MeasurementUnit>) hibernateTemplate.find("from MeasurementUnit");
    }

    @Override
    public MeasurementUnit getMeasurementUnit(Integer id) {
        return hibernateTemplate.get(MeasurementUnit.class, id);
    }

    @Override
    public MeasurementUnit getMeasurementUnit(String name) {
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(name);
        try {
            return (MeasurementUnit) hibernateTemplate.find("from MeasurementUnit where name=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }



}
