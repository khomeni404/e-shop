package bd.com.softengine.admin.model;

import bd.com.softengine.account.model.CashAccount;
import bd.com.softengine.account.model.DrCrVoucher;
import bd.com.softengine.account.model.ReturnVoucher;
import bd.com.softengine.security.model.User;
import bd.com.softengine.shop.model.SalesLedger;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 05/09/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 05/09/15
 * Version : 1.0
 */

@Entity
@DiscriminatorValue("customer")
public class Customer extends User implements Serializable {

    @Column(name="customer_id")
    private String cid;

    @Column(name = "bz_addr")
    private String businessAddress;

    @Column(name = "nid")
    private String nid;
    @Column(name = "tin")
    private String tin;
    @Column(name = "key_name")
    private String keyName;
    @Column(name = "cust_type", length = 1)
    private Integer custType;	//0 = Regular, 1 = Irregular

    @OneToOne(mappedBy = "owner")
    @JoinColumn(name = "cust_ac_id")
    private CashAccount cashAccount;

    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    @Fetch(value = FetchMode.SELECT)
    private List<ReturnVoucher> returnVoucherList = new ArrayList<>();
*/
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    @Fetch(value = FetchMode.SELECT)
    private List<SalesLedger> salesLedgerList = new ArrayList<SalesLedger>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    @Fetch(value = FetchMode.SELECT)
    private List<DrCrVoucher> drCrVoucherList = new ArrayList<>();


    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public Integer getCustType() {
        return custType;
    }

    public void setCustType(Integer custType) {
        this.custType = custType;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public List<DrCrVoucher> getDrCrVoucherList() {
        return drCrVoucherList;
    }

    public void setDrCrVoucherList(List<DrCrVoucher> drCrVoucherList) {
        this.drCrVoucherList = drCrVoucherList;
    }

    public CashAccount getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(CashAccount cashAccount) {
        this.cashAccount = cashAccount;
    }

    public List<SalesLedger> getSalesLedgerList() {
        return salesLedgerList;
    }

    public void setSalesLedgerList(List<SalesLedger> salesLedgerList) {
        this.salesLedgerList = salesLedgerList;
    }
}
