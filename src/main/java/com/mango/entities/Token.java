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
 * A secure token based on a credit card's information.
 */
public final class Token
{
    private final String uid;

    private final Boolean live; // true production, false for sandbox

    private final String last4; // last four digits of credit card

    private final String holdername; // credit card holder

    private final Integer exp_month; // expiration month ex. 12

    private final Integer exp_year; // expiration year ex. 2015

    private final String type; // type of credit card

    private final Boolean used; // Indicate if the token has been already used.

    private final String created_at; // token creation date.

    public Token(String uid, Boolean live, String last4, String holdername, Integer exp_month, Integer exp_year, String type, Boolean used, String created_at)
    {
        this.uid = uid;
        this.live = live;
        this.last4 = last4;
        this.holdername = holdername;
        this.exp_month = exp_month;
        this.exp_year = exp_year;
        this.type = type;
        this.used = used;
        this.created_at = created_at;
    }

    public String getUid() {
        return uid;
    }

    public Boolean getLive() {
        return live;
    }

    public String getLast4() {
        return last4;
    }

    public String getHoldername() {
        return holdername;
    }

    public Integer getExp_month() {
        return exp_month;
    }

    public Integer getExp_year() {
        return exp_year;
    }

    public String getType() {
        return type;
    }

    public Boolean getUsed() {
        return used;
    }

    public String getCreated_at() {
        return created_at;
    }

    @Override
    public String toString() {
        return String.format("Token[%s , %b, %s, %s, %d, %d, %s, %b, %s]", uid, live, last4, holdername, exp_month, exp_year, type, used, created_at);
    }
}
