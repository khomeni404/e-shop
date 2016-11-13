package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.BillHead;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface BillHeadDAO {
    public boolean save(BillHead head);

    public boolean update(BillHead head);

    public boolean delete(BillHead head);

    public List<BillHead> findAllBillHead();

    public BillHead getBillHead(Long id);

    public BillHead getBillHead(String name);

}
