package com.frankson.app.model.enums;

public enum ClientType {

    INDIVIDUAL_ENTITY(0, "Pessoa Física"),
    LEGAL_ENTITY(1, "Pessoa Jurídica");

    private final int code;
    private final String description;

    ClientType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ClientType toEnum(Integer code){
        if(code == null) {
            return null;
        }

        for(ClientType clientType : ClientType.values()) {
            if (code.equals(clientType.getCode())) {
                return clientType;
            }
        }

        throw new IllegalArgumentException(String.format("The Id: %s is invalid!", code));
    }
}
