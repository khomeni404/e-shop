package bd.com.softengine.shop.model;

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
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "getComboStoreList",
                query = "select id, name from Store s",
                resultClass = Store.class
        )
})
@Entity
@Table(name = "ST_STORE")
public class Store  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Column(name = "started_from")
    @Temporal(TemporalType.DATE)
    private Date startedFrom;

    private String address;

    @Column(name = "contact_no")
    private String contactNo;

    /*@OneToMany
    @JoinTable(name = "ST_ZT_STORE_IN_ITEM_LOG",
            joinColumns = @JoinColumn(name = "STORE_ID"),
            inverseJoinColumns = @JoinColumn(name = "LEDGER_ID"))*/
 /*   @OneToMany(fetch = FetchType.EAGER, mappedBy = "store")
    @Fetch(value = FetchMode.SELECT)
    private List<ItemInLog> inLogList = new ArrayList<ItemInLog>(0);
*/
    /*@OneToMany
    @JoinTable(name = "ST_ZT_STORE_OUT_ITEM_LOG",
            joinColumns = @JoinColumn(name = "STORE_ID"),
            inverseJoinColumns = @JoinColumn(name = "LEDGER_ID"))*/
   /* @OneToMany(fetch = FetchType.EAGER, mappedBy = "")
    @Fetch(value = FetchMode.SELECT)
    private List<ItemOutLog> outLogList = new ArrayList<ItemOutLog>(0);

*/

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "store")
    @Fetch(value = FetchMode.SELECT)
    private List<SalesLedger> salesLedgerList = new ArrayList<SalesLedger>(0);


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "store")
    @Fetch(value = FetchMode.SELECT)
    private List<StockLedger> stockLedgerList = new ArrayList<StockLedger>(0);


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartedFrom() {
        return startedFrom;
    }

    public void setStartedFrom(Date startedFrom) {
        this.startedFrom = startedFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<SalesLedger> getSalesLedgerList() {
        return salesLedgerList;
    }

    public List<StockLedger> getStockLedgerList() {
        return stockLedgerList;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setStockLedgerList(List<StockLedger> stockLedgerList) {
        this.stockLedgerList = stockLedgerList;
    }

    public void setSalesLedgerList(List<SalesLedger> salesLedgerList) {
        this.salesLedgerList = salesLedgerList;
    }
}
