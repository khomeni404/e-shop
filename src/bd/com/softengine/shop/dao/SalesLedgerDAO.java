package bd.com.softengine.shop.dao;

import bd.com.softengine.shop.model.SalesLedger;

import java.util.List;

public interface SalesLedgerDAO {
    //SalesLedger .............
    public boolean save(SalesLedger ledger);

    public boolean update(SalesLedger ledger);

    public boolean delete(SalesLedger ledger);

    public List<SalesLedger> findAllSalesLedger();
    public List<SalesLedger> findAllSalesLedger(String searchText);
    public List<SalesLedger> findAllSalesLedger(int start, int limit);

    public SalesLedger getSalesLedger(Integer id);

    public SalesLedger getSalesLedger(String name);


}
