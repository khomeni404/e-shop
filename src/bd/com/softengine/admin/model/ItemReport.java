package bd.com.softengine.admin.model;


import bd.com.softengine.security.model.User;
import bd.com.softengine.shop.model.Item;

import javax.persistence.*;
import java.util.Date;

/**
 * Copyright (C) 2002-2003 Islami Bank Bangladesh Limited
 * <p>
 * Original author: Ayatullah Khomeni
 * <br/> Date: 21/06/2016
 * <br/> Last modification by: ayat $
 * <br/> Last modification on 21/06/2016: 3:17 PM
 * <br/> Current revision: : 1.1.1.1
 * </p>
 * Revision History:
 * ------------------
 */

@Entity
@Table(name = "AD_ITEM_REPORT")
public class ItemReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "reporter_id")
    private User reporter;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(columnDefinition = "text")
    private String comment;

    @Column(columnDefinition = "text")
    private String suggestion;

    @Temporal(TemporalType.DATE)
    private Date date;

    private Boolean viewed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getComment() {
        return comment;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getViewed() {
        return viewed;
    }

    public void setViewed(Boolean viewed) {
        this.viewed = viewed;
    }
}
