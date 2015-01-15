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
package com.mango.client.resources;

import com.mango.entities.Charge;
import com.mango.entities.ChargeInformation;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

import java.util.List;

/**
 * Create a charge to a credit card or get information about previous charges.
 */
public interface Charges
{
    /**
     * Create a charge
     * Create a charge to a credit card. To create a charge, you need to send an amount and either a credit card token, card or customer.
     * If you send a customer, the API will use the customer's default card.
     *
     * @param information {@link ChargeInformation}
     * @return a charge {@link Charge}
     */
    @POST("/charges/")
    public Charge createCharge(@Body ChargeInformation information);

    /**
     * Get a transaction's information
     * Returns all the information of a transaction created previously. The only required argument is the charge's uid, that is obtained when creating a charge.
     * The response is the same as the one received when creating a charge.
     *
     * @param uid {@link Charge} unique uid
     * @return a {@link Charge}
     */
    @GET("/charges/{uid}/")
    public Charge getCharge(@Path("uid") String uid);

    /**
     * Get a transaction list
     * Returns a list of previously created charges. The list is ordered by date, the most recent ones being first.
     *
     * @return a list of {@link Charge}
     */
    @GET("/charges/")
    public List<Charge> getCharges();
}
