package com.frankson.app.model;

import com.frankson.app.model.enums.PaymentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    private Integer id;
    private Integer paymentStatus;

    @OneToOne
    @JoinColumn(name = "purchase_order_id")
    @MapsId
    private PurchaseOrder purchaseOrder;
    public Payment() {
    }

    public Payment(Integer id, PaymentStatus paymentStatus, PurchaseOrder purchaseOrder) {
        this.id = id;
        this.paymentStatus = paymentStatus.getCode();
        this.purchaseOrder = purchaseOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentStatus getPaymentStatus() {
        return PaymentStatus.toEnum(paymentStatus);
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus.getCode();
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        //return id != null ? id.equals(payment.id) : payment.id == null;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
