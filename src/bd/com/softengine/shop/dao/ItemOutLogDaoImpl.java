package bd.com.softengine.shop.dao;


import bd.com.softengine.shop.model.ItemOutLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class ItemOutLogDaoImpl implements ItemOutLogDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(ItemOutLog log) {
        hibernateTemplate.persist(log);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(ItemOutLog log) {
        hibernateTemplate.merge(log);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public boolean delete(ItemOutLog log) {
        hibernateTemplate.delete(log);
        return true;
    }

    @Override
    public List<ItemOutLog> findAllItemOutLog() {
        return (List<ItemOutLog>) hibernateTemplate.find("from ItemOutLog");
    }

    @Override
    public ItemOutLog getItemOutLog(Integer id) {
        return hibernateTemplate.get(ItemOutLog.class, id);
    }

    @Override
    public ItemOutLog getItemOutLog(String name) {
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(name);
        try {
            return (ItemOutLog) hibernateTemplate.find("from ItemOutLog where name=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }



}
