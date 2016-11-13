package bd.com.softengine.admin.model;

import bd.com.softengine.account.model.CashAccount;
import bd.com.softengine.security.model.User;
import bd.com.softengine.shop.model.SalesLedger;
import bd.com.softengine.shop.model.StockLedger;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 05/09/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 05/09/15
 * Version : 1.0
 */

@Entity
@DiscriminatorValue("vendor")
public class Vendor extends User implements Serializable {

    @Column(name="vendor_id")
    private String vid;

    @OneToOne(mappedBy = "owner")
    @JoinColumn(name = "vendor_ac_id")
    private CashAccount cashAccount;

   /* @OneToMany(fetch = FetchType.EAGER, mappedBy = "dataOperator")
    @Fetch(value = FetchMode.SELECT)
    private List<StockLedger> stockLedgerList = new ArrayList<StockLedger>();
    The system will provide a security module which will have three level of access such as System Admin, Staff and Customer. System Admin is fully responsible for monitoring and maintaining the system since they have access on some modules which are hidden on Staff and Customer such as User Management, Privilege Management. At first, the system will only have one (1) System Admin who has the authority to add more users by filling up the form which is available only in the Admin module. This form will need some information of the users such as full name, contact number, username, and password. In case of suspicious acts of the users, the main Admin has power to deactivate them.
*/
}
