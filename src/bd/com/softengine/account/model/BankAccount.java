package bd.com.softengine.account.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: M Ayatullah
 * Date: 9/3/14
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("Bank Account")
public class BankAccount extends Account implements Serializable {

    @Column(name = "ac_no")
    private String accountNo;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_ac_cat")
    private String accountCategory;  // Current, Savings


    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountCategory() {
        return accountCategory;
    }

    public void setAccountCategory(String accountCategory) {
        this.accountCategory = accountCategory;
    }
}
