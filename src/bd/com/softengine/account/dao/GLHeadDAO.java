package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.GLHead;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface GLHeadDAO {
    public boolean save(GLHead head);

    public boolean update(GLHead head);

    public boolean delete(GLHead head);

    public List<GLHead> findAllGLHead();

    public GLHead getGLHead(Long id);

}
