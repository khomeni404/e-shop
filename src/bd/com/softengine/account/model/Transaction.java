package bd.com.softengine.account.model;

import bd.com.softengine.admin.model.Staff;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: M Ayatullah
 * Date: 9/3/14
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("Transaction")
public class Transaction extends Voucher implements Serializable {

    @ManyToOne
    @JoinColumn(name = "tr_head_id")
    private TransactionHead transactionHead;

    @ManyToOne
    @JoinColumn(name = "trp_id")
    private Staff permissive;

    @ManyToOne
    @JoinColumn(name = "depositor_id")
    private Staff depositor;

    public Staff getPermissive() {
        return permissive;
    }

    public void setPermissive(Staff permissive) {
        this.permissive = permissive;
    }

    public Staff getDepositor() {
        return depositor;
    }

    public void setDepositor(Staff depositor) {
        this.depositor = depositor;
    }

    public TransactionHead getTransactionHead() {
        return transactionHead;
    }

    public void setTransactionHead(TransactionHead transactionHead) {
        this.transactionHead = transactionHead;
    }
}
