package bd.com.softengine.shop.model;

import bd.com.softengine.account.model.StockVoucher;
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
@Table(name = "ST_STOCK_LEDGER")
public class StockLedger implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "ref_no")
    private String refNo;
    @Column(name = "vendor_name")
    private String vendorName;
    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate;
    @ManyToOne
    private Store store;
    @Column(name = "total_amt")
    private Double totalAmount;
    @ManyToOne
    private Source source;
    private String status;
    @ManyToOne
    @JoinColumn(name = "operator_id")
    private Staff dataOperator;

    @OneToOne(mappedBy = "stockLedger")
    private StockVoucher stockVoucher;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "stockLedger")
    @Fetch(value = FetchMode.SELECT)
    private List<ItemInLog> inLogList = new ArrayList<ItemInLog>();




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Staff getDataOperator() {
        return dataOperator;
    }

    public void setDataOperator(Staff dataOperator) {
        this.dataOperator = dataOperator;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<ItemInLog> getInLogList() {
        return inLogList;
    }

    public void setInLogList(List<ItemInLog> inLogList) {
        this.inLogList = inLogList;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public static StockLedger toJsonBean() {
        StockLedger ledger = new StockLedger();
        ledger.setDataOperator(null);
        ledger.setSource(null);
        ledger.setStore(null);
        ledger.setInLogList(null);
        return ledger;
    }
}
