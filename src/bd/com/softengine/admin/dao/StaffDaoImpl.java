package bd.com.softengine.admin.dao;


import bd.com.softengine.admin.model.Staff;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class StaffDaoImpl implements StaffDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Staff user) {
        hibernateTemplate.persist(user);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Staff user) {
        hibernateTemplate.merge(user);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public boolean delete(Staff user) {
        hibernateTemplate.delete(user);
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Staff> findAllStaff() {
        return (List<Staff>) hibernateTemplate.find("from Staff");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Staff> findAllStaff(Integer staffType) {
        Object[] param = new Object[]{staffType};
        return (List<Staff>) hibernateTemplate.find("from Staff where staffType = ?", param);
    }


    @Override
    public Staff getStaff(Long id) {
        return hibernateTemplate.get(Staff.class, id);
    }

    @Override
    public Staff getStaff(String name) {
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(name);
        try {
            return (Staff) hibernateTemplate.find("from Staff where name=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public Integer count() {
        Session session = hibernateTemplate.getSessionFactory().openSession();
        return  ((Long) session.createQuery("select count(*) from Staff").uniqueResult()).intValue();
    }



}
