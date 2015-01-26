package com.mango.client.resources;

import com.mango.entities.QueueElement;
import retrofit.client.Response;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;

/**
 * List and delete items from the payment queue.
 */
public interface Queue
{
    /**
     * Returns all the information related to a queue element.
     * The only required argument is the uid.
     *
     * @return a @{link QueueElement}
     */
    @GET("/queue/{uid}/")
    public QueueElement getQueueElement(@Path("uid") String uid);

    /**
     * Get a list of queue elements
     * Returns a list of queue elements.
     * The list is ordered by creation date, with the most recent one being first.
     *
     * @return a list of @{link QueueElement}
     */
    @GET("/queue/")
    public List<QueueElement> getQueueElements();

    /**
     * Delete an element from the queue
     *
     * @param uid Queue unique identifier.
     * @return an HTTP response object (204 No Content is usually returned.).
     */
    @DELETE("/queue/{uid}/")
    public Response deleteQueueElement(@Path("uid") String uid);

    /**
     * Delete all elements from the queue
     *
     * @return an HTTP response object (204 No Content is usually returned.).
     */
    @DELETE("/queue/")
    public Response deleteAllQueueElements();
}
