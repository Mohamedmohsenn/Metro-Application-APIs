package com.example.metroapp.payload;

public class ChargeRequest {
    Long amount;
    String cardnum;
    String cvv;
    int exp_month;
    int exp_year;

    public ChargeRequest(Long amount, String cardnum, String cvv, int exp_month, int exp_year) {
        this.amount = amount;
        this.cardnum = cardnum;
        this.cvv = cvv;
        this.exp_month = exp_month;
        this.exp_year = exp_year;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public int getExp_month() {
        return exp_month;
    }

    public void setExp_month(int exp_month) {
        this.exp_month = exp_month;
    }

    public int getExp_year() {
        return exp_year;
    }

    public void setExp_year(int exp_year) {
        this.exp_year = exp_year;
    }
}
