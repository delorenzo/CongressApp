package com.jdelorenzo.congressapp.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

/** Committee model. {@see https://sunlightlabs.github.io/congress/committees.html} */
@Entity(tableName = "committees")
public class Committee {
  /**
   * Official name of the committee. Parent committees tend to have a prefix, e.g. “House Committee
   * on”, and subcommittees do not, e.g. “Health”.
   */
  @NonNull String name;
  /**
   * Official ID of the committee, as it appears in various official sources (Senate, House, and
   * Library of Congress).
   */
  @NonNull @PrimaryKey String committeeId;
  /** The chamber this committee is part of. “house”, “senate”, or “joint”. */
  @NonNull String chamber;
  /** The committee’s official website. */
  String url;
  /** The committe’s building and room number. */
  String office;
  /** The committee’s phone number. */
  String phone;
  /** Whether or not the committee is a subcommittee. */
  String subcommittee;
}
