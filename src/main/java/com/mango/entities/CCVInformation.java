package com.mango.entities;

public final class CCVInformation
{
    private final String ccv;

    public CCVInformation(String ccv) {
        this.ccv = ccv;
    }

    public String getCcv() {
        return ccv;
    }

    @Override
    public String toString() {
        return String.format("CCVInformation[%s]", ccv);
    }
}
