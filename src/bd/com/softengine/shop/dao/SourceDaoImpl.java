package bd.com.softengine.shop.dao;


import bd.com.softengine.shop.model.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository @Transactional
public class SourceDaoImpl implements SourceDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Source source) {
        hibernateTemplate.persist(source);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Source source) {
        hibernateTemplate.merge(source);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public boolean delete(Source source) {
        hibernateTemplate.delete(source);
        return true;
    }

    @Override
    public List<Source> findAllSource() {
        return (List<Source>) hibernateTemplate.find("from Source");
    }

    @Override
    public Source getSource(Integer id) {
        return hibernateTemplate.get(Source.class, id);
    }

    @Override
    public Source getSource(String name) {
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(name);
        try {
            return (Source) hibernateTemplate.find("from Source where name=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }



}
