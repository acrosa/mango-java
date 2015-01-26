package com.mango.entities;

public final class Installment
{
    private final Integer amount;

    private final Integer amount_gross;

    private final String cardtype;

    private final Float interest_rate;

    private final Integer installments;

    public Installment(Integer amount, Integer amount_gross, String cardtype, Float interest_rate, Integer installments) {
        this.amount = amount;
        this.amount_gross = amount_gross;
        this.cardtype = cardtype;
        this.interest_rate = interest_rate;
        this.installments = installments;
    }

    @Override
    public String toString() {
        return String.format("Installment[%s, %s, %s, %s, %s]", amount, amount_gross, cardtype, interest_rate, installments);
    }
}
