package bd.com.softengine.shop.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 25/10/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 25/10/15
 * Version : 1.0
 */

@Entity
@Table(name = "ST_SOURCE")
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;      // Sales, Purchase, Return, Donation

    private String description;

    /*@OneToMany
    @JoinTable(name = "ST_ZT_SOURCE_STOCK_LEDGER",
            joinColumns = @JoinColumn(name = "SOURCE_ID"),
            inverseJoinColumns = @JoinColumn(name = "LEDGER_ID"))*/
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "source")
    @Fetch(value = FetchMode.SELECT)
    private List<StockLedger> stockLedgerList = new ArrayList<StockLedger>();


    /*@OneToMany
    @JoinTable(name = "ST_ZT_SOURCE_SALES_LEDGER",
            joinColumns = @JoinColumn(name = "SOURCE_ID"),
            inverseJoinColumns = @JoinColumn(name = "LEDGER_ID"))*/
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "source")
    @Fetch(value = FetchMode.SELECT)
    private List<SalesLedger> salesLedgerList = new ArrayList<SalesLedger>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<StockLedger> getStockLedgerList() {
        return stockLedgerList;
    }

    public void setStockLedgerList(List<StockLedger> stockLedgerList) {
        this.stockLedgerList = stockLedgerList;
    }

    public List<SalesLedger> getSalesLedgerList() {
        return salesLedgerList;
    }

    public void setSalesLedgerList(List<SalesLedger> salesLedgerList) {
        this.salesLedgerList = salesLedgerList;
    }
}
