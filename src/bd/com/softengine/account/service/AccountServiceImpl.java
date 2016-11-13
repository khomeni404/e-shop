package bd.com.softengine.account.service;

import bd.com.softengine.DAOFactory;
import bd.com.softengine.account.model.*;
import bd.com.softengine.admin.model.Customer;
import bd.com.softengine.admin.model.Staff;
import bd.com.softengine.util.SoftUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 29/05/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 29/05/16
 * Version : 1.0
 */
@Service
@Transactional
public class AccountServiceImpl extends DAOFactory implements AccountService {

    // CashAccount
    @Override
    public boolean save(CashAccount account) {
        return cashAccountDAO.save(account);
    }

    @Override
    public boolean update(CashAccount account) {
        return cashAccountDAO.update(account);
    }

    @Override
    public boolean delete(CashAccount account) {
        return cashAccountDAO.delete(account);
    }

    @Override
    public List<CashAccount> findAllCashAccount() {
        return cashAccountDAO.findAllCashAccount();
    }

    @Override
    public CashAccount getCashAccount(Long id) {
        return cashAccountDAO.getCashAccount(id);
    }


    // Account
    @Override
    public boolean save(Account account) {
        return accountDAO.save(account);
    }

    @Override
    public boolean update(Account account) {
        return accountDAO.update(account);
    }

    @Override
    public boolean delete(Account account) {
        return accountDAO.delete(account);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDAO.findAllAccount();
    }

    @Override
    public Account getAccount(Long id) {
        return accountDAO.getAccount(id);
    }


    // BankAccount
    @Override
    public boolean save(BankAccount account) {
        return bankAccountDAO.save(account);
    }

    @Override
    public boolean update(BankAccount account) {
        return bankAccountDAO.update(account);
    }

    @Override
    public boolean delete(BankAccount account) {
        return bankAccountDAO.delete(account);
    }

    @Override
    public List<BankAccount> findAllBankAccount() {
        return bankAccountDAO.findAllBankAccount();
    }

    @Override
    public BankAccount getBankAccount(Long id) {
        return bankAccountDAO.getBankAccount(id);
    }


    // Bill
    @Override
    public boolean save(Bill bill) {
        return billDAO.save(bill);
    }

    @Override
    public boolean update(Bill bill) {
        return billDAO.update(bill);
    }

    @Override
    public boolean delete(Bill bill) {
        return billDAO.delete(bill);
    }

    @Override
    public List<Bill> findAllBill() {
        return billDAO.findAllBill();
    }

    @Override
    public Bill getBill(Long id) {
        return billDAO.getBill(id);
    }


    // BillHead
    @Override
    public boolean save(BillHead head) {
        return billHeadDAO.save(head);
    }

    @Override
    public boolean update(BillHead head) {
        return billHeadDAO.update(head);
    }

    @Override
    public boolean delete(BillHead head) {
        return billHeadDAO.delete(head);
    }

    @Override
    public List<BillHead> findAllBillHead() {
        return billHeadDAO.findAllBillHead();
    }

    @Override
    public BillHead getBillHead(Long id) {
        return billHeadDAO.getBillHead(id);
    }


    // BillItem
    @Override
    public boolean save(BillItem item) {
        return billItemDAO.save(item);
    }

    @Override
    public boolean update(BillItem item) {
        return billItemDAO.update(item);
    }

    @Override
    public boolean delete(BillItem item) {
        return billItemDAO.delete(item);
    }

    @Override
    public List<BillItem> findAllBillItem() {
        return billItemDAO.findAllBillItem();
    }

    @Override
    public BillItem getBillItem(Long id) {
        return billItemDAO.getBillItem(id);
    }


    // DrCrVoucher
    @Override
    public boolean save(DrCrVoucher vr) {
        return drCrVoucherDAO.save(vr);
    }

    @Override
    public boolean update(DrCrVoucher vr) {
        return drCrVoucherDAO.update(vr);
    }

