package bd.com.softengine.admin.model;

import bd.com.softengine.account.model.CashAccount;
import bd.com.softengine.account.model.ReturnVoucher;
import bd.com.softengine.account.model.Voucher;
import bd.com.softengine.security.model.User;
import bd.com.softengine.shop.model.SalesLedger;
import bd.com.softengine.shop.model.StockLedger;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 05/09/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 05/09/15
 * Version : 1.0
 */

@Entity
@DiscriminatorValue("staff")
public class Staff extends User implements Serializable {

    @Column(name="staff_id")
    private String sid;

    @Column(name="ref_name")
    private String referenceName;

    @Column(name = "staff_type", length = 1)
    private Integer staffType;	//0 = Proprietor, 1 = Salesman

    @OneToOne(mappedBy = "owner")
    @JoinColumn(name = "staff_ac_id")
    private CashAccount cashAccount;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dataOperator")
    @Fetch(value = FetchMode.SELECT)
    private List<StockLedger> stockLedgerList = new ArrayList<StockLedger>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "salesMan")
    @Fetch(value = FetchMode.SELECT)
    private List<SalesLedger> salesLedgerList = new ArrayList<SalesLedger>();

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Integer getStaffType() {
        return staffType;
    }

    public void setStaffType(Integer staffType) {
        this.staffType = staffType;
    }

    public List<StockLedger> getStockLedgerList() {
        return stockLedgerList;
    }

    public void setStockLedgerList(List<StockLedger> stockLedgerList) {
        this.stockLedgerList = stockLedgerList;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public List<SalesLedger> getSalesLedgerList() {
        return salesLedgerList;
    }

    public CashAccount getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(CashAccount cashAccount) {
        this.cashAccount = cashAccount;
    }

    public void setSalesLedgerList(List<SalesLedger> salesLedgerList) {
        this.salesLedgerList = salesLedgerList;
    }
}
