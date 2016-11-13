package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.SalesVoucher;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface SalesVoucherDAO {
    public boolean save(SalesVoucher voucher);

    public boolean update(SalesVoucher voucher);

    public boolean delete(SalesVoucher voucher);

    public List<SalesVoucher> findAllSalesVoucher();

    public SalesVoucher getSalesVoucher(Long id);

}
