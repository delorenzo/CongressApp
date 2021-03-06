package com.jdelorenzo.congressapp.data;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

/**
 * Class that supplies {@link TypeConverter} methods to {@link android.arch.persistence.room.Entity}
 * objects
 */
public class Converters {
  @TypeConverter
  public static String[] fromString(String value) {
    return new Gson().fromJson(value, String[].class);
  }

  @TypeConverter
  public static String fromStringArray(String[] value) {
    return new Gson().toJson(value);
  }
}
