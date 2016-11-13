package bd.com.softengine.shop.service;


import bd.com.softengine.DAOFactory;
import bd.com.softengine.account.model.*;
import bd.com.softengine.admin.model.Customer;
import bd.com.softengine.admin.model.Staff;
import bd.com.softengine.security.SessionUtil;
import bd.com.softengine.security.model.User;
import bd.com.softengine.shop.model.*;
import bd.com.softengine.util.DateUtil;
import bd.com.softengine.util.ShopDictionary;
import bd.com.softengine.util.SoftUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

@Service
@Transactional/*(propagation = Propagation.REQUIRED, readOnly = false)*/
public class ShopServiceImpl extends DAOFactory implements ShopService {

    public static void main(String[] args) {
       /* try {
            SessionFactory sf = new Configuration().configure().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();


            CashAccount catList = (CashAccount) sf.openSession().createCriteria(CashAccount.class).list().get(0);
            //System.out.println("catList.size() = " + catList.size());

            //session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        /*Session session1 =  manager.getSessionFactory().openSession();
        Session session2 =  manager.getSessionFactory().getCurrentSession();
        Session session3 = sessionFactoryBean.getConfiguration().configure().buildSessionFactory().openSession();
        try {
            Statement session4 = sessionFactoryBean.getDataSource().getConnection().createStatement();
        } catch (SQLException s) {
            s.printStackTrace();
        }*/

    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public boolean save(Store store) {
        return storeDAO.save(store);
    }

    @Override
    public boolean update(Store store) {
        return storeDAO.update(store);
    }

    @Override
    public boolean delete(Store store) {
        return storeDAO.delete(store);
    }

    @Override
    public List<Store> findAllStore() {
        return storeDAO.findAllStore();
    }

    @Override
    public List<Store> findAllStoreComboData() {
        List<Object[]> dataList = storeDAO.findAllStoreComboData();
        List<Store> storeLists = new ArrayList<Store>();
        Store store;
        for (Object[] objects : dataList) {
            store = new Store();
            store.setId((Integer) objects[0]);
            store.setName((String) objects[1]);
            storeLists.add(store);
        }
        return storeLists;
    }

    @Override
    public Store getStore(Integer id) {
        return storeDAO.getStore(id);
    }

    @Override
    public Store getStore(String name) {
        return storeDAO.getStore(name);
    }

    @Override
    public boolean save(Category category) {
        return categoryDAO.save(category);
    }

    @Override
    public boolean update(Category category) {
        return categoryDAO.update(category);
    }

    @Override
    public boolean delete(Category category) {
        return categoryDAO.delete(category);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryDAO.findAllCategory();
    }

    @Override
    public Category getCategory(Integer id) {
        return categoryDAO.getCategory(id);
    }

    @Override
    public Category getCategory(String name) {
        return categoryDAO.getCategory(name);
    }

    @Override
    public boolean save(MeasurementUnit unit) {
        return unitDAO.save(unit);
    }

    @Override
    public boolean update(MeasurementUnit unit) {
        return unitDAO.update(unit);
    }

    @Override
    public boolean delete(MeasurementUnit unit) {
        return unitDAO.delete(unit);
    }

    @Override
    public List<MeasurementUnit> findAllMeasurementUnit() {
        return unitDAO.findAllMeasurementUnit();
    }

    @Override
    public MeasurementUnit getMeasurementUnit(Integer id) {
        return unitDAO.getMeasurementUnit(id);
    }

    @Override
    public MeasurementUnit getMeasurementUnit(String name) {
        return unitDAO.getMeasurementUnit(name);
    }

    /**
     * Item
     */
    @Override
    public boolean save(Item item) {
        return itemDAO.save(item);
    }

    @Override
    public boolean update(Item item) {
        return itemDAO.update(item);
    }

    @Override
    public boolean updateItem(
            Integer id,
            String code,
            String name,
            Double newPrice,
            Double newStock,
            Staff operator
    ) {

        Item item = itemDAO.getItem(id);
        Double oldPrice = item.getLabeledPrice();
        Double oldStock = item.getStock();

        item.setItemCode(code);
        item.setName(name);
        item.setLabeledPrice(newPrice);
        item.setStock(newStock);
        boolean updated = itemDAO.update(item);

        Double profitLossAmt = (newStock * newPrice) - (oldStock * oldPrice);

        if (updated && (!oldPrice.equals(profitLossAmt))) {
            ProfitLossLedger plLedger = new ProfitLossLedger();
            plLedger.setAmt(profitLossAmt);
            plLedger.setNote("Price/Stock Rescheduled");
            plLedger.setDate(new Date());
            plLedger.setOperator(operator);
            plLedger.setField(1);
            boolean saved = profitLossLedgerDAO.save(plLedger);
            if (saved) {
                ProfitLossLog log = new ProfitLossLog();
                log.setLedger(plLedger);
                log.setProfitAmt(profitLossAmt);
                log.setItem(item);
                log.setOldStock(oldStock);
                log.setNewStock(newStock);
                log.setOldPrice(oldPrice);
                log.setNewPrice(newPrice);
                return profitLossLogDAO.save(log);
            }
        }
        return false;
    }

    @Override
    public boolean delete(Item item) {
        return itemDAO.delete(item);
    }

    @Override
    public List<Item> findAllItem() {
        return itemDAO.findAllItem();
    }

    @Override
    public List<Object[]> findAllItemWithDetails() {
        return itemDAO.findAllItemWithDetails();
    }

    @Override
    public List<Item> findAllItem(Double stock, boolean less) {
        return itemDAO.findAllItem(stock, less);
    }

    @Override
    public Item getItem(Integer id) {
        return itemDAO.getItem(id);
    }

    @Override
    public Item getItem(String name) {
        return itemDAO.getItem(name);
    }


    /**
     * Sales Ledger
     */
    @Override
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
            Double paidNet
    ) {
        try {
            Customer customer = customerDAO.getCustomer(customerId);
            SalesLedger ledger = new SalesLedger();
            String orderNo = SoftUtil.generateId_12();
            ledger.setOrderNo(orderNo);
            ledger.setDate(new Date());
            ledger.setTotalAmount(0.0);
            ledger.setCustomer(null);
            ledger.setDate(new Date());
            ledger.setSource(null);
            if (customer != null) {
                ledger.setCustomer(customer);
                ledger.setCustomerName(customer.getName());
            } else {
                ledger.setCustomerName(customerName);
            }


            ledger.setSalesMan(operator);
            // operator.getSalesLedgerList().add(ledger);

            Source source = getSource(sourceName);
            ledger.setSource(source);
            // source.getSalesLedgerList().add(ledger);

            Store store = getStore(storeId);
            ledger.setStore(store);
            // store.getSalesLedgerList().add(ledger);
            ledger.setStatus(ShopDictionary.CHECKED);
            try {
                salesLedgerDAO.save(ledger);
            } catch (Exception exception) {
                return false;
            }

            ProfitLossLedger plLedger = new ProfitLossLedger();
            plLedger.setAmt(0.0);
            plLedger.setNote("Auto calculated sales profit");
            plLedger.setDate(new Date());
            plLedger.setOperator(operator);
            plLedger.setField(0);
            try {
                profitLossLedgerDAO.save(plLedger);
            } catch (Exception e) {
                salesLedgerDAO.delete(ledger);
                return false;
            }

            Integer ledgerId = ledger.getId();

            String[] itemArray = itemArr.split(",");
            String[] qtyArray = qtyArr.split(",");
            String[] priceArray = priceArr.split(",");
            String[] discountArray = discountArr.split(",");
            String[] totPriceArray = totPriceArr.split(",");

            ItemOutLog outLog;
            int itemCounter = 0;
            Double itemPriceTotal = 0.0;
            Double itemProfitTotal = 0.0;

            Double itemDiscountTotal = 0.0;
            for (String itemId : itemArray) {
                Item item = getItem(Integer.valueOf(itemId));
                outLog = new ItemOutLog();
                Double labeledPrice;
                Double itemDiscountPrice;
                Double qty;
                try {
                    qty = Double.valueOf(qtyArray[itemCounter]);
                    labeledPrice = Double.valueOf(priceArray[itemCounter]);
                    itemDiscountPrice = Double.valueOf(discountArray[itemCounter]);
                } catch (Exception e) {
                    qty = 0.0;
                    labeledPrice = 0.0;
                    itemDiscountPrice = 0.0;
                }

                Double salesPrice = labeledPrice - itemDiscountPrice;
                Double salesProfit = salesPrice - item.getPurchasedPrice();
                outLog.setQty(qty);
                outLog.setLabeledPrice(labeledPrice);
                outLog.setSalesPrice(salesPrice);
                outLog.setDiscount(itemDiscountPrice);
                Double itemPrice = qty * salesPrice;
                Double itemProfit = qty * salesProfit;
                if (itemPrice > 0) {
                    item.setStock(item.getStock() - qty);
                    update(item);
                    outLog.setItem(item);
                    //item.getOutLogList().add(outLog);
                    outLog.setSalesLedger(ledger);
                    outLog.setPurchasedPrice(item.getPurchasedPrice());
                    //ledger.getOutLogList().add(outLog);
                    itemOutLogDAO.save(outLog);
                }


                ProfitLossLog profitLossLog = new ProfitLossLog();
                profitLossLog.setPurchasedPrice(item.getPurchasedPrice());
                profitLossLog.setLabeledPrice(item.getLabeledPrice());
                profitLossLog.setSalesPrice(salesPrice);
                profitLossLog.setDiscountAmt(itemDiscountPrice);
                profitLossLog.setItem(item);
                profitLossLog.setQty(qty);
                profitLossLog.setLedger(plLedger);
                profitLossLogDAO.save(profitLossLog);

                itemPriceTotal += itemPrice;
                itemProfitTotal += itemProfit;
                itemDiscountTotal += itemDiscountPrice;
                itemCounter++;
            }

            Double itemPriceNet = itemPriceTotal - roundDiscount;
            SalesLedger salesLedger = getSalesLedger(ledgerId);

            if (itemPriceNet <= 0) {
                salesLedgerDAO.delete(salesLedger);
            } else {
                Double itemDiscountNet = itemDiscountTotal + roundDiscount;
                Double itemProfitNet = itemProfitTotal - roundDiscount;
                Double dueNet = itemPriceNet - paidNet;
                salesLedger.setTotalAmount(itemPriceNet);
                salesLedger.setRoundDiscount(roundDiscount);
                salesLedger.setTotalDiscount(itemDiscountNet);
                salesLedger.setDueTotal(dueNet);
                salesLedger.setPaidTotal(paidNet);
                salesLedgerDAO.update(salesLedger);

                plLedger.setAmt(itemProfitNet);
                profitLossLedgerDAO.update(plLedger);

                if (paidNet > 0) {
                    CashAccount staffAccount = operator.getCashAccount();
                    SalesVoucher sVoucher = new SalesVoucher();
                    sVoucher.setSalesLedger(salesLedger);
                    sVoucher.setAmount(paidNet);
                    sVoucher.setDate(new Date());
                    sVoucher.setCrAc(staffAccount);
                    sVoucher.setSalesMan(operator);
                    sVoucher.setOperator(operator);
                    sVoucher.setInstrumentNo(orderNo);
                    sVoucher.setDrAc(null);
                    sVoucher.setNote("Sales..");
                    sVoucher.setStatus(1);
                    salesVoucherDAO.save(sVoucher);
                }

                if (customer != null && dueNet > 0) {
                    CashAccount custAc = customer.getCashAccount(); // TODO... custAc = null
                    DrCrVoucher drVoucher = new DrCrVoucher();
                    drVoucher.setSalesLedger(salesLedger);
                    drVoucher.setCustomer(customer);
                    drVoucher.setCustomerName(customer.getName());
                    drVoucher.setAmount(dueNet);
                    drVoucher.setDate(new Date());
                    drVoucher.setCrAc(custAc);
                    drVoucher.setInstrumentNo(orderNo);
                    drVoucher.setDrAc(null);
                    drVoucher.setNote("Sales Due");
                    drVoucher.setStatus(1);
                    drVoucher.setOperator(operator);
                    // System.out.println(45/0) // TODO
                    drCrVoucherDAO.save(drVoucher);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean save(SalesLedger ledger) {
        return salesLedgerDAO.save(ledger);
    }

    @Override
    public boolean update(SalesLedger ledger) {
        return salesLedgerDAO.update(ledger);
    }

    @Override
    public boolean delete(SalesLedger ledger) {
        return salesLedgerDAO.delete(ledger);
    }

    @Override
    public List<SalesLedger> findAllSalesLedger() {
        return salesLedgerDAO.findAllSalesLedger();
    }

    @Override
    public List<SalesLedger> findAllSalesLedger(String searchText) {
        return salesLedgerDAO.findAllSalesLedger(searchText);
    }

    @Override
    public List<SalesLedger> findAllSalesLedger(int start, int limit) {
        return salesLedgerDAO.findAllSalesLedger(start, limit);
    }

    @Override
    public List<SalesLedger> findAllSalesLedgerJsonData() {
        List<SalesLedger> storeLists = new ArrayList<SalesLedger>();
        for (SalesLedger ledger : findAllSalesLedger()) {
            storeLists.add(ledger.toJsonBean());
        }
        return storeLists;
    }

    @Override
    public List<SalesLedger> findAllSalesLedgerJsonData(int start, int limit) {
        List<SalesLedger> storeLists = new ArrayList<SalesLedger>();
        for (SalesLedger ledger : findAllSalesLedger(start, limit)) {
            storeLists.add(ledger.toJsonBean());
        }
        return storeLists;
    }

    @Override
    public SalesLedger getSalesLedger(Integer id) {
        return salesLedgerDAO.getSalesLedger(id);
    }

    @Override
    public SalesLedger getSalesLedger(String name) {
        return salesLedgerDAO.getSalesLedger(name);
    }


    /**
     * Item Out Log
     */
    @Override
    public boolean save(ItemOutLog log) {
        return itemOutLogDAO.save(log);
    }

    @Override
    public boolean update(ItemOutLog log) {
        return itemOutLogDAO.update(log);
    }

    @Override
    public boolean delete(ItemOutLog log) {
        return itemOutLogDAO.delete(log);
    }

    @Override
    public List<ItemOutLog> findAllItemOutLog() {
        return itemOutLogDAO.findAllItemOutLog();
    }

    @Override
    public ItemOutLog getItemOutLog(Integer id) {
        return itemOutLogDAO.getItemOutLog(id);
    }

    @Override
    public ItemOutLog getItemOutLog(String name) {
        return itemOutLogDAO.getItemOutLog(name);
    }

    @Override
    public boolean save(Source source) {
        return sourceDAO.save(source);
    }

    @Override
    public boolean update(Source source) {
        return sourceDAO.update(source);
    }

    @Override
    public boolean delete(Source source) {
        return sourceDAO.delete(source);
    }

    @Override
    public List<Source> findAllSource() {
        return sourceDAO.findAllSource();
    }

    @Override
    public Source getSource(Integer id) {
        return sourceDAO.getSource(id);
    }

    @Override
    public Source getSource(String name) {
        return sourceDAO.getSource(name);
    }


    // Stock Ledger

    @Override
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
    ) {
        try {
            Date date = DateUtil.toDate(orderDate, "DD/MM/YYYY");
            StockLedger ledger = new StockLedger();
            ledger.setRefNo(refNo);
            ledger.setVendorName(vendorName);
            ledger.setTotalAmount(0.0);
            ledger.setOrderDate(date);

            Staff operator;
            CashAccount staffAccount;
            User sessionUser = SessionUtil.getSessionUser();
            if (sessionUser instanceof Staff) {
                operator = staffDAO.getStaff(sessionUser.getId());
                staffAccount = operator.getCashAccount();
                if (staffAccount == null) return false;
            } else {
                // TODO... if not a staff return message
                return false;
            }
            ledger.setDataOperator(operator);
            //operator.getStockLedgerList().add(ledger);

            Source source = this.getSource(sourceId);
            ledger.setSource(source);
            //source.getStockLedgerList().add(ledger);

            Store store = this.getStore(storeId);
            ledger.setStore(store);
            //store.getStockLedgerList().add(ledger);
            ledger.setStatus(ShopDictionary.CHECKED);
            try {
                stockLedgerDAO.save(ledger);
            } catch (Exception exception) {
                return false;
            }

            ProfitLossLedger plLedger = new ProfitLossLedger();
            plLedger.setAmt(0.0);
            plLedger.setNote("Stocking Profit/Loss");
            plLedger.setDate(new Date());
            plLedger.setOperator(operator);
            plLedger.setField(2);
            profitLossLedgerDAO.save(plLedger);

            Integer ledgerId = ledger.getId();

            String[] itemArray = itemArr.split(",");
            String[] qtyArray = qtyArr.split(",");
            String[] ppArray = ppArr.split(",");
            String[] lpArray = lpArr.split(",");

            ItemInLog inLog;
            int itemCounter = 0;
            Double netTotal = 0.0;
            Double netProfitLossAmt = 0.0;
            for (String itemId : itemArray) {
                inLog = new ItemInLog();
                Double purchasedPrice;
                Double newPrice;
                Double qty;
                try {
                    qty = Double.valueOf(qtyArray[itemCounter]);
                    purchasedPrice = Double.valueOf(ppArray[itemCounter]);
                    newPrice = Double.valueOf(lpArray[itemCounter]);
                } catch (Exception e) {
                    qty = 0.0;
                    purchasedPrice = 0.0;
                    newPrice = 0.0;
                }

                //Double salesPrice = purchasedPrice - newPrice;
                inLog.setQty(qty);
                inLog.setUnitPrice(purchasedPrice);
                Double netPrice = qty * purchasedPrice;
                if (netPrice > 0) {
                    Item item = this.getItem(Integer.valueOf(itemId));
                    Double oldStock = item.getStock();
                    Double oldPrice = item.getLabeledPrice();
                    Double newStock = oldStock + qty;
                    item.setStock(newStock);
                    item.setPurchasedPrice(purchasedPrice);
                    item.setLabeledPrice(newPrice);
                    itemDAO.update(item);
                    inLog.setItem(item);
                    //item.getInLogList().add(inLog);
                    inLog.setStockLedger(ledger);
                    //ledger.getInLogList().add(inLog);
                    itemInLogDAO.save(inLog);

                    Double profitLossAmt = (newStock * newPrice) - (oldStock * oldPrice);

                    ProfitLossLog log = new ProfitLossLog();
                    log.setLedger(plLedger);
                    log.setProfitAmt(profitLossAmt);
                    log.setItem(item);
                    log.setOldStock(oldStock);
                    log.setNewStock(newStock);
                    log.setOldPrice(oldPrice);
                    log.setNewPrice(newPrice);
                    profitLossLogDAO.save(log);
                    netProfitLossAmt += profitLossAmt;
                }

                netTotal += netPrice;
                itemCounter++;


            }

            StockLedger stockLedger = this.getStockLedger(ledgerId);
            if (netTotal <= 0) {
                stockLedgerDAO.delete(stockLedger);
            } else {
                stockLedger.setTotalAmount(netTotal);
                this.update(stockLedger);

                Staff proprietor = staffDAO.getStaff(propId);
                CashAccount proprietorAccount = proprietor.getCashAccount();
                StockVoucher sVoucher = new StockVoucher();
                sVoucher.setStockLedger(stockLedger);
                sVoucher.setAmount(netTotal);
                sVoucher.setDate(new Date());
                sVoucher.setCrAc(proprietorAccount);
                sVoucher.setProprietor(proprietor);
                sVoucher.setOperator(operator);
                sVoucher.setInstrumentNo(refNo);
                sVoucher.setDrAc(null);
                sVoucher.setNote("Stocking CR");
                sVoucher.setStatus(1);
                stockVoucherDAO.save(sVoucher);
            }
            plLedger.setAmt(netProfitLossAmt);
            profitLossLedgerDAO.update(plLedger);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean save(StockLedger ledger) {
        return stockLedgerDAO.save(ledger);
    }

    @Override
    public boolean update(StockLedger ledger) {
        return stockLedgerDAO.update(ledger);
    }

    @Override
    public boolean delete(StockLedger ledger) {
        return stockLedgerDAO.delete(ledger);
    }

    @Override
    public List<StockLedger> findAllStockLedger() {
        return stockLedgerDAO.findAllStockLedger();
    }

    @Override
    public StockLedger getStockLedger(Integer id) {
        return stockLedgerDAO.getStockLedger(id);
    }

    @Override
    public StockLedger getStockLedger(String name) {
        return stockLedgerDAO.getStockLedger(name);
    }

    @Override
    public boolean save(ItemInLog log) {
        return itemInLogDAO.save(log);
    }

    @Override
    public boolean update(ItemInLog log) {
        return itemInLogDAO.update(log);
    }

    @Override
    public boolean delete(ItemInLog log) {
        return itemInLogDAO.delete(log);
    }

    @Override
    public List<ItemInLog> findAllItemInLog() {
        return itemInLogDAO.findAllItemInLog();
    }

    @Override
    public ItemInLog getItemInLog(Integer id) {
        return itemInLogDAO.getItemInLog(id);
    }

    @Override
    public ItemInLog getItemInLog(String name) {
        return itemInLogDAO.getItemInLog(name);
    }
}
