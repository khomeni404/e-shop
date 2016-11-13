package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.Voucher;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface VoucherDAO {
    public boolean save(Voucher voucher);

    public boolean update(Voucher voucher);

    public boolean delete(Voucher voucher);

    public List<Voucher> findAllVoucher();

    public Voucher getVoucher(Long id);

    public Voucher getVoucher(String vrNo);

    public List<Voucher> getVoucherList(String status);

    public List<Voucher> findAllVoucher(Boolean b);
}
