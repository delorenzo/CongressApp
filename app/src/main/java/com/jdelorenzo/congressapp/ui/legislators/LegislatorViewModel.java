package com.jdelorenzo.congressapp.ui.legislators;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.jdelorenzo.congressapp.data.LegislatorRepository;
import com.jdelorenzo.congressapp.data.model.Legislator;

import java.util.List;

/**
 *  {@link AndroidViewModel} for displaying a {@link Legislator}
 */
public class LegislatorViewModel extends AndroidViewModel {
    private LegislatorRepository legislatorRepository;
    private LiveData<List<Legislator>> legislators;

    public LegislatorViewModel(Application application) {
        super(application);
        legislatorRepository = new LegislatorRepository(application);
        legislators = legislatorRepository.getLegislators();
    }

    public LiveData<List<Legislator>> getLegislators() { return legislators; }
}
