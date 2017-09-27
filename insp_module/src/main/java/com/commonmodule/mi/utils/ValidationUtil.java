package com.commonmodule.mi.utils;

/**
 * Created by Kundan on 19-07-2017.
 * Copyright (c) 2014 Kundan. All rights reserved.
 */
public class ValidationUtil {

    public static final boolean isValidString(String charSequence)
    {

        if (charSequence != null && !charSequence.trim().replace(" ","").isEmpty())
        {
            return true;
        }
        else {
            return false;
        }

    }

}
