package bd.com.softengine.admin.model;

import bd.com.softengine.shop.model.Item;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 2002-2003 Islami Bank Bangladesh Limited
 * <p>
 * Original author: Ayatullah Khomeni
 * <br/> Date: 21/06/2016
 * <br/> Last modification by: ayat $
 * <br/> Last modification on 21/06/2016: 3:10 PM
 * <br/> Current revision: : 1.1.1.1
 * </p>
 * Revision History:
 * ------------------
 */
@Entity
@Table(name = "AD_MANUFACTURER")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Column(name = "hot_line")
    private String hotLine;

    private String email;

    @Column(name = "office_address")
    private String officeAddress;

    @Column(name = "warehouse_address")
    private String warehouseAddress;

    @Column(name = "factory_address")
    private String factoryAddress;

    private Integer since;

    @Column(length = 3)
    private String category; // A, A+, AA+, B, C

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "manufacturer")
    @Fetch(value = FetchMode.SELECT)
    private List<Item> itemList = new ArrayList<>();

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

    public String getHotLine() {
        return hotLine;
    }

    public void setHotLine(String hotLine) {
        this.hotLine = hotLine;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getFactoryAddress() {
        return factoryAddress;
    }

    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    public Integer getSince() {
        return since;
    }

    public void setSince(Integer since) {
        this.since = since;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
