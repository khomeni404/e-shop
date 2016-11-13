package bd.com.softengine.shop.service;


import bd.com.softengine.admin.model.Staff;
import bd.com.softengine.shop.model.*;

import java.util.Date;
import java.util.List;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 30/11/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 30/11/15
 * Version : 1.0
 */

public interface ShopService {
    public boolean save(Store store);

    public boolean update(Store store);

    public boolean delete(Store store);

    public List<Store> findAllStore();

    public List<Store> findAllStoreComboData();

    public Store getStore(Integer id);

    public Store getStore(String name);

    //Category .............
    public boolean save(Category category);

    public boolean update(Category category);

    public boolean delete(Category category);

    public List<Category> findAllCategory();

    public Category getCategory(Integer id);

    public Category getCategory(String name);

    //MeasurementUnit .............
    public boolean save(MeasurementUnit unit);

    public boolean update(MeasurementUnit unit);

    public boolean delete(MeasurementUnit unit);

    public List<MeasurementUnit> findAllMeasurementUnit();

    public MeasurementUnit getMeasurementUnit(Integer id);

    public MeasurementUnit getMeasurementUnit(String name);

    //Item .............
    public boolean save(Item item);

    public boolean update(Item item);
    
    public boolean updateItem(
             Integer id,
             String code,
             String name,
             Double labeledPrice,
             Double stock,
             Staff operator
    );

    public boolean delete(Item item);

    public List<Item> findAllItem();

    public List<Object[]> findAllItemWithDetails();

    public List<Item> findAllItem(Double stock, boolean less);

    public Item getItem(Integer id);

    public Item getItem(String name);

    //SalesLedger .............
    public boolean saveSalesLedger(
            Staff operator,
            String customerName,
            Long customerId,
            String sourceName,
            Integer storeId,
            String itemArr,
            String qtyArr,
            String priceArr,
            String discountArr,
            String totPriceArr,
            Double roundDiscount,
            Double paid
    );

    public boolean save(SalesLedger ledger);

    public boolean update(SalesLedger ledger);

    public boolean delete(SalesLedger ledger);

    public List<SalesLedger> findAllSalesLedger();

    public List<SalesLedger> findAllSalesLedger(String searchText);

    public List<SalesLedger> findAllSalesLedger(int start, int limit);

    public List<SalesLedger> findAllSalesLedgerJsonData();

    public List<SalesLedger> findAllSalesLedgerJsonData(int start, int limit);

    public SalesLedger getSalesLedger(Integer id);

    public SalesLedger getSalesLedger(String name);

    //ItemOutLog .............
    public boolean save(ItemOutLog log);

    public boolean update(ItemOutLog log);

    public boolean delete(ItemOutLog log);

    public List<ItemOutLog> findAllItemOutLog();

    public ItemOutLog getItemOutLog(Integer id);

    public ItemOutLog getItemOutLog(String name);

    //Source .............
    public boolean save(Source source);

    public boolean update(Source source);

    public boolean delete(Source source);

    public List<Source> findAllSource();

    public Source getSource(Integer id);

    public Source getSource(String name);

    //StockLedger .............
    public boolean saveStockLedger(
             Integer sourceId,
             String refNo,
             String vendorName,
             Integer storeId,
             String itemArr,
             String qtyArr,
             String ppArr,
             String lpArr,
             String orderDate,
             Long propId
    );

    public boolean save(StockLedger ledger);

    public boolean update(StockLedger ledger);

    public boolean delete(StockLedger ledger);

    public List<StockLedger> findAllStockLedger();

    public StockLedger getStockLedger(Integer id);

    public StockLedger getStockLedger(String name);

    //ItemInLog .............
    public boolean save(ItemInLog log);

    public boolean update(ItemInLog log);

    public boolean delete(ItemInLog log);

    public List<ItemInLog> findAllItemInLog();

    public ItemInLog getItemInLog(Integer id);

    public ItemInLog getItemInLog(String name);
}
