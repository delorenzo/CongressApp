package com.jdelorenzo.congressapp.network;

import com.jdelorenzo.congressapp.model.Bill;
import com.jdelorenzo.congressapp.model.Committee;
import com.jdelorenzo.congressapp.model.District;
import com.jdelorenzo.congressapp.model.Legislator;
import com.jdelorenzo.congressapp.model.LegislatorResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SunlightCongressEndpoint {
    @GET("legislators")
    Call<LegislatorResult> getAllLegislators();

    @GET("legislators/locate")
    Call<LegislatorResult> getLegislatorsByLatLong(@Query("latitude") float latitude, @Query("longitude") float longitude);

    @GET("legislators/locate")
    Call<LegislatorResult> getLegislatorsByZip(@Query("zip") int zipCode);

    @GET("districts/locate")
    Call<List<District>> getDistrictsByLatLong(@Query("latitude") float latitude, @Query("longitude") float longitude);

    @GET("districts/locate")
    Call<List<District>> getDistrictsByZip(@Query("zip") int zipCode);

    @GET("committees")
    Call<List<Committee>> getAssignedCommittees(@Query("legislator") String legislator);

    @GET("committees")
    Call<List<Legislator>> getCommitteeMembers(@Query("committee") String committee, @Query("fields") String members);

    @GET("committees?chamber=joint&subcommittee=false")
    Call<List<Committee>> getJointCommittees();

    @GET("commiteees")
    Call<List<Committee>> getSubcommittees(@Query("parent_committee_id") String committee);

    /** active bills, sorted by most recent */
    @GET("bills?history.active=true&order=last_action_at")
    Call<List<Bill>> getActiveBills();

    @GET("bills/search")
    Call<List<Bill>> searchBills(@Query("query") String search);

    @GET("bills/search")
    Call<List<Bill>> searchLaws(@Query("query") String search, @Query("history.enacted") Boolean enacted);
}
