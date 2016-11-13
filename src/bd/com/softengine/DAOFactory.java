package bd.com.softengine;

import bd.com.softengine.account.dao.*;
import bd.com.softengine.admin.dao.*;
import bd.com.softengine.admin.model.ItemReport;
import bd.com.softengine.shop.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 30/05/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 30/05/16
 * Version : 1.0
 */
@Service
public class DAOFactory {

    // Admin DAO beans
    @Autowired
    public StaffDAO staffDAO;
    @Autowired
    public CustomerDAO customerDAO;
    @Autowired
    public VendorDAO vendorDAO;
    @Autowired
    public ManufacturerDAO manufacturerDAO;
    @Autowired
    public ItemReportDAO itemReportDAO;

    // Store DAO Beans
    @Autowired
    public StoreDAO storeDAO;
    @Autowired
    public CategoryDAO categoryDAO;
    @Autowired
    public ItemDAO itemDAO;
    @Autowired
    public UnitDAO unitDAO;
    @Autowired
    public SalesLedgerDAO salesLedgerDAO;
    @Autowired
    public ItemOutLogDAO itemOutLogDAO;
    @Autowired
    public SourceDAO sourceDAO;
    @Autowired
    public StockLedgerDAO stockLedgerDAO;
    @Autowired
    public ItemInLogDAO itemInLogDAO;
    
    
    // Accounts DAO Beans
    @Autowired
    public AccountDAO accountDAO;
    @Autowired
    public CashAccountDAO cashAccountDAO;
    @Autowired
    public BankAccountDAO bankAccountDAO;
    @Autowired
    public VoucherDAO voucherDAO;
    @Autowired
    public DrCrVoucherDAO drCrVoucherDAO;
    @Autowired
    public JournalVoucherDAO journalVoucherDAO;
    @Autowired
    public ReturnVoucherDAO returnVoucherDAO;
    @Autowired
    public SalesVoucherDAO salesVoucherDAO;
    @Autowired
    public StockVoucherDAO stockVoucherDAO;
    @Autowired
    public TransactionDAO transactionDAO;
    @Autowired
    public GLHeadDAO glHeadDAO;
    @Autowired
    public BillDAO billDAO;
    @Autowired
    public BillItemDAO  billItemDAO;
    @Autowired
    public BillHeadDAO billHeadDAO;
    @Autowired
    public TransactionHeadDAO  transactionHeadDAO;
    @Autowired
    public ProfitLossLedgerDAO profitLossLedgerDAO;
    @Autowired
    public ProfitLossLogDAO profitLossLogDAO;


}
