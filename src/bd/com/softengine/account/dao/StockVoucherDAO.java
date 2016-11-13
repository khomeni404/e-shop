package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.StockVoucher;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface StockVoucherDAO {
    public boolean save(StockVoucher voucher);

    public boolean update(StockVoucher voucher);

    public boolean delete(StockVoucher voucher);

    public List<StockVoucher> findAllStockVoucher();

    public StockVoucher getStockVoucher(Long id);

}
