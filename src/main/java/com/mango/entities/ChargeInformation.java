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
 * Represents a charge to be made on a card.
 */
public final class ChargeInformation
{
    private final Integer amount; // Transaction amount in cents according to the store's currency. ex. (2000)

    private final String email; // Buyer's email.

    private final String token; // Previously created credit card token.

    private final String card; // card unique identifier.

    private final String customer; // customer unique identifier.

    private final String origin; // Transaction origin. By default: api

    private final Integer installments; // Installment amount. ex. (3)

    private final String description; // Transaction description.

    private final Boolean enqueue; // Indicates if the charge uses the payment queue.

    private final Float interest_rate; // Interest rate for the charge. Has priority over the one set on the interest matrix. ex. (1.5304)

    /**
     * Returns charge information based on the token
     *
     * @param amount Transaction amount in cents according to the store's currency. ex. (2000)
     * @param email Buyer's email.
     * @param token Previously created credit card token.
     * @return charge information a {@link ChargeInformation}
     */
    public static ChargeInformation TokenChargeInformation(Integer amount, String email, String token) {
        return new ChargeInformation(amount, email, token, null, null, null, null, null, null, null);
    }

    /**
     * Returns charge information based on the customer
     *
     * @param amount Transaction amount in cents according to the store's currency. ex. (2000)
     * @param customer customer unique identifier.
     * @return charge information a {@link ChargeInformation}
     */
    public static ChargeInformation CustomerChargeInformation(Integer amount, String customer) {
        return new ChargeInformation(amount, null, null, null, customer, null, null, null, null, null);
    }

    /**
     * Returns charge information based on the card
     *
     * @param amount Transaction amount in cents according to the store's currency. ex. (2000)
     * @param card a {@link Card} unique identifier.
     * @return charge information a {@link ChargeInformation}
     */
    public static ChargeInformation CardChargeInformation(Integer amount, String card) {
        return new ChargeInformation(amount, null, null, card, null, null, null, null, null, null);
    }

    public ChargeInformation(Integer amount, String email, String token, String card, String customer, String origin, Integer installments, String description, Boolean enqueue, Float interest_rate)
    {
        // check minimal required fields are specified
        if (amount == null || (token == null && card == null && customer == null)) {
            throw new IllegalArgumentException("You need to specify in addition to an amount, at least a card, token or customer.");
        }

        this.amount = amount;
        this.email = email;
        this.token = token;
        this.card = card;
        this.customer = customer;
        this.origin = origin;
        this.installments = installments;
        this.description = description;
        this.enqueue = enqueue;
        this.interest_rate = interest_rate;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public String getCard() {
        return card;
    }

    public String getCustomer() {
        return customer;
    }

    public String getOrigin() {
        return origin;
    }

    public Integer getInstallments() {
        return installments;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getEnqueue() {
        return enqueue;
    }

    public Float getInterest_rate() {
        return interest_rate;
    }

    @Override
    public String toString() {
        return String.format("ChargeInformation[%s , %s, %s, %s, %s]", amount, email, token, card, description);
    }
}
