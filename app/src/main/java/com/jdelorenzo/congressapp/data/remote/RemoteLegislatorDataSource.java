package com.jdelorenzo.congressapp.data.remote;

import com.jdelorenzo.congressapp.data.LegislatorDao;
import com.jdelorenzo.congressapp.data.LegislatorDataSource;
import com.jdelorenzo.congressapp.data.model.Legislator;

import io.reactivex.Flowable;

public class RemoteLegislatorDataSource implements LegislatorDataSource {
  private final LegislatorDao legislatorDao;

  public RemoteLegislatorDataSource(LegislatorDao legislatorDao) {
    this.legislatorDao = legislatorDao;
  }

  @Override
  public Flowable<Legislator> getLegislator() {
    return null;
  }
}
