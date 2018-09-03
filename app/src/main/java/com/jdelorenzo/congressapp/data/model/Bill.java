package com.jdelorenzo.congressapp.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

/** Bill model. {@see https://sunlightlabs.github.io/congress/bills.html} */
@Entity(tableName = "bills")
public class Bill {
  /**
   * The unique ID for this bill. Formed from the {@link billType}, {@link number}, and {@link
   * congress}.
   */
  @NonNull @PrimaryKey String billId;
  /**
   * The type for this bill. For the bill “H.R. 4921”, the type represents the “H.R.” part. Bill
   * types can be: hr, hres, hjres, hconres, s, sres, sjres, sconres.
   */
  @NonNull String billType;
  /** The number for this bill. For the bill “H.R. 4921”, the number is 4921. */
  @NonNull String number;
  /**
   * The Congress in which this bill was introduced. For example, bills introduced in the “111th
   * Congress” have a congress of 111.
   */
  String congress;
  /** The chamber in which the bill originated. */
  String chamber;
  /** The date this bill was introduced. */
  String introducedOn;
  /**
   * The date or time of the most recent official action. In the rare case that there are no
   * official actions, this field will be set to the value of {@link introducedOn}.
   */
  String lastActionAt;
  /** The date or time of the most recent vote on this bill. */
  String lastVoteAt;
  /**
   * The date the last version of this bill was published. This will be set to the {@link
   * introducedOn} date until an official version of the bill’s text is published.
   */
  String lastVersionOn;
}
