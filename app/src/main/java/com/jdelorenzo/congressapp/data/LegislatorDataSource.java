package com.jdelorenzo.congressapp.data;

import com.jdelorenzo.congressapp.data.model.Legislator;

import io.reactivex.Flowable;

public interface LegislatorDataSource {
  Flowable<Legislator> getLegislator();
}
