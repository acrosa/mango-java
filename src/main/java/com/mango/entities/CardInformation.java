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
 * Represents card information asked to the user.
 * It's important not to persist this information and pass it along to the mango api.
 */
public final class CardInformation
{
    private final String number; // credit card number (ex. 4407990000000111)

    private final Integer exp_month; // expiration month ex. 12

    private final Integer exp_year; // expiration year ex. 2015

    private final String holdername; // credit card holder

    private final String cardtype; // type of credit card

    private final Integer ccv; // security code in the back of the card. (3 or 4 digits)

    public CardInformation(String number, Integer exp_month, Integer exp_year, String holdername, String cardtype, Integer ccv)
    {
        this.number = number;
        this.exp_month = exp_month;
        this.exp_year = exp_year;
        this.holdername = holdername;
        this.cardtype = cardtype;
        this.ccv = ccv;
    }

    public String getNumber() {
        return number;
    }

    public Integer getExp_month() {
        return exp_month;
    }

    public Integer getExp_year() {
        return exp_year;
    }

    public String getHoldername() {
        return holdername;
    }

    public String getCardtype() {
        return cardtype;
    }

    public Integer getCcv() {
        return ccv;
    }

    @Override
    public String toString() {
        return String.format("CardInformation[%s, %s]", holdername, cardtype); // don't use number property
    }
}
