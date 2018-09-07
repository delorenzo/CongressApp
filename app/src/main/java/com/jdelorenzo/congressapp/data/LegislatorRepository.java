package com.jdelorenzo.congressapp.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.jdelorenzo.congressapp.data.local.CongressDatabase;
import com.jdelorenzo.congressapp.data.model.Legislator;

import java.util.List;

public class LegislatorRepository {
    private LegislatorDao legislatorDao;
    private LiveData<List<Legislator>> legislators;

    public LegislatorRepository(Application application) {
        CongressDatabase db = CongressDatabase.getInstance(application);
        legislatorDao = db.legislatorDao();
        legislators = legislatorDao.getLegislators();
    }

    public LiveData<List<Legislator>> getLegislators() {
        return legislators;
    }
}
