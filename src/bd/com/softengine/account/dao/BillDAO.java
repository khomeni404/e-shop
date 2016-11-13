package bd.com.softengine.account.dao;



import bd.com.softengine.account.model.*;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface BillDAO {
    public boolean save(Bill bill);

    public boolean update(Bill bill);

    public boolean delete(Bill bill);

    public List<Bill> findAllBill();

    public List<Bill> findAllBill(CashAccount account, BillHead head, Date from, Date to);

    public List<Object[]> findBillData(CashAccount account, String drCr, BillHead head, Date from, Date to);

    public Bill getBill(Long id);

    public Bill getBill(String voucherNo, String mmYY);

}
