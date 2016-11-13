package bd.com.softengine.account.model;

import bd.com.softengine.admin.model.Staff;
import bd.com.softengine.admin.model.Customer;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 28/09/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 28/09/15
 * Version : 1.0
 */

@Entity
@DiscriminatorValue("Sales Return")
public class ReturnVoucher extends Voucher implements Serializable {

//    @ManyToOne
//    @JoinColumn(name = "cust_id")
//    private Customer customer;

    @Column(name = "cust_name")
    private String custName;

    @ManyToOne
    @JoinColumn(name = "rvp_id")
    private Staff permissive;


    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Staff getPermissive() {
        return permissive;
    }

    public void setPermissive(Staff permissive) {
        this.permissive = permissive;
    }
}
