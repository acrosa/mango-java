/*
 * Copyright (C) 2015 Alejandro Crosa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mango.entities;

/**
 * A charge to a credit card.
 */
public final class Charge
{
    private final String uid; // charge unique identifier.

    private final Integer amount; // Transaction amount in cents according to the store's currency. ex. (2000)

    private final Integer amount_gross; // Transaction amount in cents according to the store's currency, including installment interests. ex. (2420)

    private final String interest_rate; // Interest rate to calculate the amount with installments.

    private final String created_at; // Transaction date and time.

    private final String description; // Transaction description.

    private final String email; // Buyer's email.

    private final String deposit_eta; // Estimated time arrival for funds from the issuer ex. ("2014-07-04 17:35:10")

    private final Integer fee; // Mango service fee. ex. (20)

    private final String failure_message; // Error message if the transaction fails.

    private final Integer installments; // Installment quantity. ex. (3)

    private final Boolean live; // Mode in which the transaction was made. ex. (false for "Sandbox" mode.)

    private final String origin; // Transaction origin. By default: api.

    private final Boolean paid; // Indicates if the payment was made

    private final Card plastic; // Object with the physical card's information

    private final String customer; // customer unique identifier.

    private final String card; // card unique identifier.

    private final String queue; // queue unique identifier.

    private final Boolean refunded; // Indicates if the transaction was refunded.

    private final String refund; // refund unique identifier.

    public Charge(String uid, Integer amount, Integer amount_gross, String interest_rate, String created_at, String description, String email, String deposit_eta, Integer fee, String failure_message, Integer installments, Boolean live, String origin, Boolean paid, Card plastic, String customer, String card, String queue, Boolean refunded, String refund)
    {
        this.uid = uid;
        this.amount = amount;
        this.amount_gross = amount_gross;
        this.interest_rate = interest_rate;
        this.created_at = created_at;
        this.description = description;
        this.email = email;
        this.deposit_eta = deposit_eta;
        this.fee = fee;
        this.failure_message = failure_message;
        this.installments = installments;
        this.live = live;
        this.origin = origin;
        this.paid = paid;
        this.plastic = plastic;
        this.customer = customer;
        this.card = card;
        this.queue = queue;
        this.refunded = refunded;
        this.refund = refund;
    }

    public String getUid() {
        return uid;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getAmount_gross() {
        return amount_gross;
    }

    public String getInterest_rate() {
        return interest_rate;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getDeposit_eta() {
        return deposit_eta;
    }

    public Integer getFee() {
        return fee;
    }

    public String getFailure_message() {
        return failure_message;
    }

    public Integer getInstallments() {
        return installments;
    }

    public Boolean getLive() {
        return live;
    }

    public String getOrigin() {
        return origin;
    }

    public Boolean getPaid() {
        return paid;
    }

    public Card getPlastic() {
        return plastic;
    }

    public String getCustomer() {
        return customer;
    }

    public String getCard() {
        return card;
    }

    public String getQueue() {
        return queue;
    }

    public Boolean getRefunded() {
        return refunded;
    }

    public String getRefund() {
        return refund;
    }

    @Override
    public String toString() {
        return String.format("Charge[%s, %b, %b, %s, %s, %s, %s, %s]", uid, live, paid, failure_message, amount, email, customer, created_at);
    }
}
