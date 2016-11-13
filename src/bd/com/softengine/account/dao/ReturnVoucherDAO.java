package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.ReturnVoucher;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface ReturnVoucherDAO {
    public boolean save(ReturnVoucher voucher);

    public boolean update(ReturnVoucher voucher);

    public boolean delete(ReturnVoucher voucher);

    public List<ReturnVoucher> findAllReturnVoucher();

    public ReturnVoucher getReturnVoucher(Long id);

}
