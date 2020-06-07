package com.frankson.app.model.enums;

public enum PaymentStatus {

    PENDENT(0, "Pendente"),
    CONCLUDED(1, "Quitado"),
    CANCELED (2, "Cancelado");

    private final int code;
    private final String description;

    PaymentStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentStatus toEnum(Integer code){
        if(code == null) {
            return null;
        }

        for(PaymentStatus paymentStatus : PaymentStatus.values()) {
            if (code.equals(paymentStatus.getCode())) {
                return paymentStatus;
            }
        }

        throw new IllegalArgumentException(String.format("The Id: %s is invalid!", code));
    }
}
