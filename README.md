# Java client for Mango (getmango.com)

[![Build Status](https://travis-ci.org/acrosa/mango-java2.svg?branch=master)](https://travis-ci.org/acrosa/mango-java2)

### Getting Started

```java
// NOTE: you need to add your api key and secret found on Mango's website here: https://panel.getmango.com
final String apiKey = "YOUR_API_KEY";
final String apiSecret = "YOUR_API_SECRET";

/**
 * Create client
 */
final MangoClient client = new MangoClient(apiKey, apiSecret);

/**
 * Get a credit card token to make a charge.
 */
final CardInformation information = new CardInformation("4507990000000010", 12, 2017, "Test Visa", Card.CardType.VISA, 123);
logger.info("Creating token based with valid fake credit card information: {}", information);
final Token token = client.tokens.createToken(information);
logger.info("Successfully created token: {}", token);

/**
 * Create a customer with a credit card token associated (default card)
 */
final CustomerInformation customerInformation = new CustomerInformation("someone@email.com", "Alejandro", token.getUid(), "");
logger.info("Creating customer: {}", customerInformation);
final Customer customer = client.customers.createCustomer(customerInformation);
logger.info("Successfully created customer: {}", customer);

/**
 * Get all Cards
 */
logger.info("Getting all cards stored.");
final List<Card> cards = client.cards.getCards();
logger.info("Successfully got all cards stored. total: {} cards: {}", cards.size(), cards);

/**
 * Get a specific card
 */
logger.info("Getting a specific card.");
final Card card = client.cards.getCard(cards.get(0).getUid());
logger.info("Successfully got a card: {}", card);

/**
 * Charge a card with some amount
 */
final ChargeInformation chargeInformation = ChargeInformation.CardChargeInformation(200, card.getUid());
logger.info("Create a charge: {}", chargeInformation);
final Charge charge = client.charges.createCharge(chargeInformation);
logger.info("Successfully charged: {}", charge);

```

# Android client for Mango (getmango.com)

### Getting Started

```java
// NOTE: you need to add your api key found on Mango's website here: https://panel.getmango.com
final String apiKey = "YOUR_API_KEY";

/**
 * Create client
 */
final MangoClient client = new MangoClient(apiKey);

/**
 * Get a credit card token to make a charge.
 */
final CardInformation information = new CardInformation("4507990000000010", 12, 2017, "Test Visa", Card.CardType.VISA, 123);
logger.info("Creating token based with valid fake credit card information: {}", information);
final Token token = client.tokens.createToken(information);
logger.info("Successfully created token: {}", token);

```

Now the token needs to be sent to a server to handle.

### Integration tests

To run the integration tests, edit ClientIntegrationTest.java and add your Mango public key and secret (sandbox mode), then run `mvn test`. This will make live calls to Mango's API.

### License
```
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
```
