package bd.com.softengine.account;

import bd.com.softengine.ServiceFactory;
import bd.com.softengine.account.model.CashAccount;
import bd.com.softengine.account.model.JournalVoucher;
import bd.com.softengine.admin.model.Customer;
import bd.com.softengine.admin.model.Staff;
import bd.com.softengine.security.SessionUtil;
import bd.com.softengine.security.model.User;
import bd.com.softengine.util.ShopDictionary;
import bd.com.softengine.util.Text;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 29/05/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 29/05/16
 * Version : 1.0
 */

@Controller
@RequestMapping("/accounts/")
public class AccountController extends ServiceFactory implements Text{

    @RequestMapping(method = RequestMethod.GET, value = "/createJournalVoucher.se")
    public ModelAndView createJournalVoucher(@RequestParam(required = false) String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Create Journal Voucher");
        map.put("msg", msg);
        Staff operator;
        User sessionUser = SessionUtil.getSessionUser();
        if (sessionUser instanceof Staff) {
            operator = adminService.getStaff(sessionUser.getId());
            CashAccount staffAccount = operator.getCashAccount();
            if (staffAccount == null) {
                map.put(ERROR_KEY, "You have no 'Cash Account'");
                return new ModelAndView(REDIRECT_ERROR, map);
            }
        } else {
            map.put(ERROR_KEY, NOT_A_STAFF);
            return new ModelAndView(REDIRECT_ERROR, map);
        }

        map.put("voucherList", accountService.findAllJournalVoucher(0, operator));
        map.put("operator", operator);
        map.put("staffList", adminService.findAllStaff());

        return new ModelAndView("accounts/journal_vr_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveJournalVoucher.se")
    public ModelAndView saveJournalVoucher(@RequestParam Double amount,
                                           @RequestParam Long drAcHolderId,
                                           @RequestParam Long crAcHolderId,
                                           @RequestParam String note) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Save Journal Voucher");

        Staff operator;
        User sessionUser = SessionUtil.getSessionUser();
        if (sessionUser instanceof Staff) {
            operator = adminService.getStaff(sessionUser.getId());
        } else {
            map.put(ERROR_KEY, NOT_A_STAFF);
            return new ModelAndView(REDIRECT_ERROR, map);
        }


        Staff sender = adminService.getStaff(drAcHolderId);
        if (!sender.getId().equals(operator.getId())) {
            map.put(ERROR_KEY, "You can only transfer your balance.");
            return new ModelAndView(REDIRECT_ERROR, map);
        }
        Staff receiver = adminService.getStaff(crAcHolderId);

        CashAccount drAc = sender.getCashAccount();
        CashAccount crAc = receiver.getCashAccount();
        if (drAc == null || crAc == null) {
            map.put(ERROR_KEY, "Both staff must have 'Cash Account'");
            return new ModelAndView(REDIRECT_ERROR, map);
        }

        boolean created = accountService.createJournalVoucher(
                sender, drAc,
                receiver, crAc,
                amount, note
        );


        if (created) {
            String msg = "Created Successfully";
            return new ModelAndView("redirect:/accounts/createJournalVoucher.se?msg"+msg);
        } else {
            map.put(ERROR_KEY, "Create failed !");
            return new ModelAndView(REDIRECT_ERROR, map);
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/createCrVoucher.se")
    public ModelAndView createCrVoucher(@RequestParam(required = false) String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Create Credit Voucher");
        map.put("msg", msg);
        Staff operator;
        User sessionUser = SessionUtil.getSessionUser();
        if (sessionUser instanceof Staff) {
            operator = adminService.getStaff(sessionUser.getId());
            CashAccount staffAccount = operator.getCashAccount();
            if (staffAccount == null) {
                map.put(ERROR_KEY, "You have no 'Cash Account'");
                return new ModelAndView(REDIRECT_ERROR, map);
            }
        } else {
            map.put(ERROR_KEY, NOT_A_STAFF);
            return new ModelAndView(REDIRECT_ERROR, map);
        }


        map.put("salesOrderList", shopService.findAllSalesLedger());
        map.put("operator", operator);
        map.put("customerList", adminService.findAllCustomer());

        return new ModelAndView("accounts/cr_vr_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveCrVoucher.se")
    public ModelAndView saveCrVoucher(@RequestParam Double amount,
                                           @RequestParam Long custId,
                                           @RequestParam Long receiverId,
                                           @RequestParam String orderNo,
                                           @RequestParam String note) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Save Cr Voucher");

        Staff operator;
        User sessionUser = SessionUtil.getSessionUser();
        if (sessionUser instanceof Staff) {
            operator = adminService.getStaff(sessionUser.getId());
        } else {
            map.put(ERROR_KEY, NOT_A_STAFF);
            return new ModelAndView(REDIRECT_ERROR, map);
        }


        Staff receiver = adminService.getStaff(receiverId);
        if (!receiver.getId().equals(operator.getId())) {
            map.put(ERROR_KEY, "Operator and Receiver is not same.");
            return new ModelAndView(REDIRECT_ERROR, map);
        }
        Customer depositor = adminService.getCustomer(custId);

        CashAccount drAc = depositor.getCashAccount();
        CashAccount crAc = receiver.getCashAccount();
        if (drAc == null || crAc == null) {
            map.put(ERROR_KEY, "Both staff & customer must have 'Cash Account'");
            return new ModelAndView(REDIRECT_ERROR, map);
        }

        boolean deposited = accountService.depositCrVoucher(
                depositor, drAc,
                receiver, crAc,
                amount, note, orderNo
        );


        if (deposited) {
            map.put(ERROR_KEY, "Deposited Successfully");
            return new ModelAndView(REDIRECT_SUCCESS, map);
        } else {
            map.put(ERROR_KEY, "Deposit failed !");
            return new ModelAndView(REDIRECT_ERROR, map);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/voucherListAll.se")
    public ModelAndView voucherListAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "voucherListAll");
        map.put("voucherList", accountService.findAllVoucher());

        return new ModelAndView("accounts/voucher_list_all", map);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/journalVrList.se")
    public ModelAndView journalVrList() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "voucherListAll");
        map.put("voucherList", accountService.findAllJournalVoucher());

        return new ModelAndView("accounts/voucher_list_journal", map);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/salesVrList.se")
    public ModelAndView salesVrList() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "voucherListAll");
        map.put("voucherList", accountService.findAllSalesVoucher());

        return new ModelAndView("accounts/voucher_list_sales", map);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/drCrVrList.se")
    public ModelAndView drCrVrList() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "voucherListAll");
        map.put("voucherList", accountService.findAllDrCrVoucher());

