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
package com.mango.client;

import com.mango.client.resources.*;
import com.mango.utils.Preconditions;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Implements a simple mango client.
 *
 * @author Alejandro Crosa
 */
public final class MangoClient
{
    private static final String DEFAULT_API_URL = "https://api.getmango.com/v1";

    public final Tokens tokens;
    public final Cards cards;
    public final Customers customers;
    public final Charges charges;
    public final Refunds refunds;

    /**
     * Creates a new simple mango client.
     *
     * @param apiPublicKey public API Key
     * @param apiSecret secret API key
     */
    public MangoClient(String apiPublicKey)
    {
        this.tokens = createTokens(apiPublicKey);
        this.cards = null;
        this.customers = null;
        this.charges = null;
        this.refunds = null;
    }

    public MangoClient(String apiPublicKey, String apiSecret)
    {
        Preconditions.checkNotNull(apiSecret, "API Secret can't be null");

        this.tokens = createTokens(apiPublicKey);

        final RestAdapter restPrivateAdapter = defaultAdapter(apiSecret);
        this.cards = restPrivateAdapter.create(Cards.class);
        this.customers = restPrivateAdapter.create(Customers.class);
        this.charges = restPrivateAdapter.create(Charges.class);
        this.refunds = restPrivateAdapter.create(Refunds.class);
    }

    private Tokens createTokens(String apiPublicKey)
    {
        Preconditions.checkNotNull(apiPublicKey, "API Key can't be null");

        final RestAdapter restPublicAdapter = defaultAdapter(apiPublicKey);

        return restPublicAdapter.create(Tokens.class);
    }
    private static RestAdapter defaultAdapter(String key)
    {
        return new RestAdapter.Builder()
                .setEndpoint(DEFAULT_API_URL)
                .setRequestInterceptor(defaultRequestInterceptor(key))
                .build();
    }

    private static RequestInterceptor defaultRequestInterceptor(String apiSecret)
    {
        // add authentication header field
        final String authStringEncoded = Base64.encode(apiSecret.getBytes());
        final String authHeader = "Basic " + authStringEncoded;

        // build interceptor with all http headers
        return new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("User-Agent", "mango-java");
                request.addHeader("Authorization", authHeader);
            }
        };
    }
}
