package bd.com.softengine.account.service;

import bd.com.softengine.account.model.*;
import bd.com.softengine.admin.model.Customer;
import bd.com.softengine.admin.model.Staff;

import java.util.List;

public interface AccountService {
    // Account .............
    public boolean save(Account account);

    public boolean update(Account account);

    public boolean delete(Account account);

    public List<Account> findAllAccount();

    public Account getAccount(Long id);

    // CashAccount .............
    public boolean save(CashAccount account);

    public boolean update(CashAccount account);

    public boolean delete(CashAccount account);

    public List<CashAccount> findAllCashAccount();

    public CashAccount getCashAccount(Long id);

    // BankAccount .............
    public boolean save(BankAccount account);

    public boolean update(BankAccount account);

    public boolean delete(BankAccount account);

    public List<BankAccount> findAllBankAccount();

    public BankAccount getBankAccount(Long id);

    
    

    // Bill .............
    public boolean save(Bill account);

    public boolean update(Bill account);

    public boolean delete(Bill account);

    public List<Bill> findAllBill();

    public Bill getBill(Long id);


    // BillHead .............
    public boolean save(BillHead account);

    public boolean update(BillHead account);

    public boolean delete(BillHead account);

    public List<BillHead> findAllBillHead();

    public BillHead getBillHead(Long id);



    // BillItem .............
    public boolean save(BillItem account);

    public boolean update(BillItem account);

    public boolean delete(BillItem account);

    public List<BillItem> findAllBillItem();

    public BillItem getBillItem(Long id);


    // Voucher .............
    public boolean save(Voucher account);

    public boolean update(Voucher account);

    public boolean delete(Voucher account);

    public List<Voucher> findAllVoucher();

    public Voucher getVoucher(Long id);


    // DrCrVoucher .............
    public boolean save(DrCrVoucher account);

    public boolean update(DrCrVoucher account);

    public boolean delete(DrCrVoucher account);

    public List<DrCrVoucher> findAllDrCrVoucher();

    public DrCrVoucher getDrCrVoucher(Long id);

    public boolean depositCrVoucher(
            Customer depositor, CashAccount drAc,
            Staff receiver, CashAccount crAc,
            Double amount, String note, String orderNo
    );



    // GLHead .............
    public boolean save(GLHead account);

    public boolean update(GLHead account);

    public boolean delete(GLHead account);

    public List<GLHead> findAllGLHead();

    public GLHead getGLHead(Long id);



    // JournalVoucher .............
    public boolean save(JournalVoucher account);

    public boolean update(JournalVoucher account);

    public boolean delete(JournalVoucher account);

    public List<JournalVoucher> findAllJournalVoucher();

    public List<JournalVoucher> findAllJournalVoucher(Integer status);

    public List<JournalVoucher> findAllJournalVoucher(Integer status, Staff staff);

    public JournalVoucher getJournalVoucher(Integer id);

    public boolean createJournalVoucher(
           Staff sender, CashAccount drAc,
           Staff receiver,CashAccount crAc,
           Double amount, String note
    );


    // ProfitLossLedger .............
    public boolean save(ProfitLossLedger account);

    public boolean update(ProfitLossLedger account);

    public boolean delete(ProfitLossLedger account);

    public List<ProfitLossLedger> findAllProfitLossLedger();

    public ProfitLossLedger getProfitLossLedger(Integer id);


    // ProfitLossLog .............
    public boolean save(ProfitLossLog account);

    public boolean update(ProfitLossLog account);

    public boolean delete(ProfitLossLog account);

    public List<ProfitLossLog> findAllProfitLossLog();

    public ProfitLossLog getProfitLossLog(Long id);



    // ReturnVoucher .............
    public boolean save(ReturnVoucher account);

    public boolean update(ReturnVoucher account);

    public boolean delete(ReturnVoucher account);

    public List<ReturnVoucher> findAllReturnVoucher();

    public ReturnVoucher getReturnVoucher(Long id);


    // SalesVoucher .............
    public boolean save(SalesVoucher account);

    public boolean update(SalesVoucher account);

    public boolean delete(SalesVoucher account);

    public List<SalesVoucher> findAllSalesVoucher();

    public SalesVoucher getSalesVoucher(Long id);


    // Transaction .............
    public boolean save(Transaction account);

    public boolean update(Transaction account);

    public boolean delete(Transaction account);

    public List<Transaction> findAllTransaction();

    public Transaction getTransaction(Long id);


    // TransactionHead .............
    public boolean save(TransactionHead account);

    public boolean update(TransactionHead account);

    public boolean delete(TransactionHead account);

    public List<TransactionHead> findAllTransactionHead();

    public TransactionHead getTransactionHead(Long id);



}
