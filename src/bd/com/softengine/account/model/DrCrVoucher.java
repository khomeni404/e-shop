package bd.com.softengine.account.model;

import bd.com.softengine.admin.model.Customer;
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
@DiscriminatorValue("Party")
public class DrCrVoucher extends Voucher implements Serializable {

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;


    @JoinColumn(name = "cust_name")
    private String customerName;

    @OneToOne
    @JoinColumn(name = "sl_id")
    private SalesLedger salesLedger;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SalesLedger getSalesLedger() {
        return salesLedger;
    }

    public void setSalesLedger(SalesLedger salesLedger) {
        this.salesLedger = salesLedger;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
