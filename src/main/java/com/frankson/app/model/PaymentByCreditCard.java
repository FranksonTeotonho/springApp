package com.frankson.app.model;

import com.frankson.app.model.enums.PaymentStatus;

import javax.persistence.Entity;

@Entity
public class PaymentByCreditCard extends Payment {
    private static final long SerialVersionUID = 1L;

    private Integer installmentsNumber;

    public PaymentByCreditCard() {

    }

    public PaymentByCreditCard(Integer id, PaymentStatus paymentStatus, PurchaseOrder purchaseOrder, Integer installmentsNumber) {
        super(id, paymentStatus, purchaseOrder);
        this.installmentsNumber = installmentsNumber;
    }

    public Integer getInstallmentsNumber() {
        return installmentsNumber;
    }

    public void setInstallmentsNumber(Integer installmentsNumber) {
        this.installmentsNumber = installmentsNumber;
    }
}
