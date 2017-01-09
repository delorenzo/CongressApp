package com.jdelorenzo.congressapp.model;

/** Committee model.  {@see https://sunlightlabs.github.io/congress/committees.html} */
public class Committee {
    /** Official name of the committee. Parent committees tend to have a prefix,
     * e.g. “House Committee on”, and subcommittees do not, e.g. “Health”. */
    String name;
    /** Official ID of the committee, as it appears in various official sources
     * (Senate, House, and Library of Congress). */
    String committeeId;
    /** The chamber this committee is part of. “house”, “senate”, or “joint”. */
    String chamber;
    /** The committee’s official website. */
    String url;
    /** The committe’s building and room number. */
    String office;
    /** The committee’s phone number. */
    String phone;
    /** Whether or not the committee is a subcommittee. */
    String subcommittee;
}
