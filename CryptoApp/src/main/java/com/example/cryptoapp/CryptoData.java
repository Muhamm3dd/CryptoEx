package com.example.cryptoapp;

public class CryptoData {
    private String cryptocurrency;
    private double [] marketValue;

    //data for Crypto
    public CryptoData(String cryptocurrency, double[] marketValue) {
        this.cryptocurrency = cryptocurrency;
        this.marketValue = marketValue;
    }

    public String getCryptocurrency() {
        return cryptocurrency;
    }

    public void setCryptocurrency(String cryptocurrency) {
        this.cryptocurrency = cryptocurrency;
    }

    public double[] getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double[] marketValue) {
        this.marketValue = marketValue;
    }
}
