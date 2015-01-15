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

import com.mango.entities.Customer;
import com.mango.entities.CustomerInformation;
import retrofit.client.Response;
import retrofit.http.*;

public interface Customers
{
    /**
     * Get a credit card information
     * Returns all the information relation to a previously created card.
     *
     * @param information {@link CustomerInformation}
     * @return {@link Customer}
     */
    @POST("/customers/")
    public Customer createCustomer(@Body CustomerInformation information);

    /**
     * Get a credit card information
     * Returns all the information relation to a previously created card.
     *
     * @param uid Card unique identifier
     * @return {@link Customer}
     */
    @GET("/customers/{uid}/")
    public Customer getCustomer(@Path("uid") String uid);

    /**
     * Get the customer's list
     * Returns a list of all previously created customers. The list is ordered by creation date, the most recents first.
     *
     * @return a list of {@link Customer}
     */
    @GET("/customers/")
    public Customer getCustomers();

    /**
     * Edit a customer
     * @param information {@link CustomerInformation}
     * @return {@link Customer}
     */
    @PATCH("/customers/{uid}/")
    public Customer updateCustomer(@Path("uid") String uid, @Body CustomerInformation information);

    /**
     * Delete a customer
     *
     * @param uid {@link Customer} unique identifier
     * @return an HTTP response object (204 No Content is usually returned.).
     */
    @DELETE("/customers/{uid}/")
    public Response deleteCustomer(@Path("uid") String uid);
}
