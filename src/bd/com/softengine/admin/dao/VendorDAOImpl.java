package bd.com.softengine.admin.dao;


import bd.com.softengine.admin.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class VendorDAOImpl implements VendorDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Vendor user) {
        hibernateTemplate.persist(user);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Vendor user) {
        hibernateTemplate.merge(user);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public boolean delete(Vendor user) {
        hibernateTemplate.delete(user);
        return true;
    }

    @Override
    public List<Vendor> findAllVendor() {
        return (List<Vendor>) hibernateTemplate.find("from Vendor");
    }

    @Override
    public Vendor getVendor(Long id) {
        return hibernateTemplate.get(Vendor.class, id);
    }

    @Override
    public Vendor getVendor(String name) {
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(name);
        try {
            return (Vendor) hibernateTemplate.find("from Vendor where name=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }



}
