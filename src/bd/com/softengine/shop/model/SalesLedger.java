package bd.com.softengine.shop.model;

import bd.com.softengine.account.model.SalesVoucher;
import bd.com.softengine.admin.model.Customer;
import bd.com.softengine.admin.model.Staff;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 22/11/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 22/11/15
 * Version : 1.0
 */

@Entity
@Table(name = "ST_SALES_LEDGER")
public class SalesLedger implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "order_no")
    private String orderNo;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne
    private Store store;       // OK
    @Column(name = "round_off")
    private Double roundDiscount;
    @Column(name = "total_off")
    private Double totalDiscount;
    @Column(name = "total_amt")
    private Double totalAmount; // After all discount
    @Column(name = "paid_total")
    private Double paidTotal;
    @Column(name = "due_total")
    private Double dueTotal;
    @ManyToOne
    private Source source;      // OK
    @ManyToOne
    private Customer customer;     // OK
    @Column(name = "customer_name")
    private String customerName;

    @OneToOne(mappedBy = "salesLedger")
    private SalesVoucher salesVoucher;

    @ManyToOne
    @JoinColumn(name = "sales_man_id")
    private Staff salesMan;       // OK
    private String status;          // Checked, Not Checked


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "salesLedger")
    @Fetch(value = FetchMode.SELECT)
    private List<ItemOutLog> outLogList = new ArrayList<ItemOutLog>();



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Double getPaidTotal() {
        return paidTotal;
    }

    public void setPaidTotal(Double paidTotal) {
        this.paidTotal = paidTotal;
    }

    public Double getDueTotal() {
        return dueTotal;
    }

    public void setDueTotal(Double dueTotal) {
        this.dueTotal = dueTotal;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Staff getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(Staff salesMan) {
        this.salesMan = salesMan;
    }

    public SalesVoucher getSalesVoucher() {
        return salesVoucher;
    }

    public void setSalesVoucher(SalesVoucher salesVoucher) {
        this.salesVoucher = salesVoucher;
    }

    public Double getRoundDiscount() {
        return roundDiscount;
    }

    public void setRoundDiscount(Double roundDiscount) {
        this.roundDiscount = roundDiscount;
    }

    public List<ItemOutLog> getOutLogList() {
        return outLogList;
    }

    public void setOutLogList(List<ItemOutLog> outLogList) {
        this.outLogList = outLogList;
    }

    public SalesLedger toJsonBean() {
        SalesLedger ledger = this;
        ledger.setCustomer(null);
        ledger.setSource(null);
        ledger.setStore(null);
        ledger.setOutLogList(null);
        ledger.setSalesMan(null);
        return ledger;
    }
}
