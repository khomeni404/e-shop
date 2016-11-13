package bd.com.softengine.account.model;

import bd.com.softengine.admin.model.Staff;
import bd.com.softengine.security.model.User;
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
@DiscriminatorValue("Cash Account")
public class CashAccount extends Account implements Serializable {

    @OneToOne
    @JoinColumn(name = "ac_owner_id")
    private User owner;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
