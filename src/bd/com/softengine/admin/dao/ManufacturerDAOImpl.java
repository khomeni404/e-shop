package bd.com.softengine.admin.dao;


import bd.com.softengine.admin.model.Manufacturer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class ManufacturerDAOImpl implements ManufacturerDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Manufacturer manufacturer) {
        hibernateTemplate.persist(manufacturer);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Manufacturer manufacturer) {
        hibernateTemplate.merge(manufacturer);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public boolean delete(Manufacturer manufacturer) {
        hibernateTemplate.delete(manufacturer);
        return true;
    }

    @Override
    public List<Manufacturer> findAllManufacturer() {
        return (List<Manufacturer>) hibernateTemplate.find("from Manufacturer");
    }

    @Override
    public Manufacturer getManufacturer(Integer id) {
        return hibernateTemplate.get(Manufacturer.class, id);
    }

    @Override
    public Manufacturer getManufacturer(String name) {
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(name);
        try {
            return (Manufacturer) hibernateTemplate.find("from Manufacturer where name=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public Integer count() {
        Session session = hibernateTemplate.getSessionFactory().openSession();
        return  ((Long) session.createQuery("select count(*) from Manufacturer").uniqueResult()).intValue();
    }
}
