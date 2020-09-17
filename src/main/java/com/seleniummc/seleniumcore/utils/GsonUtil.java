package com.seleniummc.seleniumcore.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil
{
    private static Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();

    public static Gson getInstance(){
        return gson;
    }

}
