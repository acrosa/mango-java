package com.mango.client.resources;


import com.mango.entities.Refund;
import com.mango.entities.RefundInformation;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

import java.util.List;

public interface Refunds
{
    /**
     * Create a refund
     * Create a refund of a charge created previously. The refund can be partial or total, and can only be one per charge.
     *
     * @param information {@link RefundInformation}
     * @return a charge {@link com.mango.entities.Charge}
     */
    @POST("/refunds/")
    public Refund createRefund(@Body RefundInformation information);

    /**
     * Get refund information
     * Returns all the information related to a previously created refund. The only required argument is the refund uid, that is created when a charge is refunded.
     * The response is the same as when a refund is created.
     *
     * @param uid Card unique identifier
     * @return a Card
     */
    @GET("/refunds/{uid}/")
    public Refund getRefund(@Path("uid") String uid);

    /**
     * Get a refund list
     * Returns a list of refunds created previously. The list is ordered by date, the most recent ones being first.
     *
     * @return a list of cards, the list is ordered by creation date, the first one being the most recent.
     */
    @GET("/refunds/")
    public List<Refund> getRefunds();


}
