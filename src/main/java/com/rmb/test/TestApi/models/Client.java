package com.rmb.test.TestApi.models;

import javax.validation.constraints.NotBlank;

public class Client {
    @NotBlank
    private String clientId;
    @NotBlank
    private String clientSecret;
    private String additionalInfo;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}
