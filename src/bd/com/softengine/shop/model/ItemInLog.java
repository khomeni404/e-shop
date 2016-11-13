package bd.com.softengine.shop.model;

import javax.persistence.*;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 25/10/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 25/10/15
 * Version : 1.0
 */

@Entity
@Table(name = "ST_ITEM_IN_LOG")
public class ItemInLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Item item;

    private Double qty;

    private Double unitPrice;

    @ManyToOne
    private StockLedger stockLedger;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public StockLedger getStockLedger() {
        return stockLedger;
    }

    public void setStockLedger(StockLedger stockLedger) {
        this.stockLedger = stockLedger;
    }
}
