package com.traveler.utils;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author vgrec, created on 9/5/14.
 */
public class Utils {


    public static <T> T fromJson(Class<T> clazz, String json) {
        try {
            return new ObjectMapper().readValue(json, clazz);
        } catch (IOException e) {
            Log.e("GREC", "Cannot construct object from json", e);
        }
        return null;
    }

    public static <T> String toJson(T object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            Log.e("GREC", "Exception", e);
        }
        return null;
    }

    public static void setColorForTextViewDrawable(int color, TextView... textViews) {
        for (TextView textView : textViews) {
            Drawable[] drawables = textView.getCompoundDrawables();
            Drawable leftDrawable = drawables[0];
            leftDrawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
    }


}