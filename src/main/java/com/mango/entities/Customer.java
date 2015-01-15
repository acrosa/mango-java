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

import java.util.List;

/**
 * A customer credit, a {@link Card} holder
 */
public final class Customer
{
    private final String uid; // customer unique identifier.

    private final String email; // Customer's email.

    private final String name; // Customer's name

    private final Boolean live; // false for "Sandbox" mode.

    private final String meta; // Free text to store additional information to a customer.

    private final String default_card; // Default {@link Card} unique identifier.

    private List<Card> cards; // The list of a customer's {@link Card}.

    private final String created_at; // Customer creation date.

    private final String updated_at; // Customer last edition date.

    public Customer(String uid, String email, String name, Boolean live, String meta, String default_card, List<Card> cards, String created_at, String updated_at)
    {
        this.uid = uid;
        this.email = email;
        this.name = name;
        this.live = live;
        this.meta = meta;
        this.default_card = default_card;
        this.cards = cards;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Boolean getLive() {
        return live;
    }

    public String getMeta() {
        return meta;
    }

    public String getDefault_card() {
        return default_card;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    @Override
    public String toString() {
        return String.format("Customer[%s, %b, %s, %s, Cards: %s]", uid, live, name, email, cards);
    }
}