    @Override
    public boolean delete(DrCrVoucher vr) {
        return drCrVoucherDAO.delete(vr);
    }

    @Override
    public List<DrCrVoucher> findAllDrCrVoucher() {
        return drCrVoucherDAO.findAllDrCrVoucher();
    }

    @Override
    public DrCrVoucher getDrCrVoucher(Long id) {
        return drCrVoucherDAO.getDrCrVoucher(id);
    }

    @Override
    public boolean depositCrVoucher(Customer depositor, CashAccount drAc, Staff receiver, CashAccount crAc, Double amount, String note, String orderNo) {
        try {
            String instrumentNo = SoftUtil.generateId_12();
            DrCrVoucher vr = new DrCrVoucher();
            vr.setInstrumentNo(instrumentNo);
            vr.setDate(new Date());
            vr.setAmount(amount);
            vr.setCustomer(depositor);
            vr.setCustomerName(depositor.getName());
            vr.setDrAc(drAc);
            vr.setOperator(receiver);
            vr.setCrAc(crAc);
            vr.setStatus(1);
            vr.setNote(note.equals("") ? "Due Liquidation" : note);
            return drCrVoucherDAO.save(vr);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // GLHead
    @Override
    public boolean save(GLHead head) {
        return glHeadDAO.save(head);
    }

    @Override
    public boolean update(GLHead head) {
        return glHeadDAO.update(head);
    }

    @Override
    public boolean delete(GLHead head) {
        return glHeadDAO.delete(head);
    }

    @Override
    public List<GLHead> findAllGLHead() {
        return glHeadDAO.findAllGLHead();
    }

    @Override
    public GLHead getGLHead(Long id) {
        return glHeadDAO.getGLHead(id);
    }


    // JournalVoucher
    @Override
    public boolean save(JournalVoucher vr) {
        return journalVoucherDAO.save(vr);
    }

    @Override
    public boolean update(JournalVoucher vr) {
        return journalVoucherDAO.update(vr);
    }

    @Override
    public boolean delete(JournalVoucher vr) {
        return journalVoucherDAO.delete(vr);
    }

    @Override
    public List<JournalVoucher> findAllJournalVoucher() {
        return journalVoucherDAO.findAllJournalVoucher();
    }

    @Override
    public List<JournalVoucher> findAllJournalVoucher(Integer status) {
        return journalVoucherDAO.findAllJournalVoucher(status);
    }

    @Override
    public List<JournalVoucher> findAllJournalVoucher(Integer status, Staff staff) {
        return journalVoucherDAO.findAllJournalVoucher(status, staff);
    }

    @Override
    public JournalVoucher getJournalVoucher(Integer id) {
        return journalVoucherDAO.getJournalVoucher(id);
    }

    @Override
    public boolean createJournalVoucher(
            Staff sender, CashAccount drAc,
            Staff receiver, CashAccount crAc,
            Double amount, String note) {
        try {
            String instrumentNo = SoftUtil.generateId_12();
            JournalVoucher vr = new JournalVoucher();
            vr.setInstrumentNo(instrumentNo);
            vr.setDate(new Date());
            vr.setAmount(amount);
            vr.setSender(sender);
            vr.setDrAc(drAc);
            vr.setReceiver(receiver);
            vr.setCrAc(crAc);
            vr.setStatus(0);
            vr.setOperator(sender);
            vr.setNote(note);
            return journalVoucherDAO.save(vr);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // ProfitLossLedger
    @Override
    public boolean save(ProfitLossLedger ledger) {
        return profitLossLedgerDAO.save(ledger);
    }

    @Override
    public boolean update(ProfitLossLedger ledger) {
        return profitLossLedgerDAO.update(ledger);
    }

    @Override
    public boolean delete(ProfitLossLedger ledger) {
        return profitLossLedgerDAO.delete(ledger);
    }

    @Override
    public List<ProfitLossLedger> findAllProfitLossLedger() {
        return profitLossLedgerDAO.findAllProfitLossLedger();
    }

    @Override
    public ProfitLossLedger getProfitLossLedger(Integer id) {
        return profitLossLedgerDAO.getProfitLossLedger(id);
    }


    // ProfitLossLog
    @Override
    public boolean save(ProfitLossLog log) {
        return profitLossLogDAO.save(log);
    }

    @Override
    public boolean update(ProfitLossLog log) {
        return profitLossLogDAO.update(log);
    }

    @Override
    public boolean delete(ProfitLossLog log) {
        return profitLossLogDAO.delete(log);
    }

    @Override
    public List<ProfitLossLog> findAllProfitLossLog() {
        return profitLossLogDAO.findAllProfitLossLog();
    }

    @Override
    public ProfitLossLog getProfitLossLog(Long id) {
        return profitLossLogDAO.getProfitLossLog(id);
    }


    // ReturnVoucher
    @Override
    public boolean save(ReturnVoucher vr) {
        return returnVoucherDAO.save(vr);
    }

    @Override
    public boolean update(ReturnVoucher vr) {
        return returnVoucherDAO.update(vr);
    }

    @Override
    public boolean delete(ReturnVoucher vr) {
        return returnVoucherDAO.delete(vr);
    }

    @Override
    public List<ReturnVoucher> findAllReturnVoucher() {
        return returnVoucherDAO.findAllReturnVoucher();
    }

    @Override
    public ReturnVoucher getReturnVoucher(Long id) {
        return returnVoucherDAO.getReturnVoucher(id);
    }


    // SalesVoucher
    @Override
    public boolean save(SalesVoucher vr) {
        return salesVoucherDAO.save(vr);
    }

    @Override
    public boolean update(SalesVoucher vr) {
        return salesVoucherDAO.update(vr);
    }

    @Override
    public boolean delete(SalesVoucher vr) {
        return salesVoucherDAO.delete(vr);
    }

    @Override
    public List<SalesVoucher> findAllSalesVoucher() {
        return salesVoucherDAO.findAllSalesVoucher();
    }

    @Override
    public SalesVoucher getSalesVoucher(Long id) {
        return salesVoucherDAO.getSalesVoucher(id);
    }


    // Transaction
    @Override
    public boolean save(Transaction tr) {
        return transactionDAO.save(tr);
    }

    @Override
    public boolean update(Transaction tr) {
        return transactionDAO.update(tr);
    }

    @Override
    public boolean delete(Transaction tr) {
        return transactionDAO.delete(tr);
    }

    @Override
    public List<Transaction> findAllTransaction() {
        return transactionDAO.findAllTransaction();
    }

    @Override
    public Transaction getTransaction(Long id) {
        return transactionDAO.getTransaction(id);
    }


    // TransactionHead
    @Override
    public boolean save(TransactionHead heah) {
        return transactionHeadDAO.save(heah);
    }

    @Override
    public boolean update(TransactionHead heah) {
        return transactionHeadDAO.update(heah);
    }

    @Override
    public boolean delete(TransactionHead heah) {
        return transactionHeadDAO.delete(heah);
    }

    @Override
    public List<TransactionHead> findAllTransactionHead() {
        return transactionHeadDAO.findAllTransactionHead();
    }

    @Override
    public TransactionHead getTransactionHead(Long id) {
        return transactionHeadDAO.getTransactionHead(id);
    }


    // Voucher
    @Override
    public boolean save(Voucher voucher) {
        return voucherDAO.save(voucher);
    }

    @Override
    public boolean update(Voucher voucher) {
        return voucherDAO.update(voucher);
    }

    @Override
    public boolean delete(Voucher voucher) {
        return voucherDAO.delete(voucher);
    }

    @Override
    public List<Voucher> findAllVoucher() {
        return voucherDAO.findAllVoucher();
    }

    @Override
    public Voucher getVoucher(Long id) {
        return voucherDAO.getVoucher(id);
    }

}
