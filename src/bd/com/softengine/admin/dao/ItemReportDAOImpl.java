package bd.com.softengine.admin.dao;


import bd.com.softengine.admin.model.ItemReport;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class ItemReportDAOImpl implements ItemReportDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(ItemReport report) {
        hibernateTemplate.persist(report);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(ItemReport report) {
        hibernateTemplate.merge(report);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public boolean delete(ItemReport report) {
        hibernateTemplate.delete(report);
        return true;
    }

    @Override
    public List<ItemReport> findAllItemReport() {
        return (List<ItemReport>) hibernateTemplate.find("from ItemReport");
    }

    @Override
    public ItemReport getItemReport(Integer id) {
        return hibernateTemplate.get(ItemReport.class, id);
    }

    @Override
    public ItemReport getItemReport(String name) {
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(name);
        try {
            return (ItemReport) hibernateTemplate.find("from ItemReport where name=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public Integer count() {
        Session session = hibernateTemplate.getSessionFactory().openSession();
        return  ((Long) session.createQuery("select count(*) from ItemReport").uniqueResult()).intValue();
    }
}
