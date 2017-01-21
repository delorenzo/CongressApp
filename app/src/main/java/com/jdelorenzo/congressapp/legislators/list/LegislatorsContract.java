package com.jdelorenzo.congressapp.legislators.list;

import com.jdelorenzo.congressapp.model.Legislator;

import java.util.List;

interface LegislatorsContract {
    interface View {
        void displaySearchResults(List<Legislator> results);
        void showLoadingIndicator();
        void hideLoadingIndicator();
    }

    interface Presenter {
        void getMyLegislators();
        void getLegislatorsByFilter(LegislatorFilter filter);
        void getLegislatorsByZip(int zipCode);
        void getAllLegislators();
        void onLegislatorSelected(Legislator legislator);
    }
}
