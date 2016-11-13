package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.Bill;
import bd.com.softengine.account.model.BillItem;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface BillItemDAO {
    public boolean save(BillItem BillItem);

    public boolean update(BillItem BillItem);

    public boolean delete(BillItem BillItem);

    public boolean deleteAllBillItem(Bill bill)  ;

    public List<BillItem> findAllBillItem();

    public BillItem getBillItem(Long id);

}
