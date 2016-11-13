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
@DiscriminatorValue("transaction")
public class TransactionHead extends GLHead implements Serializable {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "transactionHead")
    @Fetch(FetchMode.SELECT)
    private List<Transaction> transactionList = new ArrayList<>(0);

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
