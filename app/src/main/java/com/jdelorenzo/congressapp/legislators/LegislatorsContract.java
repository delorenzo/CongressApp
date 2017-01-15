package com.jdelorenzo.congressapp.legislators;

import com.jdelorenzo.congressapp.model.Legislator;

import java.util.List;

public interface LegislatorsContract {
    interface View {
        void displaySearchResults(List<Legislator> results);
        void showLoadingIndicator();
        void hideLoadingIndicator();
    }

    interface Presenter {
        void getLegislatorsByZip(int zipCode);
        void getAllLegislators();
    }
}
