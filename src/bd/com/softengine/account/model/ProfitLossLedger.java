package bd.com.softengine.account.model;

import bd.com.softengine.admin.model.Staff;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 20/05/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 20/05/16
 * Version : 1.0
 */

@Entity
@Table(name = "AC_PROFIT_LOSS_LEDGER")
public class ProfitLossLedger {
    static final String[] FIELD = {"Sales", "Re-pricing", "Stocking", "Lost"};
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer field;

    private Double amt;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String note;

    @ManyToOne
    private Staff operator;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ledger")
    @Fetch(value = FetchMode.SELECT)
    private List<ProfitLossLog> logList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getField() {
        return field;
    }

    public void setField(Integer field) {
        this.field = field;
    }

    public Double getAmt() {
        return amt;
    }

    public void setAmt(Double amt) {
        this.amt = amt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<ProfitLossLog> getLogList() {
        return logList;
    }

    public void setLogList(List<ProfitLossLog> logList) {
        this.logList = logList;
    }

    public Staff getOperator() {
        return operator;
    }

    public void setOperator(Staff operator) {
        this.operator = operator;
    }
}
