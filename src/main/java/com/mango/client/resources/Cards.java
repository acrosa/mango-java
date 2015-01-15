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

import com.mango.entities.Card;
import com.mango.entities.CardOwnership;
import com.mango.entities.Customer;
import retrofit.client.Response;
import retrofit.http.*;

import java.util.List;

/**
 * Manage a customer's credit cards.
 */
public interface Cards
{
    /**
     * Get a credit card information
     * Returns all the information relation to a previously created card.
     *
     * @param uid Card unique identifier
     * @return a Card
     */
    @GET("/cards/{uid}/")
    public Card getCard(@Path("uid") String uid);

    /**
     * Get a list of credit cards
     * Returns a list of previously created cards.
     *
     * @return a list of cards, the list is ordered by creation date, the first one being the most recent.
     */
    @GET("/cards/")
    public List<Card> getCards();

    /**
     * Create a card
     * All cards are related to a certain customer.
     *
     * @param ownership A {@link CardOwnership} relationship between a {@link Customer} and a {@link Card}
     * @return a Card
     */
    @POST("/cards/")
    public Card createCard(@Body CardOwnership ownership);

    /**
     * Delete a card
     *
     * @param uid Card unique identifier
     * @return an HTTP response object (204 No Content is usually returned.).
     */
    @DELETE("/cards/{uid}/")
    public Response deleteCard(@Path("uid") String uid);

    /**
     * Add a CCV token to a card (PATCH)
     * Add a new security code (CCV) to a previously created card.
     *
     * @param uid Card unique identifier
     * @param ccv A CCV token.
     */
    @PATCH("/cards/{uid}/")
    public Card addCCV(@Path("uid") String uid, @Body String ccv);
}
