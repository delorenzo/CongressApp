package com.jdelorenzo.congressapp.data.model;

import android.arch.persistence.room.Entity;

import io.reactivex.annotations.NonNull;

/** District model. {@see https://sunlightlabs.github.io/congress/districts.html} */
@Entity(tableName = "districts")
public class District {
  /** The two-letter state code of the state this district is in. */
  @NonNull String state;
  /**
   * The number of the congressional district. For “At Large” districts, where a state has only one
   * representative, the district number is 0
   */
  int district;
}
