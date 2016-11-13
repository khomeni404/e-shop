package bd.com.softengine.shop.dao;

import bd.com.softengine.shop.model.StockLedger;

import java.util.List;

public interface StockLedgerDAO {
    //StockLedger .............
    public boolean save(StockLedger ledger);

    public boolean update(StockLedger ledger);

    public boolean delete(StockLedger ledger);

    public List<StockLedger> findAllStockLedger();

    public StockLedger getStockLedger(Integer id);

    public StockLedger getStockLedger(String name);


}
