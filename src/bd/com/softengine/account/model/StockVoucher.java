package bd.com.softengine.account.model;

import bd.com.softengine.admin.model.Staff;
import bd.com.softengine.shop.model.SalesLedger;
import bd.com.softengine.shop.model.StockLedger;

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
@DiscriminatorValue("Stock")
public class StockVoucher extends Voucher implements Serializable {


    @ManyToOne
    @JoinColumn(name = "prop_id")
    private Staff proprietor;

    @OneToOne
    @JoinColumn(name = "stl_id")
    private StockLedger stockLedger;


    public Staff getProprietor() {
        return proprietor;
    }

    public void setProprietor(Staff proprietor) {
        this.proprietor = proprietor;
    }

    public StockLedger getStockLedger() {
        return stockLedger;
    }

    public void setStockLedger(StockLedger stockLedger) {
        this.stockLedger = stockLedger;
    }
}
