package bd.com.softengine.shop.dao;


import bd.com.softengine.shop.model.ItemInLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository @Transactional
public class ItemInLogDaoImpl implements ItemInLogDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(ItemInLog log) {
        hibernateTemplate.persist(log);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(ItemInLog log) {
        hibernateTemplate.merge(log);
        return true;
    }

    @Override
    public boolean delete(ItemInLog log) {
        hibernateTemplate.delete(log);
        return true;
    }

    @Override
    public List<ItemInLog> findAllItemInLog() {
        return (List<ItemInLog>) hibernateTemplate.find("from ItemInLog");
    }

    @Override
    public ItemInLog getItemInLog(Integer id) {
        return hibernateTemplate.get(ItemInLog.class, id);
    }

    @Override
    public ItemInLog getItemInLog(String name) {
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(name);
        try {
            return (ItemInLog) hibernateTemplate.find("from ItemInLog where name=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }



}
