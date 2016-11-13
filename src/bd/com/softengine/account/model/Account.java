package bd.com.softengine.account.model;

import bd.com.softengine.security.model.User;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: M Ayatullah
 * Date: 9/3/14
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ac_type",discriminatorType = DiscriminatorType.STRING)
@Table(name="AC_ACCOUNT_MASTER")
public class Account  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double balance;

    @Temporal(TemporalType.DATE)
    @Column(name = "opening_date")
    private Date openingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "closing_date")
    private Date closingDate;

    private String note;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "activator_id")
    private User activeBy;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "drAc")
    @Fetch(value = FetchMode.SELECT)
    private List<Voucher> drVoucherList = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "crAc")
    @Fetch(value = FetchMode.SELECT)
    private List<Voucher> crVoucherList = new ArrayList<>();



    @Transient
    public String getDiscriminatorValue(){
        DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );
        return val == null ? null : val.value();
    }

    @Transient
    public Double getBalance() {
        balance = 0.0;
        for (Voucher cb : this.crVoucherList) {
            balance += cb.getStatus() == 1 ? cb.getAmount() : 0.0;
        }
        for (Voucher cb : this.drVoucherList) {
            balance -= cb.getStatus() == 1 ? cb.getAmount() : 0.0;
        }
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Voucher> getDrVoucherList() {
        return drVoucherList;
    }

    public void setDrVoucherList(List<Voucher> drVoucherList) {
        this.drVoucherList = drVoucherList;
    }

    public List<Voucher> getCrVoucherList() {
        return crVoucherList;
    }

    public void setCrVoucherList(List<Voucher> crVoucherList) {
        this.crVoucherList = crVoucherList;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getActiveBy() {
        return activeBy;
    }

    public void setActiveBy(User activeBy) {
        this.activeBy = activeBy;
    }
}
