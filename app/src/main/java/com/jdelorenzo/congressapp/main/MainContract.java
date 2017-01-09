package com.jdelorenzo.congressapp.main;

import com.jdelorenzo.congressapp.model.Legislator;

import java.util.List;

public interface MainContract {
    interface View {
        void displaySearchResults(List<Legislator> results);
        void showLoadingIndicator();
        void hideLoadingIndicator();
    }

    interface Presenter {
        void performSearch(int zipCode);
        void getAllLegislators();
    }
}
