package bd.com.softengine.shop.model;

import bd.com.softengine.account.model.ProfitLossLog;
import bd.com.softengine.admin.model.ItemReport;
import bd.com.softengine.admin.model.Manufacturer;
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
@Table(name = "ST_ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String itemCode;

    @Column(name = "price_code")
    private String priceCode;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "mf_id")
    private Manufacturer manufacturer;

    @Column(name = "purchased_price")
    private Double purchasedPrice;            // This part has been changed on each purchase

    @Column(name = "labeled_price")
    private Double labeledPrice;              // This part has been changed on each purchase

    @ManyToOne
    private Category category;

    @ManyToOne
    private MeasurementUnit unit;

    @Column(name = "stock")
    private Double stock;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
    @Fetch(value = FetchMode.SELECT)
    private List<ItemInLog> inLogList = new ArrayList<>();


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
    @Fetch(value = FetchMode.SELECT)
    private List<ItemReport> itemReportList = new ArrayList<>();


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
    @Fetch(value = FetchMode.SELECT)
    private List<ItemOutLog> outLogList = new ArrayList<ItemOutLog>();


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
    @Fetch(value = FetchMode.SELECT)
    private List<ProfitLossLog> profitLossLogList = new ArrayList<>();


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

    public String getItemCode() {
        return itemCode;
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

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public void setCategory(String id) {
        this.category = null;
    }

    public MeasurementUnit getUnit() {
        return unit;
    }

    public void setUnit(MeasurementUnit unit) {
        this.unit = unit;
    }

    public List<ItemInLog> getInLogList() {
        return inLogList;
    }

    public void setInLogList(List<ItemInLog> inLogList) {
        this.inLogList = inLogList;
    }

    public List<ItemOutLog> getOutLogList() {
        return outLogList;
    }

    public List<ProfitLossLog> getProfitLossLogList() {
        return profitLossLogList;
    }

    public void setProfitLossLogList(List<ProfitLossLog> profitLossLogList) {
        this.profitLossLogList = profitLossLogList;
    }

    public List<ItemReport> getItemReportList() {
        return itemReportList;
    }

    public void setItemReportList(List<ItemReport> itemReportList) {
        this.itemReportList = itemReportList;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(String priceCode) {
        this.priceCode = priceCode;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public void setOutLogList(List<ItemOutLog> outLogList) {
        this.outLogList = outLogList;
    }
}
