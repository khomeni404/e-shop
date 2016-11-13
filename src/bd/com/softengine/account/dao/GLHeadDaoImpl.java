package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.GLHead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: M Ayatullah
 * Date: 8/23/15
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository @Transactional
public class GLHeadDaoImpl implements GLHeadDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(GLHead withdrawGLHead) {
        try {
            hibernateTemplate.persist(withdrawGLHead);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(GLHead withdrawGLHead) {
        hibernateTemplate.merge(withdrawGLHead);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(GLHead withdrawGLHead) {
        hibernateTemplate.delete(withdrawGLHead);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<GLHead> findAllGLHead() {
        return (List<GLHead>) hibernateTemplate.find("from GLHead");
    }

    @Override
    public GLHead getGLHead(Long id) {
        return hibernateTemplate.get(GLHead.class, id);
    }


}
