package com.jdelorenzo.congressapp.model;

/** Legislator model.  {@see https://sunlightlabs.github.io/congress/legislators.html} */
public class Legislator {
    /** Identifier for this member in various Congressional sources. Originally taken from the
     * Congressional Biographical Directory, but used in many places.
     * If you’re going to pick one ID as a Congressperson’s unique ID, use this. */
    public String bioguideId;
    /** The date of this legislator’s birthday. */
    public String birthday;
    /** Chamber the member is in. “senate” or “house”. */
    public String chamber;
    public String contactForm;
    /** Identifier for this member as it appears on CRP’s OpenSecrets
     * {@see https://www.opensecrets.org/} */
    public String crpId;
    /** (House only) The number of the district that a House member represents. */
    public int district;
    /** The Facebook username or ID for a member’s official legislative Facebook presence.
     * ID numbers and usernames can be used interchangeably in Facebook’s URLs and APIs.
     * The referenced account may be either a Facebook page or a user account.
     * All social media account values can be turned into URLs by preceding them with the
     * domain name of the service in question:
     * http://twitter.com/[username]
     * http://youtube.com/[username or channel ID]
     * http://facebook.com/[username or ID] */
    public String facebookId;
    /** Fax number */
    public String fax;
    /** A list of identifiers for this member as they appear in filings at the
     * Federal Election Commission. {@see http://fec.gov/}*/
    public String fecIds;
    public String firstName;
    /** First letter of this member’s gender. “M” or “F”. */
    public String gender;
    /** Identifier for this member as it appears on {@see https://www.govtrack.us} */
    public String govtrackId;
    /** Identifier for this member as it is maintained by the Inter-university
     * Consortium for Political and Social Research. {@see http://www.icpsr.umich.edu/icpsrweb/}*/
    public String icpsrId;
    /** Whether a legislator is currently holding elected office in Congress. */
    public boolean inOffice;
    public String lastName;
    public String leadershipRole;
    /** Identifier for this member as it appears on some of Congress’ data systems
     * (namely Senate votes). */
    public String lisId;
    public String middleName;
    public String nameSuffix;
    public String nickname;
    /** Identifier for this member across all countries and levels of government,
     * as defined by the Open Civic Data project. */
    public String ocdId;
    /** Office address */
    public String office;
    /** First letter of the party this member belongs to. “R”, “D”, or “I”. */
    public String party;
    public boolean isDemocrat() { return party.equals("D"); }
    public boolean isRepublican() { return party.equals("R"); }
    public boolean isIndependent() { return party.equals("I"); }
    /** Phone number */
    public String phone;
    /** Which senate “class” the member belongs to (1, 2, or 3).
     * Every 2 years, a separate one third of the Senate is elected to a 6-year term.
     * Senators of the same class face election in the same year.
     * Blank for members of the House. */
    public String senateClass;
    /** Two-letter code of the state this member represents. */
    public String state;
    /** The full state name of the state this member represents. */
    public String stateName;
    /** (Senate only) The seniority of that Senator for that state. “junior” or “senior”. */
    public String stateRank;
    /** The date a member’s current term started. */
    public String termStart;
    /** The date a member’s current term will end. */
    public String termEnd;
    /** Identifier for this member as it appears on THOMAS.gov and Congress.gov. */
    public String thomasId;
    /** Title of this member. “Sen”, “Rep”, “Del”, or “Com”. */
    public String title;
    /** The Twitter username for a member’s official legislative account. This field does not
     * contain the handles of campaign accounts. */
    public String twitterId;
    /** Identifier for this member as it appears on Project Vote Smart
     * {@see https://votesmart.org/} */
    public String votesmartId;
    /** Website address */
    public String website;
    /** The YouTube username or channel for a member’s official legislative account. This field
     *  does not contain the handles of campaign accounts. A few legislators use YouTube “channels”
     *  instead of regular accounts. These channels will be of the form channel/[id]. */
    public String youtubeId;
}
