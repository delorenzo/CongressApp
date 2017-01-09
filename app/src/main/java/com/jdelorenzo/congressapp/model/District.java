package com.jdelorenzo.congressapp.model;

/** District model.  {@see https://sunlightlabs.github.io/congress/districts.html} */
public class District {
    /** The two-letter state code of the state this district is in. */
    String state;
    /** The number of the congressional district. For “At Large” districts,
     * where a state has only one representative, the district number is 0 */
    int district;
}