        return new ModelAndView("accounts/voucher_list_drcr", map);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/profitLossLedgerList.se")
    public ModelAndView profitLossLedgerList() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "profitLossLedgerList");
        map.put("profitLossLedgerList", accountService.findAllProfitLossLedger());

        return new ModelAndView("accounts/profit_loss_ledger_list", map);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/viewProfitLossLedger.se")
    public ModelAndView viewProfitLossLedger(@RequestParam Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "viewProfitLossLedger");
        map.put("profitLossLedger", accountService.getProfitLossLedger(id));

        return new ModelAndView("accounts/profit_loss_ledger", map);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/acceptJournalVoucher.se")
    public ModelAndView acceptJournalVoucher(@RequestParam Integer vrId) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", ShopDictionary.DASHBOARD_LINK);
        map.put("PageTitle", "Accept Journal Voucher");

        Staff operator;
        User sessionUser = SessionUtil.getSessionUser();
        if (sessionUser instanceof Staff) {
            operator = adminService.getStaff(sessionUser.getId());
        } else {
            map.put(ERROR_KEY, "You must have to be Staff to execute this operation.");
            return new ModelAndView(REDIRECT_ERROR, map);
        }

        JournalVoucher vr = accountService.getJournalVoucher(vrId);
        Staff receiver = vr.getReceiver();

        if (!operator.getId().equals(receiver.getId())) {
            map.put(ERROR_KEY, "This amount was not sent for you.<br/>This amount can only be accepted by "+receiver.getName());
            return new ModelAndView(REDIRECT_ERROR, map);
        }
        vr.setStatus(1);
        vr.setReceiveDate(new Date());
        boolean accepted = accountService.update(vr);
        if (accepted) {
            map.put(SUCCESS_KEY, "Amount Received by "+receiver.getName());
            return new ModelAndView("home/gen_success_page", map);
        } else {
            map.put(ERROR_KEY, "Receive failed !");
            return new ModelAndView(REDIRECT_ERROR, map);
        }
    }

}
