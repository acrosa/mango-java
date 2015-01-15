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
 * Represents a customer's information.
 */
public final class CustomerInformation
{
    private final String email; // Customer's email.

    private final String name; // Customer's name.

    private final String token; // A credit card's token.

    private final String meta; // Free text to store additional information to a customer.

    public CustomerInformation(String email, String name, String token) {
        this(email, name, token, "");
    }

    public CustomerInformation(String email, String name, String token, String meta)
    {
        this.email = email;
        this.name = name;
        this.token = token;
        this.meta = meta;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    public String getMeta() {
        return meta;
    }

    @Override
    public String toString() {
        return String.format("CustomerInformation[%s , %s, %s, %s]", email, name, token, meta);
    }
}
