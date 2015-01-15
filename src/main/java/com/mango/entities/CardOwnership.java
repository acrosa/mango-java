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
 * Represents an ownership relationship of a customer and a credit card
 */
public final class CardOwnership
{
    private final String token;

    private final String customer;

    public CardOwnership(String token, String customer)
    {
        this.token = token;
        this.customer = customer;
    }

    public String getToken() {
        return token;
    }

    public String getCustomer() {
        return customer;
    }
}
