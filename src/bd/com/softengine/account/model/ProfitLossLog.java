package bd.com.softengine.account.model;

import bd.com.softengine.shop.model.Item;

import javax.persistence.*;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 20/05/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 20/05/16
 * Version : 1.0
 */

@Entity
@Table(name = "AC_PROFIT_LOSS_LOG")
public class ProfitLossLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "purchased_price")
    private Double purchasedPrice;

    @Column(name = "labeled_price")
    private Double labeledPrice;

    @Column(name = "discount_amt")
    private Double discountAmt;

    @Column(name = "sales_price")
    private Double salesPrice;

    @Column(name = "old_stock")
    private Double oldStock;

    @Column(name = "new_stock")
    private Double newStock;

    @Column(name = "old_price")
    private Double oldPrice;

    @Column(name = "new_price")
    private Double newPrice;



    private Double qty;

    @Transient
    private Double profitAmt;

    @ManyToOne
    private Item item;

    @ManyToOne
    private ProfitLossLedger ledger;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(Double purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    public Double getLabeledPrice() {
        return labeledPrice;
    }

    public void setLabeledPrice(Double labeledPrice) {
        this.labeledPrice = labeledPrice;
    }

    public Double getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(Double discountAmt) {
        this.discountAmt = discountAmt;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Double getProfitAmt() {
        return (salesPrice - purchasedPrice)*qty;
    }

    public Double getOldStock() {
        return oldStock;
    }

    public void setOldStock(Double oldStock) {
        this.oldStock = oldStock;
    }

    public Double getNewStock() {
        return newStock;
    }

    public void setNewStock(Double newStock) {
        this.newStock = newStock;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }

    public void setProfitAmt(Double profitAmt) {
        this.profitAmt = profitAmt;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ProfitLossLedger getLedger() {
        return ledger;
    }

    public void setLedger(ProfitLossLedger ledger) {
        this.ledger = ledger;
    }
}
