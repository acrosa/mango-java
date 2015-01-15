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

import com.mango.entities.Token;
import com.mango.entities.CardInformation;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Create a secure token with a credit card's information.
 */
public interface Tokens
{
    /**
     * Creating a token.
     * Tokens can only be used one time, and expire after 10 minutes of being created.
     *
     * @param information all the {@link CardInformation}
     * @return Token a temporary token based on the credit card
     */
    @POST("/tokens/")
    public Token createToken(@Body CardInformation information);
}
