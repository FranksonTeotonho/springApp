package com.frankson.app.model;

import com.frankson.app.model.enums.PaymentStatus;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PaymentInCash extends Payment {
    private static final long SerialVersionUID = 1L;

    private Date dueDate;
    private Date paymentDate;

    public PaymentInCash() {

    }

    public PaymentInCash(Integer id, PaymentStatus paymentStatus, PurchaseOrder purchaseOrder, Date dueDate, Date paymentDate) {
        super(id, paymentStatus, purchaseOrder);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

}
