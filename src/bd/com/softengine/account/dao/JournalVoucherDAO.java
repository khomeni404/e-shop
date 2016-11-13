package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.JournalVoucher;
import bd.com.softengine.admin.model.Staff;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface JournalVoucherDAO {
    public boolean save(JournalVoucher voucher);

    public boolean update(JournalVoucher voucher);

    public boolean delete(JournalVoucher voucher);

    public List<JournalVoucher> findAllJournalVoucher();

    public List<JournalVoucher> findAllJournalVoucher(Integer status);

    public List<JournalVoucher> findAllJournalVoucher(Integer status, Staff staff);

    public JournalVoucher getJournalVoucher(Integer id);

}
