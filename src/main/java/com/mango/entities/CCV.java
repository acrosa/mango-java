package com.mango.entities;

/**
 * A CCV token
 */
public final class CCV
{
    private final String uid;

    private final String created_at; // time the ccv was created in the system

    public CCV(String uid, String created_at) {
        this.uid = uid;
        this.created_at = created_at;
    }

    public CCV(String uid) {
        this(uid, null);
    }

    public String getUid() {
        return uid;
    }

    public String getCreated_at() {
        return created_at;
    }

    @Override
    public String toString() {
        return String.format("CCV[%s , %s]", uid, created_at);
    }
}
