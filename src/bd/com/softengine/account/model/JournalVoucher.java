package bd.com.softengine.account.model;

import bd.com.softengine.admin.model.Staff;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 28/09/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 28/09/15
 * Version : 1.0
 */

@Entity
@DiscriminatorValue("Journal")
public class JournalVoucher extends Voucher implements Serializable {


    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Staff sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Staff receiver;

    @Column(name = "receive_date")
    @Temporal(TemporalType.DATE)
    private Date receiveDate;


    public Staff getSender() {
        return sender;
    }

    public void setSender(Staff sender) {
        this.sender = sender;
    }

    public Staff getReceiver() {
        return receiver;
    }

    public void setReceiver(Staff receiver) {
        this.receiver = receiver;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }
}
