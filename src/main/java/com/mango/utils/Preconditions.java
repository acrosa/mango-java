package com.mango.utils;

import java.util.regex.Pattern;

/**
 * Utils for checking preconditions and invariants
 *
 * @author Alejandro Crosa, based on Pablo Fernandez's code from scribe-java
 */
public final class Preconditions
{
    private static final String DEFAULT_MESSAGE = "Received an invalid parameter";

    private Preconditions(){}

    /**
     * Checks that an object is not null.
     *
     * @param object any object
     * @param errorMsg error message
     *
     * @throws IllegalArgumentException if the object is null
     */
    public static void checkNotNull(Object object, String errorMsg)
    {
        check(object != null, errorMsg);
    }

    /**
     * Checks that a string is not null or empty
     *
     * @param string any string
     * @param errorMsg error message
     *
     * @throws IllegalArgumentException if the string is null or empty
     */
    public static void checkEmptyString(String string, String errorMsg)
    {
        check(string != null && !string.trim().equals(""), errorMsg);
    }

    private static void check(boolean requirements, String error)
    {
        String message = (error == null || error.trim().length() <= 0) ? DEFAULT_MESSAGE : error;
        if (!requirements)
        {
            throw new IllegalArgumentException(message);
        }
    }
}
