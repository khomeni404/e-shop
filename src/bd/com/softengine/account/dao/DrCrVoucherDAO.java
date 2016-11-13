package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.DrCrVoucher;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface DrCrVoucherDAO {
    public boolean save(DrCrVoucher voucher);

    public boolean update(DrCrVoucher voucher);

    public boolean delete(DrCrVoucher voucher);

    public List<DrCrVoucher> findAllDrCrVoucher();

    public DrCrVoucher getDrCrVoucher(Long id);

}
