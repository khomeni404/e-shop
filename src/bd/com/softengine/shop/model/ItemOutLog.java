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
@Table(name = "ST_ITEM_OUT_LOG")
public class ItemOutLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Item item;

    @ManyToOne
    @JoinColumn(name = "ledger_id")
    private SalesLedger salesLedger;

    private Double qty;                      // 5            (Manual)

    @Column(name = "purchased_price")
    private Double purchasedPrice;           // 8            (Fixed)

    @Column(name = "labeled_price")
    private Double labeledPrice;             // 10 Tk/Unit   (Auto)

    @Column(name = "sales_price")
    private Double salesPrice;               // 9 Tk/Unit    (Manual)

    //@Transient
    private Double discount;            // (10-9)*5 = 5 (Manual)



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

    public Double getLabeledPrice() {
        return labeledPrice;
    }

    public void setLabeledPrice(Double labeledPrice) {
        this.labeledPrice = labeledPrice;
    }

    public Double getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(Double purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    public SalesLedger getSalesLedger() {
        return salesLedger;
    }

    public void setSalesLedger(SalesLedger salesLedger) {
        this.salesLedger = salesLedger;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
