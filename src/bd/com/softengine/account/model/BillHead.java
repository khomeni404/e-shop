package bd.com.softengine.account.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: M Ayatullah
 * Date: 21/10/15
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("bill")
public class BillHead extends GLHead implements Serializable {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "billHead")
    @Fetch(FetchMode.SELECT)
    private List<Bill> billList = new ArrayList<>(0);

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }
}
