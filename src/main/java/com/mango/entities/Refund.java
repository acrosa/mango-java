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
 * Create a refund of a charge made
 */
public final class Refund
{
    private final String uid; // refund unique identifier.

    private final Integer amount; // Transaction amount in cents according to the store's currency. ex. (2000)

    private final String created_at; // Transaction date and time.

    private final Integer fee; // Mango service fee. ex. (20)

    private final Boolean live; // Mode in which the transaction was made. ex. (false for "Sandbox" mode.)

    private final String origin; // Transaction origin. By default: api.

    private final String refund_type; // Indicates wether the refund was partial, total or was a cancellation. Default full Possible values: full, partial, cancellation

    private final String charge; // Refunded charge unique identifier.

    public Refund(String uid, Integer amount, String created_at, Integer fee, Boolean live, String origin, String refund_type, String charge)
    {
        this.uid = uid;
        this.amount = amount;
        this.created_at = created_at;
        this.fee = fee;
        this.live = live;
        this.origin = origin;
        this.refund_type = refund_type;
        this.charge = charge;
    }

    public String getUid() {
        return uid;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getCreated_at() {
        return created_at;
    }

    public Integer getFee() {
        return fee;
    }

    public Boolean getLive() {
        return live;
    }

    public String getOrigin() {
        return origin;
    }

    public String getRefund_type() {
        return refund_type;
    }

    public String getCharge() {
        return charge;
    }

    @Override
    public String toString() {
        return String.format("Refund[%s, %b, %s , %s, %s, %s]", uid, live, charge, amount, origin, created_at);
    }
}
