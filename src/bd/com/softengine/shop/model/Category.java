package bd.com.softengine.shop.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "ST_CATEGORY")
public class Category implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String description;

/*    @OneToMany
    @JoinTable(name = "ST_ZT_CATEGORY_ITEM",
                    joinColumns = @JoinColumn(name = "CAT_ID"),
                    inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))*/
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
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
