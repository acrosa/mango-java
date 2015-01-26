package com.mango.client.resources;

import com.mango.entities.CCV;
import com.mango.entities.CCVInformation;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * CCV tokens
 */
public interface CCVS
{
    /**
     * Create a CCV token
     * CCV can only be used one time and expires after 10 minutes.
     *
     * @param ccv A {@link CCV} token
     * @return a {@link CCV}
     */
    @POST("/ccvs/")
    public CCV createCCV(@Body CCVInformation ccv);
}
