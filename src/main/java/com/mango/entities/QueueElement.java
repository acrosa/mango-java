package com.mango.entities;

/**
 * A payment queue element
 */
public final class QueueElement
{
    private final String uid;

    private final Boolean live; // Mode in which the queue was made. ex. (false for "Sandbox" mode.)

    private final String resource_type; // Resource type: ex. charge

    private final String resource_uid; // Element unique identifier.

    private final String status; // Element status in the queue: ex. pending, in-progress

    private final String created_at; // Element creation date.

    public QueueElement(String uid, Boolean live, String resource_type, String resource_uid, String status, String created_at) {
        this.uid = uid;
        this.live = live;
        this.resource_type = resource_type;
        this.resource_uid = resource_uid;
        this.status = status;
        this.created_at = created_at;
    }

    public String getUid() {
        return uid;
    }

    public Boolean getLive() {
        return live;
    }

    public String getResource_type() {
        return resource_type;
    }

    public String getResource_uid() {
        return resource_uid;
    }

    public String getStatus() {
        return status;
    }

    public String getCreated_at() {
        return created_at;
    }

    @Override
    public String toString() {
        return String.format("QueueElement[%s , %s, %s, %s, %s, %s]", uid, live, resource_type, resource_uid, status, created_at);
    }
}
