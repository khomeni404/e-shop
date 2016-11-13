package bd.com.softengine.account.model;


import bd.com.softengine.security.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: M Ayatullah
 * Date: 9/3/14
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="vr_type",discriminatorType = DiscriminatorType.STRING)
@Table(name="AC_VOUCHER_MASTER"/*, uniqueConstraints=
@UniqueConstraint(columnNames={"instrument_no", "date"})*/)
public abstract class Voucher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "instrument_no")
    private String instrumentNo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "dr_ac_id")
    private Account drAc;

    @ManyToOne
    @JoinColumn(name = "cr_ac_id")
    private Account crAc;

    @Column(columnDefinition = "text")
    private String note;

    @ManyToOne
    @JoinColumn(name = "operator_id")
    private User operator;

    private Integer status;

    @Transient
    public String getDiscriminatorValue(){
        DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );
        return val == null ? null : val.value();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstrumentNo() {
        return instrumentNo;
    }

    public void setInstrumentNo(String instrumentNo) {
        this.instrumentNo = instrumentNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public Account getDrAc() {
        return drAc;
    }

    public void setDrAc(Account drAc) {
        this.drAc = drAc;
    }

    public Account getCrAc() {
        return crAc;
    }

    public void setCrAc(Account crAc) {
        this.crAc = crAc;
    }

    public User getOperator() {
        return operator;
    }

    public void setOperator(User dataOperator) {
        this.operator = dataOperator;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
