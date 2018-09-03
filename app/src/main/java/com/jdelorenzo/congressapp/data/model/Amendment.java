package com.jdelorenzo.congressapp.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

/** Amendment model.  {@see https://sunlightlabs.github.io/congress/amendments.html} */
@Entity(tableName = "amendments")
public class Amendment {
    /** The unique ID for this amendment. Formed from the {@link amendmentType}, {@link number},
     * and {@link congress}. */
    @NonNull
    @PrimaryKey
    String amendmentId;

    /** The type for this amendment. For the amendment “H.Amdt. 10”, the amendmentType represents
     * the “H.Amdt.” part. Amendment types can be either hamdt or samdt. */
    String amendmentType;

    /** The number for this amendment. For the amendment “H.Amdt. 10”, the number is 10. */
    int number;

    /** The Congress in which this amendment was introduced.
     * For example, amendments introduced in the “113th Congress” have a congress of 113. */
    int congress;

    /** The chamber in which the amendment was introduced. */
    String chamber;

    /** If the amendment was introduced in the House, this is a relative amendment number,
     * scoped to the bill or treaty the House it relates to. */
    int houseNumber;

    /** The date this amendment was introduced. */
    String introducedOn;

    /** The date or time of the most recent official action on the amendment.
     * Often, there are no official actions, in which case this field will be set to the value
     * of {@link introducedOn}. */
    String lastActionAt;
}
