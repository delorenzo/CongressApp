package com.jdelorenzo.congressapp.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.jdelorenzo.congressapp.data.LegislatorDao;
import com.jdelorenzo.congressapp.data.model.Legislator;

/** The Room database that contains the Legislator table */
@Database(
    entities = {Legislator.class},
    version = 1)
public abstract class LegislatorsDatabase extends RoomDatabase {
  private static final String LEGISLATOR_DATABASE_NAME = "Legislator.db";
  private static volatile LegislatorsDatabase INSTANCE;

  public static LegislatorsDatabase getInstance(Context context) {
    if (INSTANCE == null) {
      synchronized (LegislatorsDatabase.class) {
        if (INSTANCE == null) {
          INSTANCE =
              Room.databaseBuilder(
                      context.getApplicationContext(),
                      LegislatorsDatabase.class,
                      LEGISLATOR_DATABASE_NAME)
                  .build();
        }
      }
    }
    return INSTANCE;
  }

  public abstract LegislatorDao legislatorDao();
}
