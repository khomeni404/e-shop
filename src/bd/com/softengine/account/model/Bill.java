package bd.com.softengine.account.model;

import bd.com.softengine.account.service.AccountService;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: M Ayatullah
 * Date: 9/3/14
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("Bill")
public class Bill extends Voucher implements Serializable{

    @ManyToOne
    @JoinColumn(name = "head_id")
    private BillHead billHead;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bill")
    @Fetch(FetchMode.SELECT)
    private List<BillItem> itemList = new ArrayList<>(0);

    public BillHead getBillHead() {
        return billHead;
    }

    public void setBillHead(BillHead billHead) {
        this.billHead = billHead;
    }

    public List<BillItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<BillItem> itemList) {
        this.itemList = itemList;
    }
}
