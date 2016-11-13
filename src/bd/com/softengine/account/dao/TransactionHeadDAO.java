package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.TransactionHead;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface TransactionHeadDAO {
    public boolean save(TransactionHead head);

    public boolean update(TransactionHead head);

    public boolean delete(TransactionHead head);

    public List<TransactionHead> findAllTransactionHead();

    public TransactionHead getTransactionHead(Long id);

}
