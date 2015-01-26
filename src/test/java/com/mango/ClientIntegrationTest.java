package com.mango;

import com.mango.client.MangoClient;
import com.mango.entities.*;

import java.util.List;

import com.mango.utils.Preconditions;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Category(IntegrationTest.class)
public class ClientIntegrationTest
{
    private static final Logger logger = LoggerFactory.getLogger(ClientIntegrationTest.class);
    /**
     * NOTE: you need to add your api key and secret found on Mango's website here: https://panel.getmango.com
     */
    final String apiKey = null;
    final String apiSecret = null;

    private Token getToken(MangoClient client)
    {
        /**
         * Get a credit card token to make a charge.
         */
        final String valid_card_with_funds = "4507990000000010";
        final CardInformation information = new CardInformation(valid_card_with_funds, 12, 2017, "Test Visa", Card.CardType.VISA, 123);
        logger.info("Creating token based with valid fake credit card information: {}", information);
        final Token token = client.tokens.createToken(information);
        logger.info("Successfully created token: {}", token);
        return token;
    }

    /**
     * Tests a bunch of api endpoints, typically representing a transaction and charge.
     *
     * @throws Exception
     */
    @Test
    public void testAgainstSandboxAPI() throws Exception
    {

        final String error = "NOTE: you need to add your api key and secret found on Mango's website here: https://panel.getmango.com";
        Preconditions.checkNotNull(apiKey, error);
        Preconditions.checkNotNull(apiSecret, error);

        logger.info("Running integration tests against the mango API.");

        /**
         * Create client
         */
        final MangoClient client = new MangoClient(apiKey, apiSecret);
        final Token token = getToken(client);
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
        final ChargeInformation chargeInformation = ChargeInformation.CardChargeInformation(2000, card.getUid());
        logger.info("Create a charge: {}", chargeInformation);
        final Charge charge = client.charges.createCharge(chargeInformation);
        logger.info("Successfully charged: {}", charge);

        /**
         * Refund last charge
         */
        logger.info("Refunding last charge: {}", charge);
        final RefundInformation refundInformation = new RefundInformation(charge.getUid(), 1000);
        final Refund refund = client.refunds.createRefund(refundInformation);
        logger.info("Successfully refunded last charge: {} refund: {}", charge, refund);

        /**
         * Return last installments
         */
        logger.info("Returning last intallments");
        final List<Installment> installments = client.installments.getInstallments(2000, Card.CardType.VISA);
        logger.info("Successfully returned list of last installments: {}", installments);

        logger.info("All done. Happy charging.");
    }

    /**
     * Tests a bunch of api endpoints, typically representing a transaction and charge.
     *
     * @throws Exception
     */
    @Test
    public void testAgainstSandboxAPIWithNoAPISecret() throws Exception
    {

        final String error = "NOTE: you need to add your api key and secret found on Mango's website here: https://panel.getmango.com";
        Preconditions.checkNotNull(apiKey, error);

        logger.info("Running integration tests against the mango API with no API Secret.");

        /**
         * Create client
         */
        final MangoClient client = new MangoClient(apiKey);
        getToken(client);

        if (client.cards != null) {
            throw new Exception("Expected cards to be null when no API secret is provided");
        }
        if (client.customers != null) {
            throw new Exception("Expected customers to be null when no API secret is provided");
        }
        if (client.charges != null) {
            throw new Exception("Expected charges to be null when no API secret is provided");
        }
        if (client.refunds != null) {
            throw new Exception("Expected refunds to be null when no API secret is provided");
        }
        logger.info("All done. Happy charging.");
    }
}
