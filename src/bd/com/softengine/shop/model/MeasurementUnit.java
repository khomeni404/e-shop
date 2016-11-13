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
@Table(name = "ST_M_UNIT")
public class MeasurementUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String description;

    /*@OneToMany
    @JoinTable(name = "ST_ZT_UNIT_ITEM",
            joinColumns = @JoinColumn(name = "UNIT_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))*/
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "unit")
    @Fetch(value = FetchMode.SELECT)
    private List<Item> itemList = new ArrayList<Item>();


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

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
