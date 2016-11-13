package bd.com.softengine.account.model;

import bd.com.softengine.admin.model.Staff;
import bd.com.softengine.shop.model.SalesLedger;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 28/09/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 28/09/15
 * Version : 1.0
 */

@Entity
@DiscriminatorValue("Sales")
public class SalesVoucher extends Voucher implements Serializable {


    @ManyToOne
    @JoinColumn(name = "sales_man_id")
    private Staff salesMan;

    @OneToOne
    @JoinColumn(name = "sl_id")
    private SalesLedger salesLedger;


    public Staff getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(Staff salesMan) {
        this.salesMan = salesMan;
    }

    public SalesLedger getSalesLedger() {
        return salesLedger;
    }

    public void setSalesLedger(SalesLedger salesLedger) {
        this.salesLedger = salesLedger;
    }
}
