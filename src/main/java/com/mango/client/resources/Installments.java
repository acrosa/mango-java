package com.mango.client.resources;

import com.mango.entities.Installment;
import retrofit.http.GET;
import retrofit.http.Query;

import java.util.List;

public interface Installments
{
    /**
     * Get an issuer's installment and interests (GET)
     *
     * @return a list of @{link Installment}
     */
    @GET("/cards/")
    public List<Installment> getInstallments(@Query("amount") Integer amount, @Query("cardtype") String cardtype);
}
